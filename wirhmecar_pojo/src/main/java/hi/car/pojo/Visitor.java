package hi.car.pojo;

import lombok.Data;

@Data
public class Visitor {
    private int id;
    private String visitorGuid;
    private int firstVisitTime;
    private String entryUrl;
    private String visitorIp;
    private String visitorDevice;
    private String visitorChannel;
}
