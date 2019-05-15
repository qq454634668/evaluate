package com.product.evaluate.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

@SpringBootConfiguration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private UserInterceptor userInterceptor;


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/tz").setViewName("tz");
        registry.addViewController("/zsgl").setViewName("zsgl");
        registry.addViewController("/rcgl").setViewName("rcgl");
    }

    public void addInterceptors(InterceptorRegistry registry){
        //拦截器，使用时去掉注释
//        registry.addInterceptor()
//        registry.addInterceptor(userInterceptor).addPathPatterns("/**");
    }
}