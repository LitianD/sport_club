# report_2

----------

[项目部署地址](http://106.15.200.225)（存在用户 username:admin  password:admin）

<!-- TOC -->

- [report_2](#report_2)
    - [1.Basic](#1basic)
        - [1.1前后端分离设计](#11前后端分离设计)
        - [1.2数据库设计](#12数据库设计)
    - [2.Rate Limiting](#2rate-limiting)
        - [2.1 Guava 限流](#21-guava-限流)
        - [2.2 Nginx 限流](#22-nginx-限流)
    - [3. API设计](#3-api设计)
        - [3.1 RESTFul风格设计](#31-restful风格设计)
    - [4.Online API Doucument](#4online-api-doucument)
    - [5.Oauth Authetication](#5oauth-authetication)
    - [6.Cache](#6cache)
        - [6.1 Redis Cache](#61-redis-cache)
        - [6.2 Http cache](#62-http-cache)
    - [7.Hateos](#7hateos)

<!-- /TOC -->

## 1.Basic

### 1.1前后端分离设计

![](/docImage/front_back.png)

### 1.2数据库设计

![](/docImage/ER_Model.png)


[更多基础设计 见report_1 Basic部分](report_1.md)

## 2.Rate Limiting

### 2.1 Guava 限流

### 2.2 Nginx 限流

+ limit_req_zone 用来限制单位时间内的请求数，即速率限制,采用的漏桶算法 “leaky bucket” 

![](docImage/nginx_1.jpg)

+ limit_req_conn 用来限制同一时间连接数，即并发限制 

具体配置为:
	
	limit_zone one $binary_remote_addr 20m;
	limit_req zone = req_one burst=130;
	linit_req_zone $limit zone=req_one:20m rate=20r/s;
	limit_conn one 15;


## 3. API设计

### 3.1 RESTFul风格设计

[sportClub API Version1.0](API_V1.md)

## 4.Online API Doucument

## 5.Oauth Authetication


![](/docImage/oauth_3.png)


+ 对课程list资源施行token验证，用户没有从OauthServer获取的token无法访问资源

![](/docImage/oauth_2.png)
## 6.Cache

### 6.1 Redis Cache

+ Redis 基本配置

![](/docImage/redis_conf.png)

+ 查看课程列表
    
    在函数前添加注解
    @Cacheable(value = "courseList")、
    系统自动生成键值对存入redis缓存中，加速数据的查询。
    
    
+ 查看课程详情
   
    在函数前添加注解
    @Cacheable(value = "courseInfo", key = "#id")
    系统根据课程id作为键存入redis缓存中，加速数据的查询。

### 6.2 Http cache


## 7.Hateos

当用户访问固定路径`/` `/user` `/course` `/coach` `gym`时候返回连接：

![](/docImage/Hateos.png)

返回json类图为：

![](/docImage/Hateos_1.png)