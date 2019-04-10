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
package com.example.day01.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 18:49
 */

@RestController  //@Controller  @ResponseBody
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/test")
    public String getInfo(){
        return "learn springboot， hello world!";
    }
}
