用之前先要导入依赖
`<!-- Resource依赖 -->`  
`<dependency>`  
    `<groupId>jakarta.annotation</groupId>`  
    `<artifactId>jakarta.annotation-api</artifactId>`  
    `<version>2.1.1</version>`  
`</dependency>`

这个只能用在属性上和set方法上, 相较于Autowired不能用在构造方法上
但是这个可以直接指定id,而不用@Qualifier去指定id

规则就是
如果指定了id就必须按照id找
没指定就先按照名字找, 属性就是这个变量的名称, set方法就是方法名, 如果没找到会降级为用类型找, 依旧多类型会报错
