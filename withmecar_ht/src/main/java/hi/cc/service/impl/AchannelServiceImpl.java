package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.ActivityChannel;
import hi.cc.mapper.ActiveMapper;
import hi.cc.service.AchannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AchannelServiceImpl implements AchannelService {
    @Autowired
    private ActiveMapper activeMapper;

    @Override
    public int addAchannel(ActivityChannel activityChannel) {
        return activeMapper.addAchannel(activityChannel);
    }

    @Override
    public List<ActivityChannel> findBySName(String sname) {
        return activeMapper.findBySName(sname);
    }

    @Override
    public List<ActivityChannel> findAll(int page,int row) {
        PageHelper.startPage(page,row);
        return activeMapper.findAll();
    }

    @Override
    public int maxPage(int row) {
        int count = activeMapper.totalCount();
        return count%row==0?count/row:count/row+1;
    }

    @Override
    public boolean deleteA(int id) {
        return activeMapper.deleteA(id)>0?true:false;
    }
}
