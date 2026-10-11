**任务是指Runnable对象,   Callable对象也被包含在内, 但是有点特殊**
Future这是个接口, 我先说一下这个东西的大概职责, 就是**对任务的状态进行管理**
豆包总结是: Future【接口】是**异步任务的结果凭证与任务控制器**
这个接口就是为了管理任务的状态, 以及接收任务的返回结果
public interface Future\<V> {
    boolean cancel(boolean mayInterruptIfRunning);
    boolean isCancelled();
    boolean isDone();
    V get() throws InterruptedException, ExecutionException;
    V get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException;
}

cancel( Boolean ); 就是给任务标记一个状态, 其本身不会中断任务
其实任务只是一个实现了Runnable接口的对象而已, 它本身并非线程, 想要执行还是要等线程调度, 所以这个标记的作用场景有点不同:
当任务还在阻塞队列的时候, 调用了cancel无论参数如何, 这个任务都不会执行了
当任务正在被执行时, 如果参数为true, 那就会在下一次阻塞( sleep() wait()  )的时候就会抛出异常, 这个时候我就可以根据业务逻辑, 选择是直接结束run还是继续执行
如果为false则没有作用, 这个任务会执行完

isDone();就是判断任务是否已经完成

get();是为了拿到任务的返回值结果的方法, 
这个方法是会阻塞进程的
无参是直到得到返回值才停止阻塞, 有参是设定一个最长等待时间

其实这是个接口, 线程池内部用这个接口的时候其实是用的它的实现类对象也就是
FutureTask\<>这个类, 这个类会把Runnable还有Callable都包装成Callable的对象去使用, 应该是因为返回值的原因
FutureTask类实现了 RunnableFuture接口, 而RunnableFuture接口继承了Runnable, Future接口, 所以, 可以用Future去接收FutureTask的实现类对象 -> 这一步是线程池的submit()的返回值实现的

