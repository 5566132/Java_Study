IO的部分有很多是包装类, 目的是为了简化数据的传输(比如BufferedRead)
但是包装类本身不会开启一个数据通道, 能开启数据通道的是 "流"
也就是以InputStream  OutputStream  Reader  Writer 作为后缀的( 准确的说是这些接口的子类 )一些类, 以及系统输入System.in  System.out
比如 FileInputStream 开启一个文件读取通道

注意**包装类都要以 "对应的"  "流"  作为参数才能创建对象**
对应的代表要和包装类的类型匹配, 缓冲输入字符流(BufferedRead)就必须要接收
**"输入" "字符"**\这个类型的 **"流"**
"**流**" 代表开启的数据通道


比如BufferedReader br = new BufferedReader( FileReader );
缓冲字符输出流接收输入字符流的对象为参数, 正确

**BufferedRead br = new BufferedReader( new InputStreamReader( System.in ) );**
因为System.in属于字节输入流, 重点是字节流, 这个不是字符流, 不能直接传递给字符流的包装类, 所以 InputStreamReader 起到一个把字节流转变成字符流的作用, 这样就能传递给字符流的包装类了

**important**
**1.字符流的底层依旧是字节流**
**2.记住流跟包装类是不一样的东西, 包装类本身不会创建流需要传递一个已经开启了(new)的流包装类真的就只是把这个流包装一下( 加上缓冲区, 减少磁盘IO );**
**3.给包装类传递流要床底对应类型的流, 类型不对就用InputStreamReader 这个类转换一下**




