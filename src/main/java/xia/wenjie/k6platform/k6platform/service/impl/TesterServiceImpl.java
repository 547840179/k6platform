package xia.wenjie.k6platform.k6platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xia.wenjie.k6platform.k6platform.mapper.TesterMapper;
import xia.wenjie.k6platform.k6platform.pojo.LoginForm;
import xia.wenjie.k6platform.k6platform.pojo.Tester;
import xia.wenjie.k6platform.k6platform.service.TesterService;
import xia.wenjie.k6platform.k6platform.util.MD5;

import java.util.List;

@Service("testerServiceImpl")
@Transactional
public class TesterServiceImpl extends ServiceImpl<TesterMapper, Tester> implements TesterService {
    @Override
    public Tester login(LoginForm loginForm) {
        //创建QueryWrapper对象
        QueryWrapper<Tester> queryWrapper = new QueryWrapper<>();
        //拼接查询条件
        queryWrapper.eq("name", loginForm.getUsername());
        // 转换成密文进行查询
        queryWrapper.eq("password", MD5.encrypt(loginForm.getPassword()));

        Tester tester = baseMapper.selectOne(queryWrapper);

        return tester;
    }

    @Override
    public Tester getTesterById(int i) {
        QueryWrapper<Tester> queryWrapper = new QueryWrapper<Tester>();
        //拼接查询条件
        queryWrapper.eq("id", i);
        return baseMapper.selectOne(queryWrapper);
    }

    @Override
    public IPage<Tester> getTesterByOpr(Page<Tester> page, Tester tester) {
        QueryWrapper<Tester> queryWrapper = null;
        if (tester != null) {
            queryWrapper = new QueryWrapper<>();
            if (tester.getName() != null) {
                queryWrapper.like("name", tester.getName());
            }
            queryWrapper.orderByDesc("id");
            queryWrapper.orderByAsc("name");
        }
        //创建分页对象
        IPage<Tester> pages = baseMapper.selectPage(page, queryWrapper);
        return pages;
    }

    @Override
    public List<Tester> getTesters() {
        return baseMapper.selectList(null);
    }

}
