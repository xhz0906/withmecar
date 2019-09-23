package hi.cc.service.impl;

import hi.car.pojo.MemberProfile;
import hi.cc.mapper.MemProfileMapper_xpy;
import hi.cc.service.MemProfileService_xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemProfileImpl_xpy implements MemProfileService_xpy {
    @Autowired
    private MemProfileMapper_xpy memProfileMapper;
    @Override
    public MemberProfile findByMail(String email) {
        return memProfileMapper.findByMail(email);
    }

    @Override
    public boolean saveMemberProfile(MemberProfile memberProfile) {
        int c = memProfileMapper.saveMemberProfile(memberProfile);
        return c>0?true:false;
    }
}
