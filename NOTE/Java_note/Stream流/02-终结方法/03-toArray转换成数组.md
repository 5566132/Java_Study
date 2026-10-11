 依旧函数式接口
 把流中元素转换成指定类型
 接口中的方法要求返回一个new出来的数组, 流会自动把流中的元素放入这个数组中然后返回

我基本都只写匿名内部类形式了, 这个方便理解 ,但是Lambda表达式也必须掌握
 ```
 list.stream().toArray(new IntFunction<String[]>(){
	 @Override
	 public String[] apply(int value){
		 return new String[value];
	 }
 })
 ```
1.泛型需要指定返回的是什么类型的数组, 必须是数组形式 String`[]`
2.形参代表流中元素个数
