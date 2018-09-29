package com.example.websockt.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
     * webSocket控制器
     */
    @Controller
    public class WebSocketController {

        @MessageMapping("/hello") //当浏览器向服务端发送请求时,通过@MessageMapping映射/welcome这个地址,类似于@ResponseMapping
        @SendTo("/topic/hello")//当服务器有消息时,会对订阅了@SendTo中的路径的浏览器发送消息
        public AricResponse hello(String hello) {
            try {

                System.out.println("wojieshoudao xiaoxi " +  hello);
                //睡眠1秒
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return new AricResponse("welcome," + hello + "wojieshoudao xiaoxi ");
        }
    }

