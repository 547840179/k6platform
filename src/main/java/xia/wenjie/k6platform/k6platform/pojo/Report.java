package xia.wenjie.k6platform.k6platform.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

//K6的压测报告
@Data
@TableName("tb_report")
public class Report {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name; //报告名称
    private String startTime; //开始时间
    private int concurrency; //并发数量
    private double successrate; //成功率
    private double tps; //tps
    private double rt; //平均rt
    private String creator;//创建人
    private String portraitPath;// 报告路径

}
