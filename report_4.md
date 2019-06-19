# report_4

----------

+ [项目部署地址](http://106.15.200.225)

+ [项目源代码地址](https://github.com/LitianD/sport_club_web_flux.git)

<!-- TOC -->

- [report_4](#report_4)
    - [1. Basic](#1-basic)
        - [1.1 webflux机构设计](#11-webflux机构设计)
        - [1.2 数据库设计](#12-数据库设计)
        - [1.3 整体类图设计](#13-整体类图设计)
        - [1.4 Restful接口设计](#14-restful接口设计)
    - [2. Functional request handler](#2-functional-request-handler)
        - [2.1 类设计结构](#21-类设计结构)
        - [2.2 部分API设计](#22-部分api设计)
    - [3. Persisting data reactively](#3-persisting-data-reactively)
        - [3.1 依赖配置](#31-依赖配置)
        - [3.2 数据库接口构建](#32-数据库接口构建)
    - [4. Security](#4-security)
    - [5. 程序运行截图](#5-程序运行截图)

<!-- /TOC -->

## 1. Basic

### 1.1 webflux机构设计

![](/docImage/webflux.png)

### 1.2 数据库设计

![](/docImage/ER_Model.png)

### 1.3 整体类图设计

**Handler Router设计**

![](/docImage/FluxHandler.png)

**Service设计**

![](/docImage/FluxService.png)

**Repository设计**

![](/docImage/FluxRepository2.png)

### 1.4 Restful接口设计

[RestfulAPI](API_NEW.md)

[更多基础设计 见report_1 Basic部分](report_1.md)

## 2. Functional request handler
+ 使用funtional request handler代替原来的springmvc Controller部分

+ 每个entity构架一个Handler和Router，其中Handler处理request请求，Router添加restful路由

### 2.1 类设计结构

![](/docImage/h_r.png)

+ 设计有4个Handler 4个Router 以下为设计类图

![](/docImage/HandlerRouter.jpg)


### 2.2 部分API设计

+ course 部分API设计

![](/docImage/flux_api2.png)

+ gym 部分API设计

![](/docImage/flux_api3.png)

+ coach 部分API设计

![](/docImage/flux_api1.png)

## 3. Persisting data reactively

### 3.1 依赖配置
加入MongoDB的依赖项在Maven之中：

	<dependency>
          <groupId>org.springframework.boot</groupId>
           <artifactId>spring-boot-starter-data-mongodb</artifactId>
    </dependency>

给项目配置MongoDB的数据库源：

	spring.data.mongodb.uri=mongodb://localhost:27017/springboot-db
	spring.data.mongodb.uri=mongodb://name:pass@localhost:27017/dbname

### 3.2 数据库接口构建

构建查找的Repository实体：

![](/docImage/FluxRepository.png)

## 4. Security

![](/docImage/oauth_3.png)

+ 对课程list资源施行token验证，用户没有从OauthServer获取的token无法访问资源

![](/docImage/oauth_2.png) 

## 5. 程序运行截图