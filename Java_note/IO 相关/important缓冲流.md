**本质就是给字节/字符流的类(你要知道字符流的缓冲区本身是属于InputStreamReader这个类内部的另一个类的, 而且是字节形式的缓冲区, )加了一个缓冲区, 因为这个类是包装了, 本身还是==需要字节流的类去读取或者输出数据==**
**回忆一下, 字节流的类本身就是根据路径去开启一个数据通道, 有了这个通道才能传递数据, 而缓冲流本身只是一个外壳, 内部还是需要对应的(非缓冲)流的通道, 所以, 在创建缓冲流的对象时, 要传递对应的流对象**
比如**BufferedReader**就要传递**字符输入流的对象**
BufferedInputStream 传递 字节输入流
BufferedOutputStream 字节输出流

所以BufferedReader br = new BufferedReader(new InputStreamReader(File对象));
