USE `mp`;

ALTER TABLE `tb_user` CHANGE `is_married` `age` INT DEFAULT NULL;

UPDATE tb_user SET age = 25 WHERE id = 1;
UPDATE tb_user SET age = 30 WHERE id = 2;
UPDATE tb_user SET age = 28 WHERE id = 3;
UPDATE tb_user SET age = 35 WHERE id = 4;
UPDATE tb_user SET age = 22 WHERE id = 5;
