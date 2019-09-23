package hi.cc.service;

import hi.car.pojo.Member;

import java.util.List;

public interface MemberService_Xpy {
    /**
     * 查询所有member
     * @return
     */
    public List<Member> findMemberAll();
    public Member findMemberByName(String name);
    /**
     * 添加member
     * @param member
     * @return
     */
    public boolean saveMember(Member member);

    /**
     * 根据id查询member
     * @param id
     * @return
     */
    public Member findById(int id);
}
