package com.winds;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.winds.service.MailService;

/**
 * 测试类中的类和方法设置成public才能正常运行
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    // 注入发送邮件的接口
    @Autowired
    MailService mailService;

    /**
     * 测试发送简单文本邮件
     */
    @Test
    public void sendSimpleMail(){
        mailService.sendSimpleMail("2768523766@qq.com","主题:普通邮件","内容：第一封纯文本邮件");
    }

    /**
     * 测试发送HTML邮件
     */
    @Test
    public void sendHtmlMail(){
        mailService.sendHtmlMail("2768523766@qq.com","主题:HTML邮件","<h1>内容：第一封HTML邮件</h1>");
    }

    /**
     * 测试发送带附件邮件
     */
    @Test
    public void sendAttachmentMail(){
        mailService.sendAttachmentMail("2768523766@qq.com","主题:带附件邮件","<h1>内容：第一封带附件邮件</h1>","/home/winds/Desktop/file/a.txt");
    }

    @Test
    public void sendInlineResourcesMail(){
        // 资源路径
        String resourcePath = "/home/winds/Desktop/file/picture.png";
        //
        String resourceId = "001";
        // 需要使用cid标注出静态资源
        String content = "<html><body><h1>内容：第一封带图片邮件</h1><img src=\'cid:"+resourceId+"\'></body></html>";
        mailService.sendInlineResourceMail("2768523766@qq.com","主题:带图片邮件",content,resourcePath,resourceId);
    }
}
