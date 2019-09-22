package hi.cc.mapper;

import hi.car.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MemberMapper {

    public List<Member> findAllMember();
    // 查询信会员首页显示
    public List<MemberProfile> findAllMemberPro();
    //  根据id查询个人详细信息
    public MemberProfile findMemberProById(int Id);
    //  根据id查询个人标签
    public List<Tag> findTagById(int memberId);
    //  根据id查询出个人座驾信息
    public List<Car> findCarById(Map<String,Integer> map);
    //  根据id查询个人有关活动信息
    public List<Activity> findFavActivityById(int memberId);
    //  根据id查询个人有关资讯收藏信息
    public List<Article> findFavArticleById(int memberId);
    //  根据id查询个人关注车型信息
    public List<Car> findFavCarById(int memberId);
    //  根据id查询个人有关积分信息
    public List<MemberPoint> findMemberPointById(int memberId);
   //  模糊搜索会员信息
    public List<MemberProfile> findMemberProMoHu(String xxx);

    // 根据id查询地址信息
    public String findCityById(int id);
}
