package com.atguigu.springmvc.responseindex;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Map;




@RestController
public class ResponseController {
    @Autowired
    private ApplicationContext ac;

    @ResponseBody
    @RequestMapping("/resp01")
    public Per resp01(@RequestHeader("Host") Map<String, String> m){
        Per ret = ac.getBean(Per.class);
        for(Map.Entry<String, String> temp : m.entrySet()){
            String key = temp.getKey();
            System.out.println("key = " + key);
            if(key.equals("Host") || key.equals("host")){
                ret.setHost(temp.getValue());
            }
        }

        return ret;
    }


    @RequestMapping("/download")
    public ResponseEntity<InputStreamResource> resp02() throws IOException {
        //读文件
        File f = new File("D:\\A_java\\Java_Spring_study\\ssm-parent\\spring-mvc-01-helloworld\\src\\main\\java\\com\\atguigu\\springmvc\\Photo\\ShinanoWedding2.png");
        FileInputStream fis = new FileInputStream(f);
        //设置文件名可以中文编码
        String encode = URLEncoder.encode("信浓wedding.png", "UTF-8");
        //包装文件流的数据, 包装成spring可以识别的资源对象
        InputStreamResource isr = new InputStreamResource(fis);

        //
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .contentLength(f.length())
                .header("Content-Disposition", "attachment;filename=" + encode)
                .body(isr);
    }







}
