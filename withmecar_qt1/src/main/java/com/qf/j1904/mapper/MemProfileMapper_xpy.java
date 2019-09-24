package com.qf.j1904.mapper;

import hi.car.pojo.MemberProfile;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemProfileMapper_xpy {
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
    public int updatePro(@Param("memberProfile") MemberProfile memberProfile);
}

