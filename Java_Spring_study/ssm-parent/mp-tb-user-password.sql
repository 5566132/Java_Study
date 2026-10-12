USE `mp`;

ALTER TABLE `tb_user` ADD COLUMN `password` VARCHAR(50) DEFAULT NULL;

UPDATE tb_user SET password = '123456';
