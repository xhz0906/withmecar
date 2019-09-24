package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.Activity;
import hi.cc.mapper.ActivityMapper;
import hi.cc.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityMapper activityMapper;
    @Override
    public List<Activity> findAll(int page,int row) {
        PageHelper.startPage(page,row);
        return activityMapper.findAll();
    }

    @Override
    public int maxPage(int row) {
        int count = activityMapper.findCount();
        return count%row==0?count/row:count/row+1;
    }

    @Override
    public List<Activity> findByStatus(int cid) {
        return activityMapper.findByStatus(cid);
    }

    @Override
    public List<Activity> findByRS(int sid) {
        return activityMapper.findByRS(sid);
    }

    @Override
    public List<Activity> findByTitleOrName(String title) {
        return activityMapper.findByTitleOrName(title);
    }
}
