/**
 * Project: demo
 * <p>
 * File Created at 2019/4/10
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
package com.example.day03.service.impl;

import com.example.day03.domain.User;
import com.example.day03.service.IUserService;
import org.springframework.stereotype.Service;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 20:44
 */
@Service
public class UserServiceImpl implements IUserService {



    @Override
    public User getQuery(Integer id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void delUser(Integer id) {

    }

    @Override
    public void updateUser(User user) {

    }
}
