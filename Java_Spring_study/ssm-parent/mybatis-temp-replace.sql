USE `mybatis-example`;

DELETE FROM t_emp;

INSERT INTO t_emp(id, emp_name, age, emp_salary) VALUES
(1, 'tom', 18, 200.33),
(2, 'jerry', 19, 666.66),
(3, 'andy', 20, 777.77),
(4, '小八', 100, 8888.88),
(5, '你是谁', 1008611, NULL),
(6, '为什么要用map呀', 66666, NULL);
