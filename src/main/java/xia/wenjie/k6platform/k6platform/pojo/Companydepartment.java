package xia.wenjie.k6platform.k6platform.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @project: sms
 * @description: 部门信息  Class班级信息
 */
@Data
@TableName("tb_companydepartment")
public class Companydepartment {
    //班级信息
    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;             //部门Id
    private String name;            //部门名称
    private String number;          //部门人数
    private String introducation;   //部门介绍
    private String departmentmanager;      //部门经理
    private String telephone;       //经理电话
    private String email;           //邮箱
    private String gradeName;      //班级所属年级
}
