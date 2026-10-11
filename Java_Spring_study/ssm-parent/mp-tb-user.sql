USE `mp`;

CREATE TABLE `tb_user` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(30) DEFAULT NULL,
  `is_married` TINYINT(1) DEFAULT NULL,
  `order` INT DEFAULT NULL,
  `address` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

INSERT INTO tb_user(name, is_married, `order`, address) VALUES
('张三', 1, 1, '北京市朝阳区'),
('李四', 0, 2, '上海市浦东新区'),
('王五', 1, 3, '广州市天河区'),
('赵六', 0, 4, '深圳市南山区'),
('孙七', 1, 5, '杭州市西湖区');
