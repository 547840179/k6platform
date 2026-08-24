package xia.wenjie.k6platform.k6platform.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xia.wenjie.k6platform.k6platform.pojo.K6script;
import xia.wenjie.k6platform.k6platform.pojo.Report;
import xia.wenjie.k6platform.k6platform.service.ReportService;
import xia.wenjie.k6platform.k6platform.util.Result;

import java.util.List;

@Api(tags = "报告  控制器")
@RestController
@RequestMapping("/sms/reportController")
public class ReportController {
    @Autowired
    private ReportService reportService;



    @ApiOperation("分页获取所有 报告 信息【带条件】")
    @GetMapping("/getReportByOpr/{pageNo}/{pageSize}")
    public Result getK6scriptByOpr(@ApiParam("页码数") @PathVariable("pageNo") Integer pageNo,
                                   @ApiParam("页大小") @PathVariable("pageSize") Integer pageSize,
                                   @ApiParam("查询条件") Report report) {
        Page<Report> page = new Page<>(pageNo, pageSize);
        IPage<Report> iPage = reportService.getReportByOpr(page, report);
        return Result.ok(iPage);
    }


    @ApiOperation("保存或者修改报告信息")
    @PostMapping("/saveOrUpdateReport")
    public Result saveOrUpdateReport(@ApiParam("JSON转换后端脚本数据模型") @RequestBody Report report) {
        reportService.saveOrUpdate(report);
        return Result.ok();
    }

    @ApiOperation("获取所有报告的JSON")
    @GetMapping("/getReport")
    public Result getReport() {
        List<Report> reportsList = reportService.getReport();
        return Result.ok(reportsList);
    }


    @ApiOperation("删除报告信息 一个或多个")
    @DeleteMapping("/deleteReportById")
    public Result deleteReportById(@ApiParam("多个报告 Id的json") @RequestBody List<Integer> ids) {
        reportService.removeByIds(ids);
        return Result.ok();
    }

}
