package hi.cc.service;

import hi.car.pojo.MemberProfile;

public interface MemProfileService_xpy {
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
    public boolean saveMemberProfile(MemberProfile memberProfile);
}
