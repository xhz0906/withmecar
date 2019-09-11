package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;
@Data
public class AdminRoleMenu implements Serializable {
    private int roleId;
    private int menuId;
}
