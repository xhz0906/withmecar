package hi.cc.controller;

import hi.car.pojo.Message;
import hi.cc.service.impl.MessageServiceZwwImpl;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class MessageManageController {

    @Resource
    private MessageServiceZwwImpl messageServiceZww;

    //消息列表
    @RequiresPermissions(value = {"newsxx"})
    @RequestMapping("/messageListView")
    public String messageList(@RequestParam(required = false,defaultValue = "1") int page,
                              @RequestParam(required = false,defaultValue = "5") int row,
                              Model model){
        int maxPage=messageServiceZww.calMessagePage(row);
        if(page < 1){
            page=maxPage;
        }
        if(page > maxPage){
            page=1;
        }
        List<Message> allMessage = messageServiceZww.findAllMessage(page, row);
        allMessage.forEach(System.out::print);
        model.addAttribute("currentPage",page);
        model.addAttribute("allMessage",allMessage);
        model.addAttribute("maxPage",maxPage);
        return "messageList";
    }
    @RequiresPermissions(value = {"newsaddxx"})
    //新增消息
    @RequestMapping("/addMessageView")
    public String addMessage(){
        return "addMessage";
    }
    @RequestMapping("/addMessageRes")
    public String addMessageRes(String title,String content){
        Message message=new Message();
        message.setTitle(title);
        message.setContent(content);
        boolean b = messageServiceZww.addMessage(message);
        return b ? "redirect:messageListView" : "error";
    }
    //编辑消息
    @RequestMapping("/updateMessageView")
    public String updateMessage(Long id,Model model){
        Message message = messageServiceZww.findMessageById(id);
        model.addAttribute(message);
        return "updateMessage";
    }
    @RequestMapping("/updateMessageRes")
    public String updateMessageRes(Long id,String title,String content){
        Message message = messageServiceZww.findMessageById(id);
        message.setTitle(title);
        message.setContent(content);
        boolean b = messageServiceZww.updateMessage(message);
        return b ? "redirect:messageListView" : "error";
    }
    //删除消息
    @RequestMapping("/deleteMessageView")
    public String deletetMessageById(Long id){
        boolean b = messageServiceZww.deleteMessageById(id);
        return b ? "redirect:messageListView" : "error";
    }
    //消息预览
    @RequestMapping("/viewMessageView")
    public String viewMessage(Long id,Model model){
        Message message = messageServiceZww.findMessageById(id);
        model.addAttribute(message);
        return "viewMessage";
    }
    //发送消息
    @RequestMapping("/sendMessage")
    public String sendMessage(Long id,String name){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sendTime = dateFormat.format(new Date());
        messageServiceZww.sendMessage(id,name,sendTime);
        return "redirect:messageListView";
    }
    //按时间段查询消息
    @RequestMapping("/selectTime")
    public String selectTime(@RequestParam(required = false,defaultValue = "1") int page,
                             @RequestParam(required = false,defaultValue = "5") int row,String start, String end, Model model){
        int maxPage=messageServiceZww.calMessagePage1(row);
        if(page < 1){
            page=maxPage;
        }
        if(page > maxPage){
            page=1;
        }
        List<Message> messageByTime = messageServiceZww.findMessageByTime(start,end,page,row);
        System.out.println("messageByTime = " + messageByTime);
        model.addAttribute("messageByTime",messageByTime);
        model.addAttribute("currentPage",page);
        model.addAttribute("maxPage",maxPage);
        return "messageList1";
    }
}
