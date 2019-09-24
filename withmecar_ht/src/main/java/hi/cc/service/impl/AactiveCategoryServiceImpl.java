package hi.cc.service.impl;

import hi.car.pojo.ActivityCategory;
import hi.cc.mapper.AactivityCategoryMapper;
import hi.cc.service.AactiveCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AactiveCategoryServiceImpl implements AactiveCategoryService {
   @Autowired
   private AactivityCategoryMapper aactivityCategoryMapper;

    @Override
    public List<ActivityCategory> findAll() {
        return aactivityCategoryMapper.findAll();
    }

    @Override
    public List<ActivityCategory> findByName(String name) {
        return aactivityCategoryMapper.findByName(name);
    }

    @Override
    public ActivityCategory findById(int id) {
        return aactivityCategoryMapper.findById(id);
    }

    @Override
    public int deleteaa(int id) {
        return aactivityCategoryMapper.deleteaa(id);
    }

    @Override
    public int updateaa(ActivityCategory activityCategory) {
        return aactivityCategoryMapper.updateaa(activityCategory);
    }

    @Override
    public int addaa(ActivityCategory activityCategory) {
        return aactivityCategoryMapper.addaa(activityCategory);
    }

    @Override
    public ActivityCategory findOneByName(String name) {
        return aactivityCategoryMapper.findOneByName(name);
    }
}
