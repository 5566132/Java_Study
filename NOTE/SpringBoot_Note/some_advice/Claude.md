● 你的基础我摸清了:JavaSE 扎实、MySQL 学得挺深(MVCC、B+Tree、锁都碰过)、Spring6 的 IoC/AOP/事务也过了一遍,还差 Web
  层和持久层。我先确认下当前的课程情况。

● Web Search("尚硅谷 SpringBoot3 雷丰阳 教程 2026 最新")
  ⎿  Did 1 search in 8s

● Web Search("黑马程序员 苍穹外卖 SpringBoot3 就业项目 2026 评价")
  ⎿  Did 1 search in 18s

  Listed 1 directory, wrote 3 memories (ctrl+o to expand)

● 你的基础挺适合直接上 SpringBoot 的,但有个缺口要先说:你还没学 MyBatis 和 Redis,这两个在 SpringBoot
  项目里是绕不开的。下面是给你的路线。

  主干课:尚硅谷 SpringBoot3(雷丰阳)

  选它的理由:你 Spring 就是跟尚硅谷学的(IoC/AOP/事务),语法习惯和技术栈是连贯的,不用换脑子;而且它是 Java 17 + SpringBoot
  3 的版本,2026 年招聘要求基本都写 SB3 了,别去看老的 SB2 教程。课程直接覆盖整合 SpringMVC 做 Web 开发和整合 MyBatis
  数据访问,正好把你要补的 Web 层和持久层一起补了。后半段的 Redis、Kafka、SpringSecurity 可以先跳过,用到再回看。

  另外要单独补一个 MyBatis-Plus(B站随便找个 2 小时的速通即可),实际工作中用得比原生 MyBatis 多。

  练手项目:黑马《苍穹外卖》

  技术栈很全:SpringBoot + MyBatis + Redis + JWT + Nginx +
  微信小程序,业务量也够大(几十个接口),是打基本功最合适的项目,EasyExcel 导出、WebSocket
  来单提醒、微信支付这些点都能练到。

  但这里有个 2026 年的关键坑:苍穹外卖已经"烂大街"了,牛客和 linux.do 上 26
  秋招的反馈是"用这个很难约到面""外卖项目稍弱"。所以建议:

  - 拿它练手完全没问题,该踩的坑(缓存不一致、JWT 登录失效、跨域)照踩,这些是真收获
  - 但别原样写简历。想用它投简历,至少要做二开:升级到 JDK 17 + SpringBoot 3(处理 javax → jakarta 迁移)、修原项目源码
  bug、把 Redis 部分(缓存一致性、分布式锁)讲深
  - 有条件的话配一个 黑马点评(Redis 深度项目)一起,面试官爱问 Redis,这个比外卖更能拉分

  建议顺序

  1. 尚硅谷 SB3 前半段(Web + 整合 MyBatis)—— 约 2~3 周
  2. MyBatis-Plus 速通 + Redis 入门(B站大学,别学太深,够用就行)
  3. 苍穹外卖 全程走一遍 —— 约 1 个月
  4. 二开/升级 + 补亮点,写成简历项目

  一个建议:别把 SB3 教程从头到尾刷完再动手,看到整合完 MyBatis 就停下来直接进项目,剩下的
  Redis/安全/监控在项目里遇到再回看,效率高很多。

  顺便提醒,你力扣 hot100 别停,后端校招笔试和一面算法是硬门槛。

  Sources:
  - 尚硅谷 SpringBoot3 官方课程页 (https://atguigu.com/video/260/)
  - 尚硅谷新版 SpringBoot3 教程(B站) (https://www.bilibili.com/video/BV1Es4y1q7Bf/)
  - 一文讲清新手到底要不要写《苍穹外卖》和《黑马点评》(牛客)
  (https://m.nowcoder.com/discuss/748946571785408512?sourceSSR=subject)
  - 26秋招 Java 求职讨论(牛客)
  (https://www.nowcoder.com/feed/main/detail/319fa15c7aac4fdcb78ed5716a73d777?sourceSSR=users)
  - 从"苍穹外卖"到"敕勒食驿":项目升级实战 (https://segmentfault.com/a/1190000047619546?sort=votes)