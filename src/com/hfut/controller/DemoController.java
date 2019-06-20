package com.hfut.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class DemoController {
    @RequestMapping("upload")
    public String upload(MultipartFile file,String name) throws IOException{
        MultipartResolver mr=null;
        System.out.println("name"+name);
        String fileName=file.getOriginalFilename();
        String suffix=fileName.substring(fileName.lastIndexOf("."));
        String uuid= UUID.randomUUID().toString();
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File("E:/"+uuid+suffix));
        return "/index.jsp";
    }
}
