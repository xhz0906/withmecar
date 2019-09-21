package hi.car.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
//会员登录
public class MemberToken implements Serializable {
    private int memberId;//会员id
    private String token;
    private String createTime;//颁发时间
    private String duration;//有效时间
    private String expiredTime;//过期时间戳
}
