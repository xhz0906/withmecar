package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class VisitLog implements Serializable {
    private int id;
    private int visitorId;
    private int memberId;
    private String visitUrl;
    private String visitIp;
    private String visitDevice;
    private String visitSource;
    private int enterTime;
    private int exitTime;
    private int stay;
}
