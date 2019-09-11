package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//汽车国别字典表
public class DictCountry implements Serializable {
    private int id;
    private String name;
    private String enName;
}
