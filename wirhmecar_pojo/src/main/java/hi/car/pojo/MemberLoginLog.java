package hi.car.pojo;

import lombok.Data;

@Data
public class MemberLoginLog {

     private int id;
     private int memberId;
     private int loginTime;
     private int isFirst;
     private String loginIp;
}
