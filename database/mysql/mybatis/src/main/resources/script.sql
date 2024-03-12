create database test;
use test;

drop table if exists user;
create table user
(
    id       int auto_increment comment '主键'
        primary key,
    name     varchar(10) default '' null comment '用户姓名',
    password varchar(32) default '' null comment '密码'
);

insert into user values(1,'beixi','123456');
insert into user values(2,'jzj','123456');

drop table if exists book;
create table book
(
    id  int auto_increment comment '主键',
    name varchar(50) default '' null comment '书籍名称',
    price float default 0.0 null comment '书籍价格'
);

insert into book values(1,'C语言',35.6);
insert into book values(2,'Java基础',25.5);


