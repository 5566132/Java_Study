这个东西用于拦截客户端发来的请求, 其中有三个拦截时机, 也就是三个方法, 分别是
请求到Controller之前, Controller执行完之后, 视图渲染完之后
如果你想要拦截, 首先要创建一个类实现HandleInterceptor接口, 并把这个类注解为组件, 然后内部实现三个方法
```
public boolean preHandle( HttpServletRequest request, HttpServletResponse response, Object handler )

public void postHandle( HttpServletRequest request, HttpServletResponse response, Object handler,  @Nullable ModelAndView modelAndView )

public void afterCompletion( HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex )
```
你也看到了, 这几个方法又臭又长, 我单独讲讲, 主要是那几个参数
