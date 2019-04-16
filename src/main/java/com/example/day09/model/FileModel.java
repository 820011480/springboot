/**
 * Project: demo
 * <p>
 * File Created at 2019/4/16
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
package com.example.day09.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/16 10:08
 */
@Data
@NoArgsConstructor
public class FileModel {
    /**
     * 文件描述
     */
    private  String description;
    /**
     * 接收文件
     */
    private MultipartFile file;

}
