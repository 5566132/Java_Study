这个东西是JDK8及之后的版本才有的

注意看名字, 翻译就是当前日期时间
所以, 这个类就是存日期和时间两个量的
当然也有 LocalDate 和 LocalTime 这两个类单独应对日期和时间的情景
这些初始化规则都一样
LocalDateTime.now()    LocalDateTime.of(2026, 11, 11, 12, 59)年月日时分

然后就是这个玩意可以结合DateTimeFormatter去获取时间
String s = "2026-1-1";
DateTImeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
LocalDateTime ldt = LocalDateTine.parse( s, dtf );

准确的说这个东西就是用来存储一个时间的
存储之后内部有一些方法可以对这个时间进行操作
plueDays( 2 );这类可以返回给调用者加上某个时间段的时间

