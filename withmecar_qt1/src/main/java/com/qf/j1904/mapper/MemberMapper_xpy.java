package com.qf.j1904.mapper;

import hi.car.pojo.Member;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper_xpy {
    /**
     * 根据username查询会员信息
     * @param name
     * @return
     */
    public Member findMemberByName(String name);
}
