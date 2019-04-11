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
package com.example.day06.domain;

import lombok.*;

import javax.persistence.*;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 15:54
 */
@Entity
@Table(name="t_token")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Token {

    @Id
    @GeneratedValue
    @Column(name ="tokenid")
    private Integer tokenId;

    @Column(name ="userid")
    private Integer userid;

    @Column(name ="token")
    private String token;

    @Column(name ="create_date")
    private Integer createTime;

}
