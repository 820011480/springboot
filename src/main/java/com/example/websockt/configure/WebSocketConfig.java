package com.example.websockt.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MessageConverter;
import org.springframework.messaging.handler.invocation.HandlerMethodArgumentResolver;
import org.springframework.messaging.handler.invocation.HandlerMethodReturnValueHandler;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.*;

import java.util.List;

/**
 * @Description:
 * @Author: vesus
 * @CreateDate: 2018/5/29 上午10:41
 * @Version: 1.0
 */

@Configuration
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
    /***
     * 注册 Stomp的端点
     * addEndpoint：添加STOMP协议的端点。提供WebSocket或SockJS客户端访问的地址
     * withSockJS：使用SockJS协议
     * @param registry
     */
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/socket")
                .setAllowedOrigins("*")//添加允许跨域访问
                .withSockJS() ;
    }
    /**
     * 配置消息代理
     * 启动Broker，消息的发送的地址符合配置的前缀来的消息才发送到这个broker
     */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        //fuw
        config.enableSimpleBroker("/topic");//配置客户端订阅前缀

        config.setApplicationDestinationPrefixes("/app");//配置客户端发送消息路径前缀
    }
}

