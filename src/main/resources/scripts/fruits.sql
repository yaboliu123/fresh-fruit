CREATE DATABASE IF NOT EXISTS FruitsDB DEFAULT CHARACTER SET = utf8;

USE FruitsDB;

DROP TABLE IF EXISTS `Boss`;

CREATE TABLE `Boss`  (
	`Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	`BossName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'BossName',
	`Address` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'Address',
	`Phone` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'Phone',
	`CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP  COMMENT 'CreatedTime',
	`LastModifiedBy` varchar(32) NOT NULL DEFAULT 'default' COMMENT 'LastModifiedBy',
    `LastModifiedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'LastModifiedTime',
	`Status` varchar(32) NOT NULL DEFAULT '' COMMENT 'Boss Status',
	PRIMARY KEY(`Id`),
	KEY `Phone` (`Phone`(191))
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Boss Table';

DROP TABLE IF EXISTS `Customer`;

CREATE TABLE `Customer` (
	`Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
	`BossId` int(10) unsigned NOT NULL COMMENT 'Boss 主键',
	`BossName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'BossName',
	`CustomerName` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'CustomerName',
	`Phone` varchar(500) NOT NULL DEFAULT 'default' COMMENT 'Phone Number',
	`CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
	`LastModifiedBy` varchar(32) NOT NULL DEFAULT '' COMMENT 'last updated by',
    `LastModifiedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Modified time',
	`Status` varchar(32) NOT NULL DEFAULT '' COMMENT 'Customer Status',
	`Account` float(10, 2) COMMENT 'Account money',
	PRIMARY KEY(`Id`),
	KEY `BossName`(`BossName`(191)),
	KEY `Phone` (`Phone`(191))
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Customer Table';

DROP TABLE IF EXISTS `Shopping`;
CREATE TABLE `Shopping` (
    `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
    `CustomerId` int(10) NOT NULL COMMENT 'Customer Id',
    `CreatedTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation Time',
    `Amount` float(10,2) NOT NULL COMMENT 'Shopping amount',
    PRIMARY KEY(`Id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Customer Table';

DROP TABLE IF EXISTS `Users`;

CREATE TABLE `Users` (
  `Id` int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Username` varchar(64) NOT NULL DEFAULT 'default' COMMENT '用户名',
  `Password` varchar(64) NOT NULL DEFAULT 'default' COMMENT '密码',
  `Email` varchar(64) NOT NULL DEFAULT 'default' COMMENT '邮箱地址',
  `Enabled` tinyint(4) DEFAULT NULL COMMENT '是否有效',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

DROP TABLE IF EXISTS `Authorities`;
CREATE TABLE `Authorities` (
  `Id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增Id',
  `Username` varchar(64) NOT NULL,
  `Authority` varchar(50) NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4

--INSERT into `Authorities` (`Username`, `Authority`) values("admin", "ROLE_user")
--insert into Users (Username, Password, Email, Enabled) values('admin','$2a$10$7r20uS.BQ9uBpf3Baj3uQOZvMVvB1RN3PYoKE94gtz2.WAOuiiwXS', 'admin@123.com', 1);