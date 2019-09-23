package hi.cc.utils;

import org.apache.shiro.crypto.hash.SimpleHash;

public class SimpleMD5Utils {
    public static String getPassword(String password){
        String type = "MD5";
        String salt = "abc";
        int i = 1024;
        SimpleHash simpleHash = new SimpleHash(type,password,salt,i);
        return simpleHash.toHex();
    }
}
