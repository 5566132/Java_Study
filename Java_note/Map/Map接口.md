**明确一点, Map系列的子类要不通过键得到值, 要不就利用entrySet()这类方法将 键 值 键值 装入一个Collection接口的集合里面去遍历**


首先Map里面有一个Entry的接口, 这个接口规定了Map系列的键值之类的东西, Map的子类里面会有重写这个接口的方法
**Map系列的类都是依靠Entry这个东西存键值的**

// 增改
V put(K key, V value);
void putAll(Map\<? extends K,? extends V> m);
// 删除
V remove(Object key);
void clear();
// 查询
V get(Object key);
boolean containsKey(Object key);
boolean containsValue(Object value);
int size();
boolean isEmpty();
// 三个视图方法（转成Collection体系）
Set\<K> keySet();
Collection\<V> values();
Set\<Map.Entry<K,V>> entrySet();
// 比较
boolean equals(Object o);
int hashCode();
