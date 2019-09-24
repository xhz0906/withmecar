package com.qf.j1904.service;

import hi.car.pojo.Member;

public interface MemberService_xpy {
    /**
     * 根据username查询会员信息
     * @param name
     * @return
     */
    public Member findMemberByName(String name);
}
