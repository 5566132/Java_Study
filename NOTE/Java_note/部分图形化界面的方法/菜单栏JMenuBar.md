这个东西就是类似idea里面的最上边那一栏, 里面有项目, 编辑, 视图, 帮助啥的
添加了这个就相当于给界面添加了一些功能选项
JMenuBar jmb = new JMenuBar();创建菜单栏
JMenu jm = new JMenu(字符串);创建菜单
JMenuItem jmi = new JMenuItem(字符串); 创建菜单里面的项目
jm.add(jmi);把项目添加到菜单
jmb.add(jm)把菜单添加到菜单栏

最后别忘了把菜单栏添加到 JFrame
this.setJMenuBar(jmb);
这个的意思是调用本类对象的方法去获得隐藏主界面, 然后把菜单栏添加到隐藏主界面
