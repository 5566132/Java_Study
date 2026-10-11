请求体就是空行后面那部分, 如果那部分是json格式的可以用如下方式接收

**json的内容要使用类之前必须要用@ReauestBody注解这个类形参**
@RequestMapping("/handle")
public String handle( @RequestBody Person p ){ -> 这样才能把请求体接收到p中
	
}
用类的成员去对应json内容中的key,从而接收相应的value
具体看[[02-JSON的内容]]
