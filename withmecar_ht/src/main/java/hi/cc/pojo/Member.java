package hi.cc.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
//会员
public class Member implements Serializable {
    private int id ;
    private String username;
    private String password;
    private int source;//会员来源
}

