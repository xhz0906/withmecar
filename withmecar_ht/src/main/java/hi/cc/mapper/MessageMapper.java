package hi.cc.mapper;

import hi.car.pojo.Message;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import java.util.Map;

/**
 * 定义系统消息管理
 */
@Mapper
public interface MessageMapper {

    //全查(分页)
    public List<Message> findAllMessage();
    //计算总的条数
    public int totalCount();
    //计算总的条数
    public int totalCount1();
    //根据时间段查
    public List<Message> findMessageByTime(Map<String, Object> map1);
    //根据id查找
    public Message findMessageById(Long id);
    //增加消息
    public int addMessage(Message message);
    //删除消息
    public int deleteMessageById(Long id);
    //编辑消息
    public int updateMessage(Message message);
    //发送消息
    public boolean sendMessage(Map<String, Object> map);
}

