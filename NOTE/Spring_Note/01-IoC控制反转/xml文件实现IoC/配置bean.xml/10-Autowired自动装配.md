就是把 aurowired = "byName/byType" 写在bean的标签上, spring就会根据名称或者类型去自动给这个类内部的成员类自动装配bean
首先你要自动装配的bean要存在, 
其次你要符合限制

byName
这个是看set方法对应的名称, 根据这个名称去对应bean的id

byType
这个就是看我需要的成员类是什么类型, 然后去找这个类型的bean, 但是这就要求整个spring只能有一个这个类型的bean
