package xia.wenjie.k6platform.k6platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xia.wenjie.k6platform.k6platform.pojo.LoginForm;
import xia.wenjie.k6platform.k6platform.pojo.Tester;

import java.util.List;

public interface TesterService extends IService<Tester> {
    Tester login(LoginForm loginForm);

    Tester getTesterById(int i);

    IPage<Tester> getTesterByOpr(Page<Tester> page, Tester tester);

    List<Tester> getTesters();
}
