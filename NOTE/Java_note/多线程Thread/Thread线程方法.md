**这些方法都是针对Thread这个类, 或者其子类的**

void setName(String name); 设置当前线程名称
首先只有线程有名字, 所以这些方法都是针对Thread这个类的, 当然, 有参构造也能设置名称

String gerName(); 获取当前线程名称

static Thread currentThread(); 获取当前线程的对象(对象可以调用方法)

static void sleep(long time); 当前线程休眠time毫秒

