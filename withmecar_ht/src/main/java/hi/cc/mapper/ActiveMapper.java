package hi.cc.mapper;

import hi.car.pojo.ActivityChannel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActiveMapper {
    public int addAchannel(@Param("activityChannel") ActivityChannel activityChannel);
    public List<ActivityChannel> findBySName(@Param("sname") String sname);
    public List<ActivityChannel> findAll();
    public int totalCount();
    public int deleteA(int id);

}
