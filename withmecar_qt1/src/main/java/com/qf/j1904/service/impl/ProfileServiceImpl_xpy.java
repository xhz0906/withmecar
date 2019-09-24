package com.qf.j1904.service.impl;

import com.qf.j1904.mapper.MemProfileMapper_xpy;
import com.qf.j1904.service.MemProfileService_xpy;
import com.qf.j1904.service.MemberService_xpy;
import hi.car.pojo.Member;
import hi.car.pojo.MemberProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl_xpy implements MemProfileService_xpy {
    @Autowired
    private MemProfileMapper_xpy memProfileMapper;

    @Override
    public MemberProfile findById(int id) {
        return memProfileMapper.findById(id);
    }

    @Override
    public boolean updatePro(MemberProfile memberProfile) {
        int c = memProfileMapper.updatePro(memberProfile);
        return c>0?true:false;
    }

    @Override
    public boolean updateImg(String img) {
        int c = memProfileMapper.updateImg(img);
        return c>0?true:false;
    }
}
