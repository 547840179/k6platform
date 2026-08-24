package xia.wenjie.k6platform.k6platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.k6platform.k6platform.pojo.Companydepartment;
import xia.wenjie.k6platform.k6platform.pojo.K6script;
import xia.wenjie.k6platform.k6platform.service.K6scriptService;
import xia.wenjie.k6platform.k6platform.util.Result;

import java.util.List;

@Api(tags = "脚本 控制器")
@RestController
@RequestMapping("/sms/k6scriptController")
public class K6scriptController {

    @Autowired
    private K6scriptService k6scriptService;

    @ApiOperation("分页获取所有 脚本 信息【带条件】")
    @GetMapping("/getK6scriptByOpr/{pageNo}/{pageSize}")
    public Result getK6scriptByOpr(@ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
                                   @ApiParam("页大小") @PathVariable("pageSize") Integer pageSize,
                                   @ApiParam("查询条件") K6script k6script) {
        Page<K6script> page = new Page<>(pageNo, pageSize);
        IPage<K6script> iPage = k6scriptService.getK6scriptByOpr(page, k6script);
        return Result.ok(iPage);
    }


    @ApiOperation("保存或者修改脚本信息")
    @PostMapping("/saveOrUpdateK6script")
    public Result saveOrUpdateK6script(@ApiParam("JSON转换后端脚本数据模型") @RequestBody K6script k6script) {
        k6scriptService.saveOrUpdate(k6script);
        return Result.ok();
    }

    @ApiOperation("获取所有脚本的JSON")
    @GetMapping("/getk6script")
    public Result getk6script() {
        List<K6script> k6scriptList = k6scriptService.getk6script();
        return Result.ok(k6scriptList);
    }


    @ApiOperation("删除k6script信息 一个或多个")
    @DeleteMapping("/deletek6scriptById")
    public Result deletek6scriptById(@ApiParam("多个脚本 Id的json") @RequestBody List<Integer> ids) {
        k6scriptService.removeByIds(ids);
        return Result.ok();
    }

}



