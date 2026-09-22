这个就是不会去重的, 可以直接用下标访问( get(下标) )的一类集合
这个接口继承了 Collection 的方法, 并有几个新增的常用方法

// 在指定索引位置插入元素，原来元素后移
void add(int index, E element);

// 获取指定下标元素
E get(int index);

// 修改指定下标位置的元素，返回旧值
E set(int index, E element);

// 删除指定下标元素，返回被删除的元素❗重载方法
E remove(int index);

// 返回对象第一次出现的下标，找不到返回‑1
int indexOf(Object o);

// 返回对象最后一次出现的下标，找不到返回‑1
int lastIndexOf(Object o);

后两个查找依旧要重写equals()才能按值查找, 复杂度也是O(n) (那我为什么不手找呀? )
