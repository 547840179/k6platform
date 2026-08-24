package xia.wenjie.k6platform.k6platform.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.k6platform.k6platform.pojo.Companydepartment;
import xia.wenjie.k6platform.k6platform.service.CompanydepartmentServer;
import xia.wenjie.k6platform.k6platform.util.Result;

import java.util.List;

@Api(tags = "部门控制器")
@RestController
@RequestMapping("/sms/companydepartmentController")
public class CompanydepartmentController {
    @Autowired
    private CompanydepartmentServer companydepartmentServer;

    @ApiOperation("分页获取所有部门信息【带条件】")
    @GetMapping("/getCompanydepartmentByOpr/{pageNo}/{pageSize}")
    public Result getCompanydepartmentByOpr(@ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
                                            @ApiParam("页大小") @PathVariable("pageSize") Integer pageSize,
                                            @ApiParam("查询条件") Companydepartment companydepartment) {
        Page<Companydepartment> page = new Page<>(pageNo, pageSize);
        IPage<Companydepartment> iPage = companydepartmentServer.getCompanydepartmentByOpr(page, companydepartment);
        return Result.ok(iPage);
    }

    @ApiOperation("保存或者修改部门器信息")
    @PostMapping("/saveOrUpdateCompanydepartment")
    public Result saveOrUpdateCompanydepartment(
            @ApiParam("JSON转换后端部门数据模型") @RequestBody Companydepartment companydepartment
    ){
        companydepartmentServer.saveOrUpdate(companydepartment);
        return Result.ok();
    }

    @ApiOperation("删除一个或者多个部门信息")
    @DeleteMapping("/deleteCompanydepartment")
    public Result deleteCompanydepartmentByIds(
            @ApiParam("多个部门id的JSON") @RequestBody List<Integer> ids
    ){
        companydepartmentServer.removeByIds(ids);
        return Result.ok();
    }

    @ApiOperation("获取所有部门的JSON")
    @GetMapping("/getCompanydepartment")
    public Result getCompanydepartment(){
        List<Companydepartment> companydepartmentList = companydepartmentServer.getCompanydepartment();
        return Result.ok(companydepartmentList);
    }
}
