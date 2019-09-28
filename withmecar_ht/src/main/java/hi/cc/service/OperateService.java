package hi.cc.service;

import hi.car.pojo.OperateLog;

import java.util.List;

public interface OperateService {
    // 查询operateLog日志表（时间排序）
    public List<OperateLog> findAllOperateLog();
    // 新增log日志
    public int addOperateLog(OperateLog operateLog);
}
