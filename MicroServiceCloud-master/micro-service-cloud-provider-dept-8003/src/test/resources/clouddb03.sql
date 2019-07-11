DROP DATABASE IF EXISTS clouddb03;
CREATE DATABASE clouddb01 CHARACTER SET UTF8;
USE clouddb03;

CREATE TABLE dept (
  deptNo BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  deptName VARCHAR(60),
  dbSource VARCHAR(60)
);

INSERT INTO dept (deptName, dbSource) VALUES ('开发部', DATABASE());
INSERT INTO dept (deptName, dbSource) VALUES ('人事部', DATABASE());
INSERT INTO dept (deptName, dbSource) VALUES ('财务部', DATABASE());
INSERT INTO dept (deptName, dbSource) VALUES ('市场部', DATABASE());
INSERT INTO dept (deptName, dbSource) VALUES ('运维部', DATABASE());

SELECT * FROM dept;