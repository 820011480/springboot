/**
 * Project: demo
 * <p>
 * File Created at 2019/4/12
 * <p>
 * Copyright 2019 e-dewin.com
 * Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * dewin Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with e-dewin.com
 */
package com.example.day08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.MimeMessage;
import java.io.File;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/12 16:04
 */
@RestController
public class MailController {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.frommail}")
    private String fromSender;

    @Value("${spring.mail.tomail}")
    private String toSender;

    /**
     * 发送简单文本
     */
    @GetMapping("/simpletext")
    public String sendText(){
        try{
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //setfrom
            simpleMailMessage.setFrom(fromSender);
            //setto
            simpleMailMessage.setTo(toSender);
            //setsubject
            simpleMailMessage.setSubject("test mail");
            //setText
            simpleMailMessage.setText("Hello Mail");
            //发送太慢 异步处理发送

            javaMailSender.send(simpleMailMessage);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
    /**
     * 发送html文本
     */
    @GetMapping("/simpleHtml")
    public String sendHtml(){
        try{
            String content="<html>\n" +
                    "<body>\n" +
                    "    <h3>hello world ! 这是一封Html邮件!</h3>\n" +
                    "</body>\n" +
                    "</html>";
            MimeMessage message = javaMailSender.createMimeMessage();
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromSender);
            helper.setTo(toSender);
            helper.setSubject("html mail");
            helper.setText(content, true);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }


    /**
     * 发送附件邮件
     */
    @GetMapping("/simpleFile")
    public String sendFile(){
        try{
            String filePath = "D:/mady/springboot/src/main/resources/dw_vehicle_gps1_days30.sql";
            MimeMessage message = javaMailSender.createMimeMessage();
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromSender);
            helper.setTo(toSender);
            helper.setSubject("html mail");
            helper.setText("这是一个带附件的文本", true);
            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName ="dw_vehicle_gps1_days30.sql";
            helper.addAttachment(fileName, file);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }

    /**
     * 发送图片邮件
     */
    @GetMapping("/simplePicture")
    public String sendPicture(){
        try{
            String Id = "mady123";
            String content="<html><body>这是有图片的邮件：<img src=\'cid:" + Id + "\' ></body></html>";
            String imgPath = "D:/mady/springboot/src/main/resources/static/123.jpg";
            MimeMessage message = javaMailSender.createMimeMessage();
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(fromSender);
            helper.setTo(toSender);
            helper.setSubject("picture mail");
            helper.setText(content, true);
            FileSystemResource res = new FileSystemResource(new File(imgPath));
            helper.addInline(Id, res);
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
        return "success";
    }
}
