这是一个类要创建对象用
Duration dur = Duration.between(ldt1, ldt2);
计算ldt1和ldt2之间的时间差
这个计算出来的数会转化成 PTxxHxxMxxS 这样的形式
如果想要输出你想要的单位需要
dur.toHours()
dur.toSeconds()
这类方法转化一下
