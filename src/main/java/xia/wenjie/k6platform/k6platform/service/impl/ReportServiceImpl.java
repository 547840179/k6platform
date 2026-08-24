package xia.wenjie.k6platform.k6platform.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xia.wenjie.k6platform.k6platform.mapper.ReportMapper;
import xia.wenjie.k6platform.k6platform.pojo.Report;
import xia.wenjie.k6platform.k6platform.service.ReportService;

import java.util.List;

@Service("reportServiceImpl")
@Transactional
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {
    @Override
    public IPage<Report> getReportByOpr(Page<Report> pageParam, Report report) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (report != null && report.getName() != null) {
            queryWrapper.like("name", report.getName());
        }
        queryWrapper.orderByDesc("id");
        IPage<Report> page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }

    @Override
    public List<Report> getReport() {
        return baseMapper.selectList(null);
    }
}
