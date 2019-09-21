package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.*;
import hi.cc.mapper.MemberMapper;
import hi.cc.service.MemberServiceXT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberServiceXTImpl implements MemberServiceXT {

    @Resource
    MemberMapper memberMapper;
    @Override
    public List<MemberProfile> findAllMemberPro() {

        List<MemberProfile> allMemberPro = memberMapper.findAllMemberPro();
        System.out.println("allMemberPro = " + allMemberPro);
        return allMemberPro;
    }

    @Override
    public MemberProfile findMemberProById(int id) {
        MemberProfile memberProById = memberMapper.findMemberProById(id);
        return memberProById;
    }

    @Override
    public List<Tag> findTagById(int memberId) {
        List<Tag> tagById = memberMapper.findTagById(memberId);
        return tagById;
    }

    @Override
    public List<Car> findCarById(int memberId, int type) {
        Map<String,Integer> map = new HashMap<>();
        map.put("memberId",memberId);
        map.put("type",type);
        return memberMapper.findCarById(map);
    }

    @Override
    public String findCityById(int id) {
        String cityName = memberMapper.findCityById(id);
        return cityName;
    }

    @Override
    public List<MemberPoint> findMemberPointById(int memberId) {

        return memberMapper.findMemberPointById(memberId);
    }

    @Override
    public List<Activity> findFavActivityById(int memberId) {
        return null;
    }

    @Override
    public List<Article> findFavArticleById(int memberId) {
        return memberMapper.findFavArticleById(memberId);
    }

    @Override
    public List<Car> findFavCarById(int memberId) {
        return memberMapper.findFavCarById(memberId);
    }

    @Override
    public List<MemberProfile> findMemberProMoHu(String xxx) {

        return memberMapper.findMemberProMoHu(xxx);
    }
}
