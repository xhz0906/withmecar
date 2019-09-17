package hi.cc.service;

import hi.car.pojo.Car;
import hi.car.pojo.MemberProfile;
import hi.car.pojo.Tag;

import java.util.List;

public interface MemberServiceXT {
    public List<MemberProfile> findAllMemberPro();
    public MemberProfile findMemberProById(int id);
    public List<Tag> findTagById(int memberId);
    public List<Car> findCarById(int memberId,int type);
}
