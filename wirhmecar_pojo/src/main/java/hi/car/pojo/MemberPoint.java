package hi.car.pojo;

import lombok.Data;

@Data
public class MemberPoint {

     private int id;;
     private int memberId;
     private int point;
     private int type;
     private String description;
     private String remark;
     private int create_time;
}
