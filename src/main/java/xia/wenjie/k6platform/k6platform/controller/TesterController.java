package xia.wenjie.k6platform.k6platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.k6platform.k6platform.pojo.K6script;
import xia.wenjie.k6platform.k6platform.pojo.Tester;
import xia.wenjie.k6platform.k6platform.service.TesterService;
import xia.wenjie.k6platform.k6platform.util.MD5;
import xia.wenjie.k6platform.k6platform.util.Result;

import java.util.List;

@Api(tags = "测试   控制器")
@RestController
@RequestMapping("/sms/testerController")
public class TesterController {
    @Autowired
    private TesterService taService;

    @ApiOperation("分页获取所有Tester信息【带条件】")
    @GetMapping("/getAllTester/{pageNo}/{pageSize}")
    public Result getAllTester(@ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
                              @ApiParam("页大小")@PathVariable("pageSize") Integer pageSize,
                              @ApiParam("查询条件") Tester tester) {
        Page<Tester> pageParam = new Page<>(pageNo,pageSize);
        IPage<Tester> page = taService.getTesterByOpr(pageParam, tester);
        return Result.ok(page);
    }

    @ApiOperation("添加或修改Tester信息")
    @PostMapping("/saveOrUpdateTester")
    public Result saveOrUpdateTester(@RequestBody Tester tester){
        if (!Strings.isEmpty(tester.getPassword())) {
            tester.setPassword(MD5.encrypt(tester.getPassword()));
        }
        taService.saveOrUpdate(tester);
        return Result.ok();
    }

    @ApiOperation("删除Tester信息 一个或多个")
    @DeleteMapping("/deleteTesterById")
    public Result deleteTesterById(@ApiParam("多个tester Id的json")@RequestBody List<Integer> ids){
        taService.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("获取所有Tester的JSON")
    @GetMapping("/getTesters")
    public Result getTesters() {
        List<Tester> testersList = taService.getTesters();
        return Result.ok(testersList);
    }

}
