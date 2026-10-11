这部分就是可以应对任何响应内容, 我可以自己决定响应给服务端的响应头, 响应体等内容, 
主要利用 HttpEntity\<> 和 **ResponseEntity\<>** ( 后者更常用 ) 作为方法返回值, 自己去配置内部的响应头, 响应体内容
这里用文件下载举例


文件下载指的是, 用户点击按钮发出请求浏览器直接在右上角下载内容了
这个在后端发响应有个固定的模板

```
@RequestMapping("/download")  
public ResponseEntity<InputStreamResource> resp02() throws IOException {  
    //读文件  
    File f = new File("路径");
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
```
返回值是ResponseEntity\<>类型的对象, 这个对象是SpringMVC中用来组装响应报文的
换句话说, return部分的参数就是在设置响应报文的参数, 这个泛型是为了适配代码中方法体的类型的, 比如二进制用流, 字节数组,   json可以写类

## 响应报文参数设置
这部分是用链式编程实现的, 相对顺序没关系, 我就逐一讲了
ok() -> 代表正常返回, 对应[[03-响应处理/00-前言,写了/00-前言, 写了]]状态行中的一个状态码
contentType() 能看出来, 就是设置响应头Content-Type的参数, 传递的是json, 文本, 
还是二进制数据等
contentLength() 设置响应体的字节数
header() 添加响应头 格式是 "key" , "value" 这个例子写到HTTP响应报文中就是
Content-Disposition:attachment;filename=xxx.png
**body()** 传递响应体的内容, 没有就不写(bode())呗, 首先传递的对象要和返回值的泛型一致, 没了

## InputStreamResource
这个是个包装类, 把流中的二进制数据包装成SpringMVC可以看懂的资源对象, 
其实用字节数组也能达到一样的效果, 因为只要把所有二进制字节数据传递给浏览器就可以了, 但是因为字节数组有大小限制, 所以用这个更方便
