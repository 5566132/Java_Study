## trx_id 和 roll_pointer
首先要知道, 表中的所有行都有两个隐藏字段, **trx_id** 和 **roll_pointer**
trx_id记录最新一次修改当前行的事务的id
rool_pointer回滚指针记录上一次修改记录的地址

## undo log 日志
光看这两个感觉不知道干嘛的, 所以要结合 undo log日志
undo log记录每次修改过后的行数据, 也就是对于每一行, 每次修改都会把这行记录在这个日志里面(有的时候可能会优化, 不去记录一整行)
所以对于一行数据就可以利用roll_pointer找到上一次记录的版本, 然后根据trx_id知道是哪个事务修改成这个版本了

## Read View针对事务记录数据的可见版本
Read View 里面有四个字段, 
creator_trx_id 创建Read VIew 的事务的id
m_ids 创建本Read View时**活跃且未提交**的事务id**列表**
min_trx_id 创建Read View时活跃未提交的事务的中的最小事务id
max_trx_id 创建Read View时应该分配给下一个事务的id



