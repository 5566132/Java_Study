USE `mybatis-example`;

INSERT INTO customer(id, customer_name, phone) VALUES
(1, '张三', '13800138000'),
(2, '李四', '13900139000'),
(3, '王五', '13700137000');

INSERT INTO t_order(id, address, amount, customer_id) VALUES
(1, '北京市朝阳区望京SOHO', 199.5, 1),
(2, '上海市浦东新区张江高科', 399.0, 1),
(3, '广州市天河区珠江新城', 899.5, 2),
(4, '深圳市南山区科技园', 59.9, 3);
