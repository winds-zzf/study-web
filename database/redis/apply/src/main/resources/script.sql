create database test;
use test;

drop table if exists user;
create table user
(
    id   int                          not null
        primary key,
    name varchar(50) charset utf8mb3  not null,
    pwd  varchar(100) charset utf8mb3 not null
);

insert into user values(1,'beixi','123456');
insert into user values(2,'jzj','123456');


