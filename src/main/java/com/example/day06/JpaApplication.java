/**
 * Project: demo
 * <p>
 * File Created at 2019/4/10
 * <p>
 * Copyright 2019 e-dewin.com
 * Corporation Limited.
 * All rights reserved.
 * <p>
 * This software is the confidential and proprietary information of
 * dewin Company. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with e-dewin.com
 */
package com.example.day06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 11:37
 * springboot 添加拦截器 基于jwt实现登录)
 *
 * Filter: 过滤器 基于servlet ，几乎可以过滤所有请求
 * Interceptor: 拦截器 ，基于web容器， 针对方法前后做处理。
 */
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaApplication.class,args);
    }
}
