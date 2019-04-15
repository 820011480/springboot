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
package com.example.day06.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.example.day03.domain.User;
import com.example.day06.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 14:20
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        log.info("方法之前拦截！");
//        User loginUser = (User)httpServletRequest.getSession().getAttribute("loginUser");
//        if (user == null || )
//        if (o instanceof HandlerMethod){
//            HandlerMethod handlerMethod = (HandlerMethod)o;
//            MyAnnotation annotation = handlerMethod.getMethodAnnotation(MyAnnotation.class);
//            if (annotation != null){
//                return true;
////            }
//        }else {
//            return true;
//        }
//
        Cookie[] cookies = httpServletRequest.getCookies();
        String token = "";
        for (Cookie cook:cookies){
            if("token".equals(cook.getName())){
                 token = cook.getValue();
            }
        }
        token = "eyJhbGciOiJIUzI1NiIsIlR5cGUiOiJKd3QiLCJ0eXAiOiJKV1QifQ.eyJsb2dpbk5hbWUiOiJtYWR5IiwicHdkIjoiMTIzNDU2IiwiZXhwIjoxNTU1MDUzMDY4fQ.5svj7ykgVobH74nEZAxLCAfj02SvW2LGV87a9wBlCjo";
        if (token == null || token == "" ){
            throw new RuntimeException("没有有效token");
        }
        //对 token 进行验证
        Map<String, Claim> claims = JWT.decode(token).getClaims();
        long tokenTime = JWT.decode(token).getExpiresAt().getTime();
        if (tokenTime - System.currentTimeMillis()<= 0 ){
            throw new RuntimeException("token已过期,请重新登录");
        }
        boolean verfiy = TokenUtils.verfiy(token);
        if (!verfiy){
            throw new RuntimeException("无效token,请重新登录");
        }
//        获取用户名和密码
//        claims.forEach((k,v)->{
//            System.out.println(k);
//            System.out.println(v.asString());
//        });
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        log.info("方法执行后操作！");
    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        log.info("返回视图前操作");
    }

    public static void main(String[] args) {
        List<User> list1 = new ArrayList<>();
        list1.add(new User(1,"111","111",11));
        list1.add(new User(2,"222","222",11));
        list1.add(new User(3,"333","333",11));
        list1.add(new User(4,"444","444",11));
        list1.add(new User(5,"555","555",11));


        List<User> list2 = new ArrayList<User>();
        list2.add(new User(11,"1111","111",11));
        list2.add(new User(2,"222","222",11));
        list2.add(new User(3,"333","333",11));
        list2.add(new User(42,"4443","444",11));
        list2.add(new User(5,"555","555",11));

        List<User> collect = list1.stream().filter(
                    item -> list2.stream()
                .map(e -> e.getUsername())
                .collect(Collectors.toList())
                .equals(item.getUsername()))
                .collect(Collectors.toList());

        System.out.println(collect);

    }
}
