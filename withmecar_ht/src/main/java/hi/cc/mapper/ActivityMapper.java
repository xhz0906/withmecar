package hi.cc.mapper;

import hi.car.pojo.Activity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActivityMapper  {
    public List<Activity> findAll();
    public int findCount();
    public List<Activity> findByStatus(int cid);
    public List<Activity> findByRS(int sid);
    public List<Activity> findByTitleOrName(@Param("title") String title);
}
