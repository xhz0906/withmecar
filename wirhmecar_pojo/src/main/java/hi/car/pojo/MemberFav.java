package hi.car.pojo;

import lombok.Data;

@Data
public class MemberFav {

    private int id;
    private int memberId;
    private int favType;
    private int contentId;
    private String favTime;
    private String favIp;

}
