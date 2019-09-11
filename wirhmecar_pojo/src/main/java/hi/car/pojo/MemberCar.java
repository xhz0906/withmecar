package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
//会员座驾表
public class MemberCar implements Serializable {
    private int id;//	id		bigint
    private int memberId;//	会员ID		bigint
    private int brandId;//	品牌ID		int
    private int makeId;//	子品牌ID		int
    private int modelId;//	车系ID		int
    private int carId;//	车款ID		int
    private int buyYear;//	购买年份		int
    private int currentMileage;//	当前里程		int
    private String remark;//	备注		varchar(500)
    private int type;//	座驾类型		tinyint
    private int createTime;//	创建时间		int(11)
    private int updateTime;//	最后更新时间		int(11)
}
