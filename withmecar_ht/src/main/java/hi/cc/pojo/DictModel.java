package hi.cc.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//备选车型字典表
public class DictModel implements Serializable {
    private int id;//id	int
    private String code;//类别级别编码	varchar(100)
    private String country;//国别	varchar(100)
    private String modelName;//车型名称	varchar(100)
    private int modelId;//车型ID	int
    private int msrpMin;//MSRP_MIN	int
    private int space;//空间口碑	tinyint
    private int power;//动力操控口碑	tinyint
    private int comfort;//舒适度口碑	tinyint
    private int cost;//使用成本口碑	tinyint
    private int safety;//安全性口碑	tinyint
}
