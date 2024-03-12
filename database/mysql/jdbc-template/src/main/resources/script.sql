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



