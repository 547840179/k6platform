package xia.wenjie.k6platform.k6platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xia.wenjie.k6platform.k6platform.pojo.K6script;

import java.util.List;

public interface K6scriptService extends IService<K6script> {

    IPage<K6script> getK6scriptByOpr(Page<K6script> page, K6script k6script);

    List<K6script> getk6script();
}
