package com.qf.j1904.service;

import hi.car.pojo.MemberProfile;
import org.apache.ibatis.annotations.Param;

public interface MemProfileService_xpy {
    /**
     * 根据id查询信息
     * @param id
     * @return
     */
    public MemberProfile findById(int id);
    /**
     * 修改信息
     * @param memberProfile
     * @return
     */
    public boolean updatePro(@Param("memberProfile") MemberProfile memberProfile);
}
