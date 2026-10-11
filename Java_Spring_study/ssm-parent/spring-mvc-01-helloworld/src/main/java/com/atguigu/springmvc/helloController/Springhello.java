package com.atguigu.springmvc.helloController;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class Springhello {

    @RequestMapping("/hello")
    public String handle(){
        return "Hello MVC!! 你好";
    }


    @RequestMapping(value = "/xin_all", produces = "image/jpeg")
    public void handle2(HttpServletResponse response) throws IOException {
        //response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        File f1 = new File("D:\\A_java\\Java_Spring_study\\ssm-parent\\spring-mvc-01-helloworld\\src\\main\\java\\com\\atguigu\\springmvc\\Photo\\ShinanoWedding.png");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f1));
        BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
        byte[] temp = new byte[1024];
        int len;
        while((len = bis.read(temp)) != -1){
            bos.write(temp, 0, len);
        }
    }


    @RequestMapping(value = "/xin_get", method = RequestMethod.GET)
    public String handle3() throws IOException {
       return "只能接收到POST请求6666";
    }

    @RequestMapping(value = "/xin_pa", params = {"age"})
    public String handle4() throws IOException {
        return "限制了要有age";
    }




}
