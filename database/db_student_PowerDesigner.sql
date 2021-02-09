/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2020/7/19 13:50:25                           */
/*==============================================================*/


drop table if exists tb_class;

drop table if exists tb_course;

drop table if exists tb_depart;

drop table if exists tb_score;

drop table if exists tb_spec;

drop table if exists tb_student;

drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_class                                              */
/*==============================================================*/
create table tb_class
(
   classId              int(10) not null auto_increment,
   className            varchar(50) not null,
   specId               int(10) not null,
   primary key (classId)
);

/*==============================================================*/
/* Table: tb_course                                             */
/*==============================================================*/
create table tb_course
(
   courseId             int(10) not null auto_increment,
   courseName           varchar(50) not null,
   courseScore          double(5,2) not null,
   primary key (courseId)
);

/*==============================================================*/
/* Table: tb_depart                                             */
/*==============================================================*/
create table tb_depart
(
   departId             int(10) not null auto_increment,
   departName           varchar(50) not null,
   primary key (departId)
);

/*==============================================================*/
/* Table: tb_score                                              */
/*==============================================================*/
create table tb_score
(
   scoreId              int(10) not null auto_increment,
   courseId             int(10) not null,
   stuId                int(10) not null,
   score                double(5,2) not null,
   primary key (scoreId)
);

/*==============================================================*/
/* Table: tb_spec                                               */
/*==============================================================*/
create table tb_spec
(
   specId               int(10) not null auto_increment,
   specName             varchar(50) not null,
   departId             int(10) not null,
   primary key (specId)
);

/*==============================================================*/
/* Table: tb_student                                            */
/*==============================================================*/
create table tb_student
(
   stuId                int(10) not null auto_increment,
   stuName              varchar(50) not null,
   stuSex               int(10) not null default 1,
   stuBirth             date default NULL,
   classId              int(10) not null,
   primary key (stuId)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   userId               int(10) not null auto_increment,
   userName             varchar(50) not null,
   userPwd              varchar(50) default NULL,
   userType             int(10) not null default 0,
   primary key (userId)
);

alter table tb_class add constraint FK_Reference_2 foreign key (specId)
      references tb_spec (specId) on delete cascade on update cascade;

alter table tb_score add constraint FK_Reference_4 foreign key (courseId)
      references tb_course (courseId) on delete cascade on update cascade;

alter table tb_score add constraint FK_Reference_5 foreign key (stuId)
      references tb_student (stuId) on delete cascade on update cascade;

alter table tb_spec add constraint FK_Reference_3 foreign key (departId)
      references tb_depart (departId) on delete cascade on update cascade;

alter table tb_student add constraint FK_Reference_1 foreign key (classId)
      references tb_class (classId) on delete cascade on update cascade;

