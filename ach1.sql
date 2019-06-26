-- 创建数据库时,设置数据库的编码方式
-- CHARACTER SET:指定数据库采用的字符集,utf8不能写成utf-8
-- COLLATE:指定数据库字符集的排序规则,utf8的默认排序规则为utf8_general_ci（通过show character set查看）
create database ach1 CHARACTER SET utf8 COLLATE utf8_general_ci;
use ach1;

--建表
drop table if exists tb1_customer;
create table tb1_customer(
uuid int not null auto_increment,
customerId varchar(50),
pwd varchar(50),
showName varchar(100),
trueName varchar(100),
registerTime varchar(100),
primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb1_goods;
create table tb1_goods(
uuid int not null auto_increment,
name varchar(200),
imagePath varchar(500),
description varchar(2000),
primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb1_cart;
create table tb1_cart(
uuid int not null auto_increment,
customerUuid int,
goodsUuid int,
buyNum int,
primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb1_order;
create table tb1_order(
uuid int not null auto_increment,
customerUuid int,
orderTime varchar(100),
totalMoney float,
saveMoney float,
state smallint,
primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb1_orderDetail;
create table tb1_orderDetail(
uuid int not null auto_increment,
orderUuid int,
goodsUuid int,
orderNum int,
price float,
money float,
saveMoney float,
primary key (uuid)
) charset=utf8 ENGINE=InnoDB;

drop table if exists tb1_store;
create table tb1_store(
uuid int not null auto_increment,
goodsUuid int,
storeNum int,
primary key (uuid)
) charset=utf8 ENGINE=InnoDB;
