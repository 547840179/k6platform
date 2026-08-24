package xia.wenjie.k6platform.k6platform.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.k6platform.k6platform.pojo.Operations;
import xia.wenjie.k6platform.k6platform.pojo.Tester;
import xia.wenjie.k6platform.k6platform.service.OperationsService;
import xia.wenjie.k6platform.k6platform.util.MD5;
import xia.wenjie.k6platform.k6platform.util.Result;

import java.util.List;

@Api(tags = "运维   控制器")
@RestController
@RequestMapping("/sms/operationsController")
public class OperationsController {
    @Autowired
    private OperationsService operationsService;

    @ApiOperation("分页获取所有Operations信息【带条件】")
    @GetMapping("/getAllOperations/{pageNo}/{pageSize}")
    public Result getAllTester(@ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
                               @ApiParam("页大小")@PathVariable("pageSize") Integer pageSize,
                               @ApiParam("查询条件") Operations operations) {
        Page<Operations> pageParam = new Page<>(pageNo,pageSize);
        IPage<Operations> page = operationsService.getOperationsByOpr(pageParam, operations);
        return Result.ok(page);
    }

    @ApiOperation("添加或修改Operations信息")
    @PostMapping("/saveOrUpdateOperations")
    public Result saveOrUpdateTester(@RequestBody Operations operations){
        if (!Strings.isEmpty(operations.getPassword())) {
            operations.setPassword(MD5.encrypt(operations.getPassword()));
        }
        operationsService.saveOrUpdate(operations);
        return Result.ok();
    }

    @ApiOperation("删除Operations信息 一个或多个")
    @DeleteMapping("/deleteOperationsById")
    public Result deleteOperationsById(@ApiParam("多个Operations Id的json")@RequestBody List<Integer> ids){
        operationsService.removeByIds(ids);
        return Result.ok();
    }


}
