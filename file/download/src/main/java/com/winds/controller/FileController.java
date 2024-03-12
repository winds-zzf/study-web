package com.winds.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@RestController
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/download")
    public void download(HttpServletResponse response) throws Exception{
        String filename = "a.txt";
        // 文件地址：真实环境是存放在数据库中
        String filePath = "/home/winds/Desktop/file/";
        File file = new File(filePath+filename);
        // 创建输入对象
        FileInputStream fis = new FileInputStream(file);
        // 设置相关格式
        response.setContentType("application/force-download");
        // 设置下载后的文件名及header
        response.setHeader("Content-Disposition","attachment;fileName="+filename);
        // 创建输出对象
        OutputStream os = response.getOutputStream();
        //常规操作
        byte[] buf = new byte[1024];
        int len = 0;
        while((len = fis.read(buf)) != -1){
            os.write(buf,0,len);
        }
        fis.close();
    }
}
