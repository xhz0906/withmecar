package hi.cc.service.impl;

import hi.car.pojo.OperateLog;
import hi.cc.mapper.LogRecordMapper;
import hi.cc.service.OperateService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateService {
    @Resource
    LogRecordMapper logRecordMapper;
    @Override
    public List<OperateLog> findAllOperateLog() {
        return logRecordMapper.findAllOperateLog();
    }

    @Override
    public int addOperateLog(OperateLog operateLog) {

        return logRecordMapper.addOperateLog(operateLog);
    }
}
