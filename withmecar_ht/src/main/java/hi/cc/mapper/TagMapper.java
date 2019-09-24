package hi.cc.mapper;




import hi.car.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface TagMapper {
    public List<Tag> findAll();
    public List<Tag> findQbz();
    public List<Tag> findSy();
    public Tag findByid(@RequestParam("tagid") int tagid);
    public int updateById(@Param("tag") Tag tag);
    public Tag findByName(@Param("name") String name);
    public int updateLoc1(@Param("id") int id);
    public int updateLoc2(@Param("id") int id);
}
