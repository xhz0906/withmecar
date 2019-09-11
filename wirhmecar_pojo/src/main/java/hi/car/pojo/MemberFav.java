package hi.car.pojo;

import lombok.Data;

@Data
public class MemberFav {

    private int id;
    private int memberId;
    private int favType;
    private int contentId;
    private int favTime;
    private String favIp;

}
