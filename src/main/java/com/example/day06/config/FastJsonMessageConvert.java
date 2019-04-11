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
package com.example.day06.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 12:28
 * 自定义消息转化器
 *
 *
 */
@Configuration
public class FastJsonMessageConvert extends WebMvcConfigurerAdapter {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        //调用父类的配置
        super.extendMessageConverters(converters);
        //设置fastjsonhttpmessageconvert
        FastJsonHttpMessageConverter fastJsonMessageConvert = new FastJsonHttpMessageConverter();
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.WriteNullStringAsEmpty,SerializerFeature.WriteNullListAsEmpty,SerializerFeature.DisableCircularReferenceDetect);
        fastJsonMessageConvert.setFastJsonConfig(fastJsonConfig);
        //将自定义视图转化器添加进去
        converters.add(fastJsonMessageConvert);
    }
}
