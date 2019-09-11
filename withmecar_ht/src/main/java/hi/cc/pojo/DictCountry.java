package hi.cc.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//汽车国别字典表
public class DictCountry implements Serializable {
    private int id;
    private int brandId;
    private String name;
    private int point;
}
