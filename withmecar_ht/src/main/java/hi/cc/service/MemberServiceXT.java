package hi.cc.service;

import hi.car.pojo.*;

import java.util.List;

public interface MemberServiceXT {
    public List<MemberProfile> findAllMemberPro();
    public MemberProfile findMemberProById(int id);
    public List<Tag> findTagById(int memberId);
    public List<Car> findCarById(int memberId,int type);
    public String findCityById (int id);
    public List<MemberPoint> findMemberPointById(int memberId);
    //  根据id查询个人有关活动信息
    public List<Activity> findFavActivityById(int memberId);
    //  根据id查询个人有关资讯收藏信息
    public List<Article> findFavArticleById(int memberId);
    //  根据id查询个人关注车型信息
    public List<Car> findFavCarById(int memberId);

    //  模糊搜索会员信息
    public List<MemberProfile> findMemberProMoHu(String xxx);
}
