package com.winds;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.winds.service.MailService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    MailService mailService;
    /* 使用TemplateEngine对模板进行渲染 */
    @Autowired
    private TemplateEngine engine;
    @Test
    public void sendTemplateMail(){
        // 向Thymeleaf模板传值，并解析成字符串
        Context context = new Context();
        context.setVariable("id","001");
        /*
         * 参数一是需要Thymeleaf渲染的HTML模板emailTemplate.html。
         * 参数二提供模板渲染所需要的数据(类似于Model)
         * emailTemplate.html页面解析完毕后，得到HTML字符串，将其作为邮件发送的主题内容content。
         */
        String content = engine.process("emailTemplate",context);

        // 发送Html邮件
        mailService.sendHtmlMail("2768523766@qq.com","这是一个模板文件",content);
    }
}
