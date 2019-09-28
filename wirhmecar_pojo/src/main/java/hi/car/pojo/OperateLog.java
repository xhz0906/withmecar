package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OperateLog implements Serializable {
    private int id;

    private String operateTime;

    private int operateUid;

    private String tableName;

    private String tableDisname;

    private int dataId;

    private String operateDesc;
}
