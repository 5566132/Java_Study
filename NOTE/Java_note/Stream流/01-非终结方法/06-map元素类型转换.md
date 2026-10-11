map() 方法有个形参, 这个形参是一个函数式接口, 也就是这个接口内部只有一个方法
准确来说, 这个map的作用不至于类型转换, 因为map是把内部的方法的返回值直接作为流中的元素了
比如"你好-2026" 这个字符串我完全可以只保留2026部分, 然后转换成int类型返回, 这就不止于类型转换了吧

### 匿名内部类实现
```
list.stream().map(new Function<String, Object>(){
	@Override
	public Object apply(String s){
		int year = Integer.parseInt(s.split("-")[1]);
		return year;
	}
}).forEach(year->sout(year));

```
## Lambda表达式实现
别忘了只有函数式接口可以用Lambda表达式实现
```
list.stream().map(s -> Integer.parseInt(s.split("-")[1])).forEach();
```