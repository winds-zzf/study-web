create table user
(
    id       int auto_increment comment '主键'
        primary key,
    name     varchar(10) default '' null comment '用户姓名',
    password varchar(32) default '' null comment '密码'
);


