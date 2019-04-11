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
package com.example.day03.dao;

import com.example.day03.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/10 20:46
 */
@Repository  //JPAdao层注解
public interface UserDao extends JpaRepository<User,Integer> {
    @Query(value = "update t_user set password = ?1 ,username = ?2 where id = ?3" , nativeQuery = true)
    @Modifying
    void updateOne(String password, String username, Integer id);

    @Query(value = "insert into t_user values (?1,?2,?3,?4) " , nativeQuery = true)
    @Modifying
    @Transactional
    void addUser(Integer id, String username, String password, Integer age);
}
