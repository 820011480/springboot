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
package com.example.day04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 20:36
 * 开启druid 监控
 * 两种方式：
 * 1. servlet 3.0 注解配置 (原生servlet  StatViewServlet  和 filter WebStatFilter)
 * 2. springboot bean配置
 */
@SpringBootApplication
public class JpaApplication {

    public static void main(String[] args) {

        SpringApplication.run(JpaApplication.class,args);
    }
}
