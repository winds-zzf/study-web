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
     * 发送简单文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMail(String to,String subject,String content){
        /*
         * 简单邮件通过SimpleMailMessage对象封装打包邮件数据，最后通过JavaMailSender类将数据发送出去
         */
        // 创建SimpleMailMessage对象
        SimpleMailMessage message = new SimpleMailMessage();
        // 邮件发送
        message.setFrom(from);
        // 邮件接受人
        message.setTo(to);
        // 邮件主题
        message.setSubject(subject);
        // 邮件内容
        message.setText(content);
        // 通过JavaMailSender类把邮件发送出去
        mailSender.send(message);
    }

    /**
     * 发送HTML邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    public void sendHtmlMail(String to,String subject,String content){
        /*
         *
         */

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


    /**
     * 发送带福附件的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filepath 附件路径
     */
    public void sendAttachmentMail(String to,String subject,String content,String filepath){
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try{
            /*
             *
             * 第一个参数:
             * 第二个参数: true表示支持多组件，如附件、图片等
             */
            helper = new MimeMessageHelper(message,true);
            // 邮件发送人
            helper.setFrom(from);
            // 邮件接受人
            helper.setTo(to);
            // 邮件主题
            helper.setSubject(subject);
            // 邮件内容,HTML格式
            helper.setText(content,true);
            //获取附件的文件对象
            FileSystemResource file = new FileSystemResource(new File(filepath));
            // 邮件添加附件，可多次调用该方法添加多个附件
            helper.addAttachment(file.getFilename(),file);
            // 邮件发送
            mailSender.send(message);
            //记录日志
            logger.info("发送带附件邮件成功");
        } catch (MessagingException e) {
            logger.info("发送带附件邮件失败",e);
        }
    }

    /**
     *
     * @param to
     * @param subject
     * @param content
     * @param resourcePath
     * @param resourceId
     */
    public void sendInlineResourceMail(String to,String subject,String content,String resourcePath,String resourceId){
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try{
            helper = new MimeMessageHelper(message,true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content,true);
            //
            FileSystemResource res = new FileSystemResource(new File(resourcePath));
            // 将图片添加到message内容中resourceId的位置，重复使用可添加多张图片
            helper.addInline(resourceId,res);
            mailSender.send(message);
            logger.info("发送带图片邮件成功");
        } catch (MessagingException e) {
            logger.info("送带图片邮件失败",e);
        }
    }
}
