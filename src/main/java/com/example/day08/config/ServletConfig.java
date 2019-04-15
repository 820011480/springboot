/**
 * Project: demo
 * <p>
 * File Created at 2019/4/15
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
package com.example.day08.config;

import com.example.day08.servlet.TestServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/15 19:33
 */
//@Configuration
public class ServletConfig {

    @Bean
    public ServletRegistrationBean getServletBean(){
        //传入servlet 以及对应的映射规则
        return new ServletRegistrationBean(new TestServlet(), "/*");
    }
}
