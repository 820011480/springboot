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
package com.example.day06.service.impl;

import com.example.day06.dao.TokenDao;
import com.example.day06.domain.Token;
import com.example.day06.service.ITokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 18:13
 */
@Service
public class TokeServiceImpl implements ITokenService {
    @Autowired
    private TokenDao tokenDao;
    @Override
    public Token findByUserId(Integer id) {
        return tokenDao.findByuserid(id);
    }

    @Override
    public void addToken(Token token) {
        tokenDao.save(token.getTokenId(),token.getUserid(),token.getToken(),token.getCreateTime());
    }
}
