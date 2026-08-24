package xia.wenjie.k6platform.k6platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xia.wenjie.k6platform.k6platform.pojo.LoginForm;
import xia.wenjie.k6platform.k6platform.pojo.Operations;

public interface OperationsService extends IService<Operations> {
    Operations login(LoginForm loginForm);

    Operations getOperationsById(int i);

    IPage<Operations> getOperationsByOpr(Page<Operations> pageParam, Operations operations);
}
