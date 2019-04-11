/**
 * Project: demo
 * <p>
 * File Created at 2019/4/11
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
package com.example.day06.controller;

import com.example.day06.domain.ResultBody;
import com.example.day06.domain.Token;
import com.example.day06.domain.User;
import com.example.day06.service.ITokenService;
import com.example.day06.service.IUserService;
import com.example.day06.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 16:11
 */
@RestController
@RequestMapping("/user")
public class LoginController {
    @Autowired
    private IUserService userService;
    @Autowired
    private ITokenService tokenService;

    @GetMapping("/login")
    public ResultBody userLogin(@RequestBody User user){
        boolean condition = user == null || user.getUsername() == null || user.getPassword() == null;
        if (condition){
            return ResultBody.fail(20001,"用户名或密码为空");
        }
        //验证数据用户和传过来的用户是否一致
        Boolean userFlag = userService.verfiy(user);
        //签发认证(生成token)
        if (userFlag){
            Token token = tokenService.findByUserId(user.getId());
            Long time = System.currentTimeMillis();
            if (null == token){
                //第一次登陆:
                token.setUserid(user.getId());
                token.setToken(TokenUtils.sign(user.getUsername(),user.getPassword()));
                token.setCreateTime(time.intValue());
            }else {
                //第二次登陆 (更新token)
                token.setToken(TokenUtils.sign(user.getUsername(),user.getPassword()));
                token.setCreateTime(time.intValue());
            }
            tokenService.addToken(token);
            return ResultBody.ok(token);
        }
        return ResultBody.fail(20003,"用户名或密码错误");
    }

}
