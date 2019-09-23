package hi.cc.mapper;

import hi.car.pojo.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper_xpy {
    /**
     * 查询所有member
     * @return
     */
    public List<Member> findMemberAll();
    /**
     * 根据name查询member
     * @param name
     * @return
     */
    public Member findMemberByName(String name);

    /**
     * 添加member
     * @param member
     * @return
     */
    public int saveMember(@Param("member") Member member);

    /**
     * 根据id查询member
     * @param id
     * @return
     */
    public Member findById(int id);
}
