package hi.cc;

import hi.car.pojo.Car;
import hi.car.pojo.MemberProfile;
import hi.car.pojo.Tag;
import hi.cc.mapper.MemberMapper;
import hi.cc.service.MemberServiceXT;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WithmecarHtApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private MemberMapper memberMapper;
    @Autowired
    private MemberServiceXT memberServiceXT;
    @Test
    public void findAllMembertest(){
        List<MemberProfile> allMemberPro = memberMapper.findAllMemberPro();
        System.out.println("allMemberPro = " + allMemberPro);
    }
    @Test
    public void findMemberProTest(){
        MemberProfile memberProById = memberMapper.findMemberProById(1);
        System.out.println("memberProById = " + memberProById);

    }

    @Test
    public void findsTagById(){
        List<Tag> tagById = memberServiceXT.findTagById(1);
        System.out.println("tagById = " + tagById);
    }

    @Test
    public void findsTagByIdTest(){
        Map<String,Integer> map = new HashMap<>();
        map.put("memerId",1);
        map.put("type",2);
        List<Car> carById = memberServiceXT.findCarById(1, 2);
        System.out.println("carById = " + carById);


    }
}
