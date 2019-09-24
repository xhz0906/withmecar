package hi.cc.service;


import hi.car.pojo.Tag;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TagService {
    public List<Tag> findQbz();
    public List<Tag> findSy();
    public Tag findByid(@RequestParam("tagid") int tagid);
    public int updateById(@Param("tag") Tag tag);
    public boolean findByName(String name);
    public int updateLoc1(int id);
    public int updateLoc2(int id);
}
