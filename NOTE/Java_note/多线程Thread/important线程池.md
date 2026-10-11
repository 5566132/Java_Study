
public ThreadPoolExecutor(int corePoolSize,
                          int maximumPoolSize,
                          long keepAliveTime,
                          TimeUnit unit,
                          BlockingQueue\<Runnable> workQueue,
                          ThreadFactory threadFactory,
                          RejectedExecutionHandler handler)
  
corePoolSize：核心线程数量，一直保留，不会被回收(核心线程会被循环利用, 用完1之后会固定用2, 就算1处于空闲也是如此)
maximumPoolSize：最大线程总数（核心 + 临时线程）
keepAliveTime：临时空闲线程的存活时间
unit：时间单位( keepAliveTime的 )
workQueue：阻塞队列，存放等待的 Runnable 任务
threadFactory：线程工厂，用来创建线程，可以自定义线程名字
handler：拒绝策略，队列满 + 线程达到最大值，新任务执行这个策略


主要说后三个, 因为前四个都很好理解
先说前置知识[[Future]] 因为阻塞队列里面存放的是任务(Runnable实现类对象), 而Future是获取任务的结果以及管理控制的工具
workQueue阻塞队列
阻塞队列有大概5个类, 但是线程池暂时只用ArrayBlockingQueue\<>(数量);
因此这个参数一般就写 new ArrayBlockingQueue\<>(3); 因为只能传递Runnable所以泛型空着也可以
但是说到这里我就有问题了, submit()会把传入的Runnable和Callable都变成Callable类型, 不准确的说是都包装成FutureTask\<>类型的对象, 那放入阻塞队列的不就是FutureTask对象了吗, 但是ArrayBlockingQueue的泛型是Runnable呀, 看源码可以得知
![[Pasted image 20260916180839.png]]
所以自然可以把FutureTask的对象放入阻塞队列
