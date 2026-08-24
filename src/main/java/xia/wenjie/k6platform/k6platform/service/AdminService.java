package xia.wenjie.k6platform.k6platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xia.wenjie.k6platform.k6platform.pojo.Admin;
import xia.wenjie.k6platform.k6platform.pojo.LoginForm;

public interface AdminService extends IService<Admin> {
    /**
     * 登录
     * @param loginForm
     * @return
     */
   // boolean saveOrUpdate(Admin admin);

    Admin login(LoginForm loginForm);

    Admin getAdminById(int i);

    IPage<Admin> getAdmins(Page<Admin> pageParam, String adminName);
}
