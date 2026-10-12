USE `mp`;

ALTER TABLE `tb_user` ADD COLUMN `create_time` DATETIME DEFAULT NULL;

UPDATE tb_user SET create_time = NOW();
