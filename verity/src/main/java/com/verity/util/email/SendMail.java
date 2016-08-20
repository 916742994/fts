package com.verity.util.email;

/**
 * 发送邮件工具
 * Created by Youjm on 2016/3/5.
 */

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public class SendMail {
    public void send(String email, String subject, String url) throws AddressException, MessagingException {
        //输入你自己准备发送邮件的账号和密码
        SimpleMailSender sms = new SimpleMailSender("18860116743@163.com", "ming0206you");
        sms.send(email, subject, "请在两分钟内点击链接进行验证（过期无效）：" + url + "   注：如果不是您本人操作，请忽略此消息。");
    }

    //Mian 函数测试
    public static void main(String[] args) throws MessagingException {

//        SimpleMailSender sms = new SimpleMailSender("18860116743@163.com", "ming0206you");
//        //群发
//        ArrayList<String> recipients = new ArrayList<String>();
//        recipients.add("916742994@qq.com");
//        for(String recipient:recipients){
//            sms.send(recipient,"怎么可能","这个是内容");
//        }
//        //单发
        SimpleMailSender sms = new SimpleMailSender("18860116743@163.com", "ming0206you");
//        SimpleMailSender sms = new  SimpleMailSender("fzu_youjm@163.com","Ming0206you@");
//        SimpleMailSender sms = new  SimpleMailSender("fzu.youjm@gmail.com", "Ming0206you@");
        String recipient = "916742994@qq.com";
        sms.send(recipient, "游建明", "hello");
    }
}
