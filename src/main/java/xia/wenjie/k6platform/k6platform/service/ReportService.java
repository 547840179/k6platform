package xia.wenjie.k6platform.k6platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xia.wenjie.k6platform.k6platform.pojo.Report;

import java.util.List;

public interface ReportService extends IService<Report> {
    IPage<Report> getReportByOpr(Page<Report> page, Report report);


    List<Report> getReport();
}
