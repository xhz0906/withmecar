package hi.cc.service;

import hi.car.pojo.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MessageServiceZxx {

    //分页显示消息
    public List<Message> findAllMessage(int page, int row);
    public int calMessagePage(int row);
    public int calMessagePage1(int row);
    //根据时间段查
    public List<Message> findMessageByTime(String start, String end, int page, int row);
    //根据id查找消息
    public Message findMessageById(Long id);
    //增加消息
    public boolean addMessage(Message message);
    //删除消息
    public boolean deleteMessageById(Long id);
    //编辑消息
    public boolean updateMessage(Message message);
    //发送消息
    public boolean sendMessage(Long id, String name, String sendTime);
}
