@ReuqestParam("请求体中要接收的part的名") MultipartFile mf
@RequestPart("一样") MultipartFile mf

传来的所有二进制文件都直接用这个类型接收就行
说一下这个类的几个方法
```
//1. 获取原始文件名（前端上传的文件名，如 "ShinanoWedding2.png"）
String getOriginalFilename()

//2. 获取文件MIME类型（image/png、image/jpeg）
String getContentType()
这个会获得请求体中这个part的Content-Type字段的类型, 可以用来校验获得的文件和这个类型是否一致, 但是还是不太安全

//3. 判断是否为空（有没有选文件上传）
boolean isEmpty()

//4. 获取文件二进制字节数组 byte[]（小文件用，大文件容易OOM）
byte[] getBytes()

//5. 获取输入流InputStream（推荐！大文件，流式读取）
InputStream getInputStream()

//6.【最推荐】直接保存文件到目标磁盘，**底层自动处理IO关闭**
void transferTo(File dest) throws IOException
```