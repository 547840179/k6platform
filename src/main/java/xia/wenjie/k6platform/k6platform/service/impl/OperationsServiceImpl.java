package xia.wenjie.k6platform.k6platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xia.wenjie.k6platform.k6platform.mapper.CompanydepartmentMapper;
import xia.wenjie.k6platform.k6platform.mapper.OperationsMapper;
import xia.wenjie.k6platform.k6platform.pojo.Companydepartment;
import xia.wenjie.k6platform.k6platform.pojo.LoginForm;
import xia.wenjie.k6platform.k6platform.pojo.Operations;
import xia.wenjie.k6platform.k6platform.service.CompanydepartmentServer;
import xia.wenjie.k6platform.k6platform.service.OperationsService;
import xia.wenjie.k6platform.k6platform.util.MD5;

@Service("0perationsServiceImpl")
@Transactional
public class OperationsServiceImpl extends ServiceImpl<OperationsMapper, Operations> implements OperationsService {
    @Override
    public Operations login(LoginForm loginForm) {
        //创建QueryWrapper对象
        QueryWrapper<Operations> queryWrapper = new QueryWrapper<>();
        //拼接查询条件
        queryWrapper.eq("name",loginForm.getUsername());
        // 转换成密文进行查询
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Operations operations = baseMapper.selectOne(queryWrapper);

        return operations;
    }

    @Override
    public Operations getOperationsById(int i) {
        QueryWrapper<Operations> queryWrapper = new QueryWrapper<Operations>();
        //拼接查询条件
        queryWrapper.eq("id",i);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Operations> getOperationsByOpr(Page<Operations> pageParam, Operations operations) {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(operations != null){
            //班级名称条件
            String clazzName = operations.getClazzName();
            if (!StringUtils.isEmpty(clazzName)) {
                queryWrapper.eq("clazz_name",clazzName);
            }
            //教师名称条件
            String operationsName = operations.getName();
            if(!StringUtils.isEmpty(operationsName)){
                queryWrapper.like("name",operationsName);
            }
            queryWrapper.orderByDesc("id");
            queryWrapper.orderByAsc("name");
        }

        IPage<Operations> page = baseMapper.selectPage(pageParam, queryWrapper);

        return page;
    }
}



