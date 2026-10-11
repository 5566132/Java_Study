package com.atguigu.springmvc.responseindex;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.html.parser.Entity;
import java.io.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;


@RestController
public class Controller {
    @Autowired
    private ApplicationContext ac;


    @RequestMapping("/handle01")
    public String handle01(String name, String password, String cellphone, String agreement){
        System.out.println(name);
        System.out.println(password);
        System.out.println(cellphone);
        System.out.println(agreement);
        return "OK!!";
    }
    @RequestMapping("/handle02")
    public String handle02(
            @RequestParam("username") String name,
            @RequestParam(value = "password", required = false, defaultValue = "6666666666")String pw,
            @RequestParam("cellphone")String p,
            @RequestParam(value = "agreement", required = false)String agree,
            @RequestParam(value = "nihao", required = false, defaultValue = "我不是很好, 这个参数没有被报文携带")String what)
    {
        System.out.println(name);
        System.out.println(pw);
        System.out.println(p);
        System.out.println(agree);
        System.out.println(what);
        return "2222222";
    }



    @RequestMapping("/handle03--")
    public String handle03(Per p){
        System.out.println(p);
        return "33333333333333";
    }


    @RequestMapping("/handle04")
    public String handle04(@RequestHeader("Host") String host , @RequestHeader("user-agent") String useragent){
        System.out.println("这里是handle04");
        System.out.println(host);
        System.out.println(useragent);
        return "4444444444444\n" + useragent;
    }


    @RequestMapping("/handle05")
    public String handle05(@CookieValue("666") String str){
        System.out.println("这里是handle05, 看看Cookie");
        System.out.println(str);
        System.out.println();
        return "5555555555555" + str;
    }

    @RequestMapping(value = "/handle06", method = RequestMethod.POST)
    public String handle06(@RequestPart("j") Big j){

        System.out.println(j.toString());
        return "66666666666";
    }

    @RequestMapping("/handle08-----")
    public String handle08(Per p, MultipartFile headerImg , @RequestParam("lifeImg") MultipartFile[] ll) throws IOException {
        System.out.println(p.toString());
        String he = "D:\\A_java\\Java_Spring_study\\ssm-parent\\spring-mvc-01-helloworld\\src\\main\\java\\com\\atguigu\\springmvc\\Photo\\";
        String name = headerImg.getOriginalFilename();
        File f = new File(he + name);
        headerImg.transferTo(f);
        int i;
        for(i=0;i<ll.length;i++){
            name = ll[i].getOriginalFilename();
            f = new File(he + name);
            ll[i].transferTo(f);
        }
        System.out.println("图片传输成功, 888");
        return "8888888888888";
    }

    @RequestMapping("/handle08---")
    public String handle09(HttpEntity<String> entity){
        HttpHeaders hh = entity.getHeaders();
        String Body = entity.getBody();
        System.out.println(hh);
        System.out.println(Body);


        return "9999999999";
    }


    @RequestMapping("/handle08")
    public Map<String, Object> handle10(@RequestParam Map<String, Object> body, @RequestParam("headerImg") MultipartFile mf1 , @RequestPart("lifeImg") MultipartFile[] mf2){
        for(Map.Entry<String, Object> entry : body.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        return body;
    }











}


/*
json

```
{
    "username":"你好",
    "age":20,
    "isStudent":true,
    "arr":["12", 13],
    "cl":{
    "age":"12",
    "name":"小子"
    }
}
```












 */
