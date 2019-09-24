package hi.cc.mapper;

import hi.car.pojo.ActivityCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Mapper
public interface AactivityCategoryMapper {
    public List<ActivityCategory> findAll();
    public List<ActivityCategory> findByName(@Param("name") String name);
    public ActivityCategory findById(@Param("id") int id);
    public int deleteaa(@Param("id") int id);
    public int updateaa(@Param("activityCategory") ActivityCategory activityCategory);
    public int addaa(@Param("activityCategory") ActivityCategory activityCategory);
    public ActivityCategory findOneByName(@Param("name") String name);
}
