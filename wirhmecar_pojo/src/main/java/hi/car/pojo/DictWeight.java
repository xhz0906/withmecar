package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//权重字典表
public class DictWeight implements Serializable {
    private int id;//	id	int
    private String code;//权重代码	code	varchar(100)
    private String name;//权重名称（中文）	name	varchar(100)
    private String enName;//权重名称（英文）	en_name	varchar(100)
    private int weight;//权重值	weight	int

}
