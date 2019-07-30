package com.happy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyConfig {
    @Bean
    public WebMvcConfigurer mvcConfigurer(){
        WebMvcConfigurer webMvcConfigurer=new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
                registry.addViewController("/index.html").setViewName("index");
                registry.addViewController("/catalog").setViewName("/admin/catalog_list");
                registry.addViewController("/detail.html").setViewName("/detail.html");
            }
        };
        return webMvcConfigurer;
    }

}
