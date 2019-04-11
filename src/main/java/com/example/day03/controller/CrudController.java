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
package com.example.day03.controller;

import com.example.day03.domain.User;
import com.example.day03.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 20:37
 *
 * jpa 排坑:
 * TransactionRequiredException : update /delete 需要事务
 * 插入主键的时候可以使用 原生sql 语句
 */
@RestController
@RequestMapping("/user")
public class CrudController {

    @Autowired
    private IUserService userService;

    @GetMapping("/query")
    public String getQuery(){
        return userService.getQuery(1).toString();
    }
    @GetMapping("/add")
    public String getAdd(){
        userService.addUser(new User(1,"mady","123456",20));
        return "success";
    }

    @GetMapping("/del")
    public String getDel(){
        userService.delUser(1);
        return "success";
    }
    @GetMapping("/update")
    public String getUpdate(){
        userService.updateUser(new User(1,"mady_new","123",30));
        return "success";
    }
}
