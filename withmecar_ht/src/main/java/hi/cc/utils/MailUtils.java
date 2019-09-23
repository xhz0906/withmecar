package hi.cc.utils;


import org.springframework.stereotype.Component;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Component
public class MailUtils {
    //发送邮件
    public boolean sendSimpleMail(String text, String title, String email){
        boolean bool = false;
        //String to = "3455874164@qq.com";
        // 发件人电子邮箱
        String from = "1102736593@qq.com";
        // 指定发送邮件的主机为 localhost
        String host = "smtp.qq.com";  //QQ 邮件服务器
        // 获取系统属性
        Properties properties = System.getProperties();
        // 设置邮件服务器
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");
        // 获取默认session对象
        Session session = Session.getDefaultInstance(properties,new Authenticator(){
            public PasswordAuthentication getPasswordAuthentication()
            {
                return new PasswordAuthentication("1102736593@qq.com", "ahlpqvddphugifbj"); //发件人邮件用户名、密码
            }
        });
        try{
            // 创建默认的 MimeMessage 对象
            MimeMessage message = new MimeMessage(session);

            // Set From: 头部头字段
            message.setFrom(new InternetAddress(from));

            // Set To: 头部头字段
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(email));

            // Set Subject: 头部头字段
            message.setSubject(title);
            // 设置消息体
            message.setText(text);
            // 发送消息
            Transport.send(message);
            System.out.println("Sent message successfully....");
            bool = true;
            return bool;
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
        return bool;
    }
    //发送验证码、邮箱登录、忘记密码
    public String sendCode(String email,String mess,String title){
        String code = String.valueOf(new Random().nextInt(899999)+100000);
        String message = mess+code;
        boolean b = sendSimpleMail(message, title, email);
        if (b){
            return code;
        }
        return null;
    }
}
