package hi.cc.mapper;

import hi.car.pojo.MemberProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemProfileMapper_xpy {
    /**
     * 根据邮箱查询会员信息
     * @param email
     * @return
     */
    public MemberProfile findByMail(String email);

    /**
     * 添加会员信息
     * @param memberProfile
     * @return
     */
    public int saveMemberProfile(@Param("memProfile") MemberProfile memProfile);
}
