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
package com.example.day06.dao;

import com.example.day06.domain.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 16:02
 */
@Repository
public interface TokenDao extends JpaRepository<Token, Integer> {

    Token findByUserId(Integer id);

    @Query(value ="insert into t_token values(?1,?2,?3,?4)", nativeQuery = true)
    void save(Integer tokenId, Integer userid, String token, Integer createTime);

}
