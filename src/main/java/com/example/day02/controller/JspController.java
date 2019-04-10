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
package com.example.day02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 19:13
 */

/**
 * 1. 引入pom文件
 * 2. 添加view解析配置
 * 3. 添加webapp文件
 * 4. 添加jsp文件
 */
@RequestMapping(value ="/jsp")
@Controller
public class JspController {

    @GetMapping("/test")
    public String index (Model model){
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        model.addAttribute("names" , list);
        return "index";
    }
}
