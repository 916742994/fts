package com.verity.controller;

import com.verity.util.email.SimpleMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Youjm on 2016/8/20.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value = "/vcode")
    public ModelAndView index() {
        return new ModelAndView("/index");
    }


    @RequestMapping(value = "/sendEmail", method = RequestMethod.POST)
    @ResponseBody
    public String sendEmail(String security, String email, HttpServletRequest request) throws MessagingException {
        String rightCode = (String) request.getSession().getAttribute("randomCode");
        if (security.equalsIgnoreCase(rightCode)) {
            SimpleMailSender sms = new SimpleMailSender("18860116743@163.com", "ming0206you");
            sms.send("916742994@qq.com", "verify模块发送邮件", "测试邮件");
            return "success";
        }
        return "fail To Send";
    }
}
