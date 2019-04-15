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
package com.example.day08.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/15 19:16
 */
@WebServlet(urlPatterns = {"/hello/test1","/hello/test2"})
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //判断那个方法
        String method = req.getMethod();
        String name = "";
        if ("get1".equals(method)){
            //进行编码转换:
            name = req.getParameter("name");
            byte[] bytes = name.getBytes("ISO-8859-1");
            name = new String (bytes,"UTF-8");
        }else {
//            req.setCharacterEncoding("UTF-8");
            name = req.getParameter("name");
        }
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.write("执行方法为:" + method +"输出一个字符串:" + name);
        writer.close();
    }
}
