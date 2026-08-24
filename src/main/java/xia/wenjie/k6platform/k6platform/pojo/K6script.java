package xia.wenjie.k6platform.k6platform.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//K6的压测脚本
@Data
@TableName("tb_k6script")
public class K6script {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String script;
    private String creator;
    private String creatorTime;
}


