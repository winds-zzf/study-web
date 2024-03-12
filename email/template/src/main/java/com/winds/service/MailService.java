package com.winds.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MailService {
    private final Logger logger = LoggerFactory.getLogger(MailService.class);

    /* JavaMailSender是SpringBoot提供的一个邮件发送接口，直接注入即可使用 */
    @Autowired
    private JavaMailSender mailSender;
    /* 获取配置文件中发送方的邮箱 */
    @Value("${spring.mail.from}")
    private String from;

    /**
     * 发送HTML邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String to,String subject,String content){
        // 获取MimeMessage对象
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try{
            //
            helper = new MimeMessageHelper(message,true);
            // 邮件发送人
            helper.setFrom(from);
            // 邮件接受人
            helper.setTo(to);
            // 邮件主题
            helper.setSubject(subject);
            // 邮件内容，HTML格式
            helper.setText(content,true);
            // 发送
            mailSender.send(message);
            // 日志信息
            logger.info("邮件已经发送。");
        }catch (MessagingException e) {
            logger.info("邮件发送时发生异常！",e);
        }
    }
}
