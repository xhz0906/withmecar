package hi.cc.service;

import hi.car.pojo.Activity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActivityService {
    public List<Activity> findAll(int page, int row);
    public int maxPage(int row);
    public List<Activity> findByStatus(int cid);
    public List<Activity> findByRS(int sid);
    public List<Activity> findByTitleOrName(String title);
}


