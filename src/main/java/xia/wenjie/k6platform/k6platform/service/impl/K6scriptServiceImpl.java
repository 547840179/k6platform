package xia.wenjie.k6platform.k6platform.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import xia.wenjie.k6platform.k6platform.mapper.K6scriptMapper;
import xia.wenjie.k6platform.k6platform.pojo.K6script;
import xia.wenjie.k6platform.k6platform.service.K6scriptService;

import java.util.List;

@Service("k6scriptService")
public class K6scriptServiceImpl extends ServiceImpl<K6scriptMapper, K6script> implements K6scriptService {
//    @Override
//    public K6script getK6scriptByName(String name) {
//        QueryWrapper<K6script> k6scriptQueryWrapper = new QueryWrapper<>();
//        k6scriptQueryWrapper.eq("name", name);
//        return baseMapper.selectOne(k6scriptQueryWrapper);
//    }

    @Override
    public IPage<K6script> getK6scriptByOpr(Page<K6script> pageParam, K6script k6script) {
        QueryWrapper k6scriptQueryWrapper = new QueryWrapper();
        if (k6script != null && k6script.getName() != null) {
            k6scriptQueryWrapper.like("name", k6script.getName());
        }
        k6scriptQueryWrapper.orderByDesc("id");
        IPage<K6script> page = baseMapper.selectPage(pageParam, k6scriptQueryWrapper);
        return page;
    }

    @Override
    public List<K6script> getk6script() {
        return baseMapper.selectList(null);
    }

}
