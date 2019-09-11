package hi.cc.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//答案选项字典表
public class DictAnswer implements Serializable {
    private int id;//	id	int
    private int weightid;//权重ID	weight_id	int
    private String name;//选项名称（中文）	name	varchar(100)
    private String enName;//选项名称（英文）	en_name	varchar(100)
    private int adjustValue;//权重调整值	adjust_value	int
}
