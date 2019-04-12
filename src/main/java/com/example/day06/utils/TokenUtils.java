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
package com.example.day06.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 15:09
 */
@Slf4j
public class TokenUtils {
    /**
     * token 过期时间15分钟过期
     */
    public static final long EXPIRE_TIME = 60*1000*15;
    /**
     * token 私钥
     */
    public static final String TOKEN_SECRET = "thefiersttoken";

    /**
     * 签名生成token
     * @param username
     * @param password
     * @return
     */
    public static String sign(String username ,String password){
        try{
            // 设置过期时间(当前时间+有效时长)
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            System.out.println(date);
            //加密算法
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            // 设置头部信息
            Map<String, Object> header = new HashMap<>(2);
            header.put("Type", "Jwt");
            header.put("alg", "HS256");
            String sign = JWT.create()
                    .withHeader(header)
                    .withClaim("loginName", username)
                    .withClaim("pwd", password)
                    .withExpiresAt(date)
                    .sign(algorithm);
            log.info("token结果:{}",sign);
            System.out.println();
            return sign;
        }catch(Exception e){
            log.error("签名出错：{}",e.getLocalizedMessage(),e.fillInStackTrace());
            return null;
        }
    }


    public static boolean verfiy(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (Exception e){
            log.error("验证错误:{}",e.getLocalizedMessage(),e.fillInStackTrace());
            return false;
        }
    }

    public static void main(String[] args) {
        String mady = sign("mady", "123456");
        System.out.println("token:" + mady);
        Map<String, Claim> claims = JWT.decode(mady).getClaims();
        Date expiresAt = JWT.decode(mady).getExpiresAt();
        claims.forEach((k,v)->{
            System.out.println(k);
            System.out.println(v.asString());
        });
        System.out.println(expiresAt);
        System.out.println(claims);

    }
}
