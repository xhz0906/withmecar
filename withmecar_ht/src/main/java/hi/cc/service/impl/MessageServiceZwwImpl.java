package hi.cc.service.impl;

import com.github.pagehelper.PageHelper;
import hi.car.pojo.Message;
import hi.cc.mapper.MessageMapper;
import hi.cc.service.MessageServiceZxx;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MessageServiceZwwImpl implements MessageServiceZxx {

    @Resource
    private MessageMapper messageMapper;

    @Override
    public List<Message> findAllMessage(int page, int row) {
        PageHelper.startPage(page,row);
        List<Message> messages=messageMapper.findAllMessage();
        return messages;
    }

    @Override
    public int calMessagePage(int row) {
        int count=messageMapper.totalCount();
        return count % row == 0 ? count/row : count/row+1;
    }
    @Override
    public int calMessagePage1(int row) {
        int count=messageMapper.totalCount1();
        return count % row == 0 ? count/row : count/row+1;
    }

    @Override
    public List<Message> findMessageByTime(String start,String end,int page,int row) {
        PageHelper.startPage(page,row);
        Map<String, Object> map1 = new HashMap<>();
        map1.put("start",start);
        map1.put("end",end);
        List<Message> messages=messageMapper.findMessageByTime(map1);
        return messages;
    }

    @Override
    public Message findMessageById(Long id) {
        Message message=messageMapper.findMessageById(id);
        return message;
    }

    @Override
    public boolean addMessage(Message message) {
        int n=messageMapper.addMessage(message);
        return n > 0 ? true : false;
    }

    @Override
    public boolean deleteMessageById(Long id) {
        int n=messageMapper.deleteMessageById(id);
        return n > 0 ? true : false;
    }

    @Override
    public boolean updateMessage(Message message) {
        int n=messageMapper.updateMessage(message);
        return n > 0 ? true : false;
    }

    @Override
    public boolean sendMessage(Long id, String name,String sendTime) {

        HashMap<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("name",name);
        map.put("sendTime",sendTime);
        boolean b = messageMapper.sendMessage(map);
        System.out.println("b = " + b);
        return b;
    }
}
