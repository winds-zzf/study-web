package com.winds.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 文件上传
 *  SpringMVC在文件上传时，会将上传的文件映射为MultipartFile对象,
 */
@RestController
@RequestMapping("/file")
public class FileController {
    /**
     * 单文件上传
     *
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("file")MultipartFile file){
        // 获取原始名字
        String fileName = file.getOriginalFilename();
        // 文件保存路径
        String filePath = "/home/winds/Desktop/file/";
        // 文件重命名，防止重复
        fileName = filePath+ UUID.randomUUID()+fileName;
        // 文件对象
        File dest = new File(fileName);
        // 判断路径是否存在，如果不存在则创建
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        // 保存文件
        try{
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传失败";
    }

    /**
     * 多文件上传
     *
     */
    @RequestMapping("/uploads")
    public String uploads(HttpServletRequest request){
        //从request中获取文件的MultipartFile对象，这里的getFiles用到的就是input标签中的name字段值
        List<MultipartFile> files = ((MultipartHttpServletRequest)request).getFiles("file");
        // 遍历并处理每一个文件
        for (MultipartFile file:files){
            try{
                //获取原始名字
                String fileName = file.getOriginalFilename();
                //文件保存路径
                String filePath = "/home/winds/Desktop/file/";
                //文件重命名，防止重复
                fileName = filePath+UUID.randomUUID()+fileName;
                //文件对象
                File dest = new File(fileName);
                //保存到服务器(这个方法是MultipartFile类提供的，方法参数是File类，用于将接收到的文件存储到file对象对应的文件中)
                file.transferTo(dest);
            } catch (IOException e) {
                e.printStackTrace();
                return "上传失败";
            }
        }
        return "上传成功";
    }
}
