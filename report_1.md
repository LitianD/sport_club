# report_1

----------

@[TOC](目录)

## 1.Basic——70%（待补充 运行截图和描述）

## 1.1前后端分离设计

![](/docImage/front_back.png)

### 1.2数据库设计

![](/docImage/ER_Model.png)

设计有4个实体分别为 user course coach gym

+ user与course关系为 ManyToMany
+ course与gym关系为 ManyToOne
+ course与gym关系为 ManyToOne

设计数据表有（待补充完整）

+ user()
+ user_course()
+ course（）
+ coach（）
+ gym（）



### 1.3UML设计类图

**Controller设计**

![](/docImage/controller.png)

**Service设计**

![](/docImage/service.png)

**Repository设计**

![](/docImage/repositiory.png)

**Response Json设计**

![](/docImage/resJson.png)

### 1.4系统功能

+ 登陆
+ 注册
+ 查询课程
+ 查看课程
+ 课程详情

## 2.JPA featues——15%（待补充 运行截图和描述）

### 2.1多表联查

### 2.2多数据库源

### 2.3分页查询

### 2.4审计



## 3.Web Cache——15%（待补充 运行截图和描述）

### 3.1Server_cache Redis

### 3.2Client_cache

