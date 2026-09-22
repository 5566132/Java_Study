FileOutputStream这个类用于把数据记录到文件
FileOutputStream fos = new FileOutputStream("要写入的文件路径", 参数2 );
之后的写入操作就都是针对这个路径的文件的了, 参数2可以指定是否删除文件原先数据
fos.write(int);传入的是int类型则会被识别为Ascall表的字符, 

**fos.write(byte`[]`, int off , int len )** 可以指定一个字节数组, 后两个参数可以不写, 不写就是把整个字节数组载入, 第一个代表起始索引, 第二个代表要载入的个数
fos.close() 依旧是 **一定要记住 close()**









FileInputStream从文件读数据
FileInputStream fis = new FileInputStream("路径");
读取文件会有返回值, 根据读取方式不同返回值有差别
读取可以每次只读一个字节, 用一个int类型的变量接收就行, 这个时候读到了就是返回这个字节的在Ascall表里面的值, 读到文件末尾就返回-1

也可以用字节数组读 byte`[]` 
byte`[]` by = new byte`[1024]`;
fis.read( by );
这样每次就会根据by的长度读取文件, 返回值是读取到的长度, 比如只剩下5个字节, 那就会返回5, 这么读有个特点就是把读到的每个字节都赋值给byte数组, 所以会出现一个问题, 就是读到接近末尾那里数组只有一部分会被覆盖, 还有一部分是原先的旧值, 
所以, 读的时候用一个变量 len 接收read的返回值, 既可以判断是否读到文件末尾, 也可以得到读到的长度
然后用 fos.write( by , 0 , len );这个方法写入文件, 就不会出现错误值了