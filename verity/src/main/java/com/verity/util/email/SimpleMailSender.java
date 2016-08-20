package com.verity.util.email;


import com.verity.domain.MailAuthenticator;
import com.verity.domain.SimpleMail;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Properties;

/**
 * 简单邮件发送器，可单发，群发
 * Created by Youjm on 2016/3/5.
 */
public class SimpleMailSender {
    private final transient Properties props = System.getProperties();

    private transient MailAuthenticator authenticator;
    private transient Session session;

    public SimpleMailSender(final String username, final String password) {
        //通过邮箱地址解析出smtp服务器，对大多数邮箱都管用
        final String smtpHostName = "smtp." + username.split("@")[1];
        init(username, password, smtpHostName);
    }

    private void init(String username, String password, String smtpHostName) {
        //初始化 props
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", smtpHostName);
//        props.put("mail.smtp.starttls.enable","true");
//        props.put("mail.smtp.debug", "true");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
//        props.put("mail.smtp.socketFactory.fallback", "false");

//        props.put("mail.smtp.port", "465");
//        props.put("mail.smtp.socketFactory.port", "465");


        //验证
        authenticator = new MailAuthenticator(username, password);
        //创建session
        session = Session.getInstance(props, authenticator);
    }


    public void send(String recipient, String subject, Object content) throws AddressException, MessagingException {

        //创建mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        //设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        //设置收件人
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
        //设置主题
        message.setSubject(subject);
        //设置邮件内容
        message.setContent(content.toString(), "text/html;charset=utf-8");
        //发送
        Transport.send(message);
    }


    public void send(List<String> recipients, String subject, Object content) throws AddressException, MessagingException {

        //创建Mime类型邮件
        final MimeMessage message = new MimeMessage(session);
        //设置发信人
        message.setFrom(new InternetAddress(authenticator.getUsername()));
        //设置收信人们
        final int num = recipients.size();
        InternetAddress[] addresses = new InternetAddress[num];
        for (int i = 0; i < num; i++) {
            addresses[i] = new InternetAddress(recipients.get(i));
        }
        message.setRecipients(Message.RecipientType.TO, addresses);
        //设置主题
        message.setSubject(subject);
        //设置邮件内容
        message.setContent(content.toString(), "text/html;charset=utf-8");
        //发送
        Transport.send(message);
    }


    public void send(String recipient, SimpleMail mail) throws AddressException, MessagingException {
        send(recipient, mail.getSubject(), mail.getContent());
    }
}
