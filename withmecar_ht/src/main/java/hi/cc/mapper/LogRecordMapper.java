package hi.cc.mapper;

import hi.car.pojo.OperateLog;
import org.apache.catalina.LifecycleState;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogRecordMapper {
    // 查询operateLog日志表（时间排序）
    public List<OperateLog> findAllOperateLog();
    // 新增log日志
    public int addOperateLog(OperateLog operateLog);
}
