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
package com.example.day05.service;

import com.example.day05.domain.User;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 20:39
 */
public interface IUserService {

    User getQuery(Integer id);

    void addUser(User user);

    void delUser(Integer id);

    void updateUser(User user);
}
