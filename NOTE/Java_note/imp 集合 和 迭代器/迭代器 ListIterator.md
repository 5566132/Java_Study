继承于 Iterator 这个接口

新增了
hasPrevious();判断是否存在前一项
E previous(); 获得前一项并前移迭代器

获取前一项 或者 后一项的索引
nextIndex();
previousIndex();

set(E e); 修改当前迭代器的左侧的元素
add(E e); 在当前迭代器左侧加入元素