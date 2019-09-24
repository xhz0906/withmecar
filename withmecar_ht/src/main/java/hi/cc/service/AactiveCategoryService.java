package hi.cc.service;

import hi.car.pojo.ActivityCategory;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AactiveCategoryService {
    public List<ActivityCategory> findAll();
    public List<ActivityCategory> findByName(String name);
    public ActivityCategory findById(int id);
    public int deleteaa(int id);
    public int updateaa(ActivityCategory activityCategory);
    public int addaa(ActivityCategory activityCategory);
    public ActivityCategory findOneByName(String name);
}
