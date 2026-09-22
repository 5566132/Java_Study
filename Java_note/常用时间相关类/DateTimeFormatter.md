这个是时间格式化的类, 相当于给时间设置一个规范, 然后用这个规范去把时间转变成字符串(format)或者把字符串转变成时间类(parse)

DateTimeFormatter dtf = DateTimeFormatter().ofPattern("yyyy-MM-dd");
这个就相当于给这个类初始化, 但是现在只初始化了年月日, 所以只能给LocalDate的类进行解析
也就是ld = LocalDate.parse(字符串, dtf);

格式化就是给时间类转成字符串
String s = dtf.format(ld);


总的来说这个玩意就相当于规定一个形式, 让传递进来的字符串可以转变成时间类, 让时间类也可以转变成字符串

