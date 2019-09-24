package hi.cc.service;

import hi.car.pojo.ActivityChannel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AchannelService {
    public int addAchannel(ActivityChannel activityChannel);
    public List<ActivityChannel> findBySName(String sname);
    public List<ActivityChannel> findAll(int page, int row);
    public int  maxPage(int row);
    public boolean deleteA(int id);
}
