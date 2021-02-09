# CIT学生信息管理系统

## 项目概述

CIT学生信息管理系统（CIT Student Information Management System，简称CITSIMS），这是我在大二暑期参加数据库项目实践实训的课程设计。CITSIMS是基于Java+MySQL完成的一款控制台管理系统项目，所有数据库结构及代码编写都是我独立自主设计和开发，该系统能够满足大多数学校学生信息管理的需求，具有包括学生、班级、院系、专业、课程、成绩等管理的常见功能。

## 功能说明

用户注册、登录功能；管理员可以对学生信息进行增删改查、对班级信息进行增删改查、对专业信息进行增删改查、对学院信息进行增删改查、对课程信息进行增删改查、对学生成绩信息进行增删改查、对成绩进行排序输出、统计不及格的学生等、对系统用户进行管理包括添加用户，修改用户密码，删除用户等功能。默认注册为普通用户，仅具有查询院系信息、查询班级信息、查询专业信息、查询课程信息、查询学生成绩等基础功能。

## 开发环境

* [JDK13.0.2](https://www.oracle.com/java/technologies/javase-jdk13-downloads.html)
* [Eclipse IDE for Enterprise Java Developers](https://www.eclipse.org/downloads/packages/)
* [MySQL8](https://www.mysql.com/downloads/)
* [MySQL Connector/J](https://dev.mysql.com/downloads/connector/j/)

## 使用说明

1. 创建空的数据库`db_citsims`，然后导入`database`目录下的`db_student_DumpStructureOnly.sql`文件
2. MySQL配置文件在`src/util/JDBCUtil.java`,请根据自己的数据库信息合理的修改密码等信息
5. 在IDE中，运行view包下`login.java`即可进行进入CIT学生信息管理系统主程序
6. 第一步导入的SQL脚本文件不含任何测试数据，无账号请选择注册进行注册后登录。 
7. Word、PDF版课程设计报告在`docs`目录下，可以当模板进行参考
6. 使用Eclipse IDE导入项目源文件，导入项目如果出现中文乱码，请右键项目"Properties"--"Resource"设置项目编码格式为"UTF-8"
7. 因为每个人的JRE版本不一样，打开项目如果遇到JRE环境丢失，项目"Properties"--"Java Build Path"--"Libraries"中移除不存在的Modelpath，然后点击"Add Library"添加您本机已安装的JRE环境
8. 默认注册普通用户（`userType = 0`），普通用户仅有查看功能，无修改、添加删除功能；
9. 如果需要测试数据，请导入`database`目录下的`db_student_DumpStructure_and_Data.sql`，数据库的`tb_user`表中有学生系统管理员账号：`admin`，密码为`admin`，可以用其登录测试。

## 系统功能结构图

![](https://cdn.jsdelivr.net/gh/vicosna/PicBed@master/2021/02/20210209173906.png)

**拆分如下：**

**管理员部分系统图**

![](https://cdn.jsdelivr.net/gh/vicosna/PicBed@master/2021/02/20210209173941.png)

**普通用户系统功能结构图**

![](https://cdn.jsdelivr.net/gh/vicosna/PicBed@master/2021/02/20210209173942.png)

## 数据库E-R图

![](https://cdn.jsdelivr.net/gh/vicosna/PicBed@master/2021/02/20210209173943.png)

## 运行截图

![](https://cdn.jsdelivr.net/gh/vicosna/PicBed@master/2021/02/20210209173944.png)

## 所需技能

1. Java语言基础
2. JDBC实现方法
3. MySQL数据库的基本使用

本项目仅供个人学习参考食用（¯﹃¯），原创不易，严禁倒卖。

