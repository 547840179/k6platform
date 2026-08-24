package xia.wenjie.k6platform.k6platform.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import xia.wenjie.k6platform.k6platform.pojo.Companydepartment;

import java.util.List;

public interface CompanydepartmentServer extends IService<Companydepartment> {

    IPage<Companydepartment> getCompanydepartmentByOpr(Page<Companydepartment> pageParam, Companydepartment companydepartment);

    List<Companydepartment> getCompanydepartment();
}
