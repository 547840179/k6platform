package xia.wenjie.k6platform.k6platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xia.wenjie.k6platform.k6platform.mapper.CompanydepartmentMapper;
import xia.wenjie.k6platform.k6platform.pojo.Companydepartment;
import xia.wenjie.k6platform.k6platform.service.CompanydepartmentServer;

import java.util.List;

@Service("companydepartmentServerImpl")
@Transactional
public class CompanydepartmentServerImpl extends ServiceImpl<CompanydepartmentMapper, Companydepartment> implements CompanydepartmentServer {
    @Override
    public IPage<Companydepartment> getCompanydepartmentByOpr(Page<Companydepartment> pageParam, Companydepartment companydepartment) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if (companydepartment != null) {
            //年级名称条件
            String gradeName = companydepartment.getGradeName();
            if (!StringUtils.isEmpty(gradeName)) {
                queryWrapper.eq("grade_name", gradeName);
            }

            String companydepartmentName = companydepartment.getName();
            if (!StringUtils.isEmpty(companydepartmentName)) {
                queryWrapper.like("name", companydepartmentName);
            }
            queryWrapper.orderByDesc("id");
            queryWrapper.orderByAsc("name");
        }
        Page page = baseMapper.selectPage(pageParam, queryWrapper);
        return page;
    }

    @Override
    public List<Companydepartment> getCompanydepartment() {
        return baseMapper.selectList(null);
    }
}
