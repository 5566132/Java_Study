你只创建了一个实现了拦截器接口的类是无法使用拦截器的, 
需要再写一个配置类 ,  用这个配置类去实现WebMvcConfigurer这个接口
实现了这个接口你才可以在配置类内部重写WebMvcConfigurer中的方法, 用这些方法才可以给指定的 路径( Path ) 这里可以回忆一下, 拦截器这个东西是给Web中Controller里面处理请求的方法配置的, 所以肯定要指定拦截器拦截那些路径, 也就是Controller的注解@RequestMapping等指定的那个路径, 

`@Configuration`  
`public class MyMvcConfig implements WebMvcConfigurer{`  
    `@Autowired`  
    `MyHandlerInterceptor1 mi1;`  
    `@Autowired`  
    `MyHandlerInterceptor2 mi2;`  
    `@Autowired`  
    `MyHandlerInterceptor3 mi3;`  
    `@Override`  
    `public void addInterceptors(InterceptorRegistry registry){`  
        `registry.addInterceptor(mi1).addPathPatterns("/**");`  
        `registry.addInterceptor(mi2).addPathPatterns("/**");`  
        `registry.addInterceptor(mi3).addPathPatterns("/**");`  
    `}`  
`}`
addInterceptors就是用来添加拦截器的, 用那个registry参数指定要添加哪些拦截器以及给哪个路径添加, 
