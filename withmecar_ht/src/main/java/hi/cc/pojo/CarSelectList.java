package hi.cc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
//备选车型表
public class CarSelectList implements Serializable {
    private int id;//	id	int(10)
    private String type;//	级别	varchar(10)
    private String country;//	国家	varchar(5)
    private String carType;//	车型	varchar(16)
    private int carTypeBak;//	备选车型	tinyint(1)
    private BigDecimal msrpMin;//	msrp_min	decimal(6,2)
    private BigDecimal msrpMax;//	msrp_max	decimal(6,2)
    private int countryType;//	所属车系	tinyint(1)
    private int countryStd;//	车系口碑分	tinyint(1)
    private BigDecimal spaceStd;//	空间口碑分	decimal(10,8)
    private BigDecimal powerStd;//	动力操控口碑分	decimal(10,8)
    private BigDecimal comfortStd;//	舒适度口碑分	decimal(10,8)
    private BigDecimal costStd;//	使用成本口碑分	decimal(10,8)
    private BigDecimal safeStd;//	安全口碑分	decimal(10,8)
    private int carId;//	关联车ID	int(10)

}
