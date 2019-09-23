package hi.cc.service.impl;

import hi.car.pojo.Member;
import hi.cc.mapper.MemberMapper_xpy;
import hi.cc.service.MemberService_Xpy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberImpl_Xpy implements MemberService_Xpy {
    @Autowired
    private MemberMapper_xpy memberMapper;

    @Override
    public List<Member> findMemberAll() {
        return memberMapper.findMemberAll();
    }

    @Override
    public Member findMemberByName(String name) {
        return memberMapper.findMemberByName(name);
    }

    @Override
    public boolean saveMember(Member member) {
        int c = memberMapper.saveMember(member);
        return c>0?true:false;
    }

    @Override
    public Member findById(int id) {
        return memberMapper.findById(id);
    }
}
