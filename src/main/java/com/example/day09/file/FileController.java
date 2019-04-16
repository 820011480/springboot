/**
 * Project: demo
 * <p>
 * File Created at 2019/4/15
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
package com.example.day09.file;

import com.example.day09.model.FileModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @author: mady
 * @version: 1.0
 * @date: 2019/4/15 20:17
 */
@Controller
@RequestMapping("/upload")
@Slf4j
public class FileController {
    @GetMapping("/file")
    public String getFile(){
        return "/FileUpload";
    }

    @GetMapping("/files")
    public String getFiles(){
        return "/FilesUpload";
    }

    /**
     *
     * 文件上传可对文件进行文件头，后缀名，mime-type判断
     */
    @PostMapping("/single/file")
    @ResponseBody
    public String fileUpload(FileModel file, HttpServletRequest request) throws IOException {
        System.out.println(file);
        if (file == null || file.getFile() == null){
            return "上传fail";
        }
        MultipartFile file1 = file.getFile();

        InputStream inputStream = file1.getInputStream();
        byte[] bytes = new byte[6];
        inputStream.read(bytes,0,bytes.length);
        System.out.println(bytesToHexString(bytes));

        Path path = Paths.get("");
        String name = file1.getName();
        System.out.println("文件名称为：" + name);
        String contentType = file1.getContentType();
        System.out.println("文件类型为：" + contentType);
        long size = file1.getSize();
        System.out.println("文件大小：" + size);
        String originalFilename = file1.getOriginalFilename();
        System.out.println("源文件名称：" + originalFilename);
        try {
            file.getFile().transferTo(new File("E:/hello/" + originalFilename));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     *
     * 文件上传可对文件进行文件头，后缀名，mime-type判断
     * 多文件上传的时候 默认限制大小为1M
     *MultipartConfig 必需配置在servlet
     * org.apache.catalina.connector.Request
     *
     *   if (this.multipartConfigElement == null) {
     *                     MultipartConfig annotation = (MultipartConfig)servlet.getClass().getAnnotation(MultipartConfig.class);
     *                     if (annotation != null) {
     *                         this.multipartConfigElement = new MultipartConfigElement(annotation);
     *                     }
     *     }
     * ClassPathResource (只能查找项目资源) 不指定的话从类路径下加载
     */
    @PostMapping("/more/file")
    @ResponseBody
    public String filesUpload(@RequestParam("file") List <MultipartFile> lists, HttpServletRequest request) throws IOException {
        System.out.println(lists);
        if (lists == null || lists.size() <= 0){
            return "上传fail";
        }
        /**
         * 可对文件名进行判断是否存在如果存在请用户输入是否覆盖
         */
        lists.forEach(file1->{
            Path path = Paths.get("");
            String name = file1.getName();
            System.out.println("文件名称为：" + name);
            String contentType = file1.getContentType();
            System.out.println("文件类型为：" + contentType);
            long size = file1.getSize();
            System.out.println("文件大小：" + size);
            String originalFilename = file1.getOriginalFilename();
            System.out.println("源文件名称：" + originalFilename);
            try {
                file1.transferTo(new File("E:/hello/" + originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        return "";
    }

    /**
     * 将文件头转换成16进制字符串
     * @param src
     * @return 16进制字符串
     */
    private static String bytesToHexString(byte[] src) {

        StringBuilder stringBuilder = new StringBuilder();
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    public static final String separator = File.separator;

    @GetMapping("/download")
    public ResponseEntity<InputStreamResource> downloadTemplte(){
        String path = null;
        ResponseEntity<InputStreamResource> response = null;
        try {
            path = "dw_vehicle_gps1_days30.sql";
            ClassPathResource classPathResource = new ClassPathResource(path);
            String path1 = classPathResource.getPath();

            System.out.println(path1);
            InputStream inputStream = classPathResource.getInputStream();
//            File file = new File(path);
//            FileInputStream inputStream = new FileInputStream(file);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition",
                    "attachment; filename=dw_vehicle_gps1_days30.sql");
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");
            response = ResponseEntity.ok().headers(headers)
                    .contentType(MediaType.parseMediaType("application/octet-stream"))
                    .body(new InputStreamResource(inputStream));
        } catch (FileNotFoundException e1) {
            log.error("找不到指定的文件", e1);
        } catch (IOException e) {
            log.error("获取不到文件流", e);
        }
        return response;
    }
}
