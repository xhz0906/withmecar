package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.MemberMapper_xpy;
import com.qf.j1904.service.MemberService_xpy;
import hi.car.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl_xpy implements MemberService_xpy {
    @Autowired
    private MemberMapper_xpy memberMapper;
    /**
     * 根据username查询会员信息
     * @param name
     * @return
     */
    @Override
    public Member findMemberByName(String name) {
        return memberMapper.findMemberByName(name);
    }
}
