# report_1

----------


# 基础设计

## 数据库设计

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

## 前后端分离设计

![](/docImage/front_backend.jpg)

## 其他（待补充）



# 作业采分点



## 1.Basic——70%（待补充 运行截图和描述）

### MVC设计结构

### 系统功能
+ 登陆
+ 注册
+ 查询课程
+ 查看课程
+ 课程详情



## 2.JPA featues——15%（待补充 运行截图和描述）

### 多表联查

### 多数据库源

### 分页查询

### 审计



## 3.Web Cache——15%（待补充 运行截图和描述）

### Server_cache Redis

### Client_cache

