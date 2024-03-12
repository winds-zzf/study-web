create database test;

use test;
drop table if exists user;
create table user
(
    id int auto_increment comment '主键',
    username varchar(32)  default '' null comment '用户姓名',
    password varchar(100) default '' null comment '密码',
    role     varchar(32)  default '' null comment '角色',
    primary key (id)
);



## 添加用户信息
insert into user values(1,'User','123','user');
insert into user values(2,'Admin','123','admin');