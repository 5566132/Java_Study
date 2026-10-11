USE `mybatis-example`;

CREATE TABLE `t_product` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `product_name` VARCHAR(50) DEFAULT NULL,
  `price` DECIMAL(10,2) DEFAULT NULL,
  `stock` INT DEFAULT NULL,
  `category` VARCHAR(30) DEFAULT NULL,
  `create_time` DATETIME DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO t_product(product_name, price, stock, category, create_time) VALUES
('华为Mate70手机', 6999.00, 100, '手机数码', '2026-10-01 10:00:00'),
('小米手环9', 249.00, 500, '智能穿戴', '2026-10-02 11:30:00'),
('罗技无线鼠标', 129.00, 300, '电脑外设', '2026-10-03 09:15:00'),
('机械键盘87键', 399.00, 150, '电脑外设', '2026-10-04 14:20:00'),
('漫步者蓝牙耳机', 299.00, 200, '影音娱乐', '2026-10-05 16:45:00');
