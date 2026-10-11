这个一定要注意如果Controller中的一个方法想要返回json数据, 就必须把这个方法用
@RequestBody注解, 或者把Controller类用@RequestBody注解, 所以你知道了
@RestController这个Rest是什么意思了吗, 就是把@RequestBody和@Controller两个注解合并了

这个简单, 甚至什么响应头都不用指定, 
只需要保证方法的返回值是一个 类的类型
然后返回一个类对象就行, 但是主意好字段一一对应
