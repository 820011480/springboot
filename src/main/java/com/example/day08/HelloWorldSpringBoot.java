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
package com.example.day08;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/12 15:58
 * 配置SpringBoot支持自动装载Servlet
 */
@SpringBootApplication
@ServletComponentScan(value = "com.example.day08.servlet")
public class HelloWorldSpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(HelloWorldSpringBoot.class,args);
    }

}
