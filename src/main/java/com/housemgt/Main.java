package com.housemgt;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.util.unit.DataSize;

import javax.servlet.MultipartConfigElement;

public class Main {
    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartConfigElement multipartConfigElement() {
        MultipartConfigFactory factory = new MultipartConfigFactory();
        //单个文件最大
        factory.setMaxFileSize(DataSize.parse("61440KB")); // 60mb
        /// 设置总上传数据总大小
        factory.setMaxRequestSize(DataSize.parse("102400KB"));  // 100 MB
        return factory.createMultipartConfig();
    }
}
