package com.hnun.erp;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;







@SpringBootApplication
@ServletComponentScan
@MapperScan(basePackages = {"com.hnun.erp.mapper"})
@ImportResource(locations= {"classpath:applicationContext_mail.xml"})
public class ErpApplication {
 public static void main(String[] args) {
	SpringApplication.run(ErpApplication.class, args);
	
	
	
}
 
}
