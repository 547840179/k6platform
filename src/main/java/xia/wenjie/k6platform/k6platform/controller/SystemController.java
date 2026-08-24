package xia.wenjie.k6platform.k6platform.controller;


import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import xia.wenjie.k6platform.k6platform.pojo.Admin;
import xia.wenjie.k6platform.k6platform.pojo.LoginForm;
import xia.wenjie.k6platform.k6platform.pojo.Operations;
import xia.wenjie.k6platform.k6platform.pojo.Tester;
import xia.wenjie.k6platform.k6platform.service.AdminService;
import xia.wenjie.k6platform.k6platform.service.OperationsService;
import xia.wenjie.k6platform.k6platform.service.TesterService;
import xia.wenjie.k6platform.k6platform.util.CreateVerifiCodeImage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.k6platform.k6platform.util.JwtHelper;
import xia.wenjie.k6platform.k6platform.util.Result;
import xia.wenjie.k6platform.k6platform.util.ResultCodeEnum;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Api(tags = "系统控制器")
@RestController
@RequestMapping("/sms/system")
public class SystemController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private TesterService testerService;
    @Autowired
    private OperationsService operationsService;


    @ApiOperation("通过token获取用户信息")
    @GetMapping("/getInfo")
    public Result getUserInfoByToken(HttpServletRequest request, @RequestHeader("token") String token) {
        // 获取用户中请求的token
        // 检查token 是否过期 20H
        boolean isEx = JwtHelper.isExpiration(token);
        if (isEx) {
            return Result.build(null, ResultCodeEnum.TOKEN_ERROR);
        }
        // 解析token,获取用户id和用户类型
        Long userId = JwtHelper.getUserId(token);
        Integer userType = JwtHelper.getUserType(token);
        // 准备一个Map集合用于存响应的数据
        Map<String, Object> map = new HashMap<>();
        switch (userType) {
            case 1:
                Admin admin = adminService.getAdminById(userId.intValue());
                map.put("user", admin);
                map.put("userType", 1);
                break;
            case 2:
                Tester tester = testerService.getTesterById(userId.intValue());
                map.put("user", tester);
                map.put("userType", 1);
                break;
            case 3:
                Operations operations = operationsService.getOperationsById(userId.intValue());
                map.put("user", operations);
                map.put("userType", 1);
                break;
        }
        return Result.ok(map);

    }


    @ApiOperation("获取验证码图片")
    @GetMapping("/getVerifiCodeImage")
    public void getVerifiCodeImage(HttpServletRequest request, HttpServletResponse response) {
        //获取验证码图片
        BufferedImage verifiCodeImage = CreateVerifiCodeImage.getVerifiCodeImage();
        //获取验证码字符串
        String verifiCode = String.valueOf(CreateVerifiCodeImage.getVerifiCode());

        /*将验证码放入当前请求域*/
        request.getSession().setAttribute("verifiCode", verifiCode);
        try {
            //将验证码图片通过输出流做出响应
            ImageIO.write(verifiCodeImage, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @ApiOperation("头像上传统一入口")
    @PostMapping("/headerImgUpload")
    public Result headerImgUpload(
            @ApiParam("文件二进制数据") @RequestPart("multipartFile") MultipartFile multipartFile
    ) {

        //使用UUID随机生成文件名
        String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        //生成新的文件名字
        String filename = uuid.concat(multipartFile.getOriginalFilename());
        //生成文件的保存路径(实际生产环境这里会使用真正的文件存储服务器)
        String portraitPath = "E:/k6platform/src/main/resources/public/".concat(filename);
        //保存文件  E:/k6platform/target/classes/public/
        try {
            multipartFile.transferTo(new File(portraitPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String headerImg = filename;
        return Result.ok(headerImg);
    }

    @ApiOperation("登录请求验证")
    @PostMapping("/login")
    public Result login(@RequestBody LoginForm loginForm, HttpServletRequest request) {
        // 获取用户提交的验证码和session域中的验证码
        HttpSession session = request.getSession();
        // String systemVerifiCode =(String) session.getAttribute("verifiCode");
        String systemVerifiCode = "123456";
        String loginVerifiCode = loginForm.getVerifiCode();
        if ("".equals(systemVerifiCode)) {
            // session过期,验证码超时,
            return Result.fail().message("验证码失效,请刷新后重试");
        }
        if (!loginVerifiCode.equalsIgnoreCase(systemVerifiCode)) {
            // 验证码有误
            return Result.fail().message("验证码有误,请刷新后重新输入");
        }
        // 验证码使用完毕,移除当前请求域中的验证码
        session.removeAttribute("verifiCode");

        // 准备一个Map集合,用户存放响应的信息
        Map<String, Object> map = new HashMap<>();
        // 根据用户身份,验证登录的用户信息
        switch (loginForm.getUserType()) {
            case 1:// 管理员身份
                try {
                    Admin login = adminService.login(loginForm);
                    if (null != login) {
                        // 登录成功,将用户id和用户类型转换为token口令,作为信息响应给前端
                        map.put("token", JwtHelper.createToken(login.getId().longValue(), 1));
                    } else {
                        throw new RuntimeException("用户名或者密码有误!");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    // 捕获异常,向用户响应错误信息
                    return Result.fail().message(e.getMessage());
                }

            case 2:// 测试身份
                try {
                    Tester login = testerService.login(loginForm);
                    if (null != login) {
                        // 登录成功,将用户id和用户类型转换为token口令,作为信息响应给前端
                        map.put("token", JwtHelper.createToken(login.getId().longValue(), 2));
                    } else {
                        throw new RuntimeException("用户名或者密码有误!");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    // 捕获异常,向用户响应错误信息
                    return Result.fail().message(e.getMessage());
                }
            case 3:// 运维
                try {
                    Operations login = operationsService.login(loginForm);
                    if (null != login) {
                        // 登录成功,将用户id和用户类型转换为token口令,作为信息响应给前端
                        map.put("token", JwtHelper.createToken(login.getId().longValue(), 3));
                    } else {
                        throw new RuntimeException("用户名或者密码有误!");
                    }
                    return Result.ok(map);
                } catch (RuntimeException e) {
                    e.printStackTrace();
                    return Result.fail().message(e.getMessage());
                }
        }
        return Result.fail().message("查无此用户");
    }
}
