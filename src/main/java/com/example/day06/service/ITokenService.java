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
package com.example.day06.service;

import com.example.day06.domain.Token;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 18:12
 */
public interface ITokenService {
    /**
     * 查询token
     * @param id
     * @return
     */
    Token findByUserId(Integer id);

    /**
     * 添加token
     * @param token
     */
    void addToken(Token token);
}
