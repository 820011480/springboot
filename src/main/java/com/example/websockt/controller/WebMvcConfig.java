package com.example.websockt.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
     * 配置viewController,为页面提供路径映射
     */
    @Configuration
    public class WebMvcConfig extends WebMvcConfigurerAdapter{

        /**
         * 配置viewController,提供映射路径
         */
        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/webSocket").setViewName("/webSocket");
        }
    }


