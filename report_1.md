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

## Basic

### MVC设计结构

### 系统功能（待补充 运行截图和描述）
+ 登陆
+ 注册
+ 查询课程
+ 查看课程
+ 课程详情

## JPA featues（待补充 运行截图和描述）

### 多表联查

### 多数据库源

### 分页查询

### 审计

## Web Cache（待补充 运行截图和描述）

### server_cache Redis

### client_cache

