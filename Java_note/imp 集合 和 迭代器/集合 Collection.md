集合是一个接口, 里面有一些通用的抽象方法 List  Set接口派生出的类都可以用
add(E);
remove(E); 根据equals判断元素是否相同, 选择移除
clear();
contains(E); 依旧利用equals判断是否包含元素
isEmpty(); 判断是否为空
size(); 返回元素个数

**toArray(); 把调用者变成数组的形式  -> 数组是 `[]**`**
比如:
ArrayList\<String> arr = new ArrayList<>();
String`[]` s = arr.toArray(new String`[0]`);
new String`[0]`这步比较重要
首先new是给数组的内部元素开辟空间, 
String是指定类型, 因为这里的参数是泛型的, 所以需要什么类型就指定成什么类型
`[0]` 中括号0是利用了底层原理, 准确的说这个是指定长度用的, 但是就跟那个Arrays的copy一样, 少了会自动补, 多了填null, 所以指定0就可以



还有一个 iterator(); 返回一个迭代器接口的实现了对象, 
比如Collection\<Integer> arr = new ArrayLIst<>();
	Iterator\<Integer> it = arr.iterator();
	这就创建了一个Integer类型的迭代器, 
