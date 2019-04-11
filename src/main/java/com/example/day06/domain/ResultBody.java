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

import lombok.Data;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/11 16:17
 */

@Data
public class ResultBody<T> {

    private  Integer code;

    private  String msg;

    private T data;

    private ResultBody(T data){
        this.code = 200;
        this.msg = "success";
        this.data = data;
    }

    private ResultBody(Integer code ,String  msg){
        this.code = code;
        this.msg = msg;
        this.data = null;
    }
    public static <T> ResultBody<T> ok(T data){
        return new ResultBody<T>(data);
    }


    public static <T> ResultBody<T> fail(Integer code ,String  msg){
        return new ResultBody<T>(code ,msg);
    }
}
