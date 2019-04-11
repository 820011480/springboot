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
package com.example.day04.service.impl;

import com.example.day04.dao.UserDao;
import com.example.day04.domain.User;
import com.example.day04.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 20:44
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User getQuery(Integer id) {
        return userDao.findOne(id);
    }

    @Override
    public void addUser(User user) {
//        userDao.save(user);
        userDao.addUser(user.getId() ,user.getUsername() ,user.getPassword(),user.getAge());

    }

    @Override
    public void delUser(Integer id) {
        userDao.delete(id);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        //第一种更新方法:(save更新)
//        userDao.save(user);
        //第二种原生sql 更新
        userDao.updateOne(user.getPassword(), user.getUsername(), user.getId());
    }
}
