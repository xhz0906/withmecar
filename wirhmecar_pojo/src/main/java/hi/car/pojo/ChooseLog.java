package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//会员选车记录表
public class ChooseLog implements Serializable {
    private int id;//	id		int(11)
    private String memberId;//	会员ID		varchar(255)
    private int userCountry;//	选择车系		tinyint(4)
    private String userSpace;//	选择空间		varchar(50)
    private String userPower;//	选择动力		varchar(50)
    private String userComfort;//	选择舒适度		varchar(50)
    private String userSafe;//	选择安全性		varchar(50)
    private String userCost;//	选择使用成本		varchar(50)
    private String serMin;//	预算下限		varchar(50)
    private String userMax;//	预算上限		varchar(50)
    private String userPtime;//	当前车型拥有年限		varchar(50)
    private String userCar;//	已有车型		varchar(50)
    private String chooseCar;//	用户选择车型		varchar(50)
    private int createTime;//	创建时间		int(11)

}
