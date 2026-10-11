依旧是形参为函数式接口, 

## 匿名内部类写法
```
list.stream().forEach(new Consumer<String>(){
	@Override
	public void accept(String s){
		这里可以写任何操作, 这个方法是真的会移动迭代器指针
		也就是说所有操作都会作用在流中的元素上
	}
})
```
