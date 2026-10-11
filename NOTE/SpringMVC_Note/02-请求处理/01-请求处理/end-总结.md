本质上, 处理请求就是处理HTTP报文的 请求行, 头, 体三个部分
不用SpringMVC的时候使用servlet底层的那些玩意去处理报文的, 很多细节都需要自己处理, 但是用了SpringMVC就省去了很多步骤, SpringMVC就是使用注解处理
这些注解都可以含有参数去限制获得的信息

大致就是把这三个部分分开处理, 每个部分都有相似, 有区别
请求行中内容不多, 而且SpringMVC没单独封装这部分的注解, 所以只能用原生的servelet了, 这个虽然没学但是可以说一下, 就是这个
```
HttpServletRequest req 
req.getMethod() 
req.getRequestURI() 
req.getProtocol()
```
虽然没有处理请求行的注解, 但是请求行中URL的参数可以用@RequestParam注解处理

请求头用@RequestHeader处理, 可以用变量接收指定的头, 也可以用
Map\<String, String>去接收所有头

请求体用@RequestParam或者@RequestPart或者@RequestBody处理
如果Content-Type标注为json, 也就是整个请求体都是json, 只能用@RequestBody接收

如果Content-Type是multipart/form-data也就是分块
1.碰到json用Param接收只能得到json的字符串, 用Part才能得到反序列化成的对象
2.但是@RequestParam有个优点就是, 可以用Map作为形参接收所有表单类型的数据
直接写@RequestParam Map\<String , Object> m就全接受了
3.对于二进制数据, 用Param和Part都可以, 但是必须用MultipartFile这个类接收
