USE `mybatis-example`;

DELETE FROM t_emp;

INSERT INTO t_emp(id, emp_name, age, emp_salary) VALUES
(1, 'tom', 18, 200.33),
(2, 'jerry', 19, 666.66),
(3, 'andy', 20, 777.77);
