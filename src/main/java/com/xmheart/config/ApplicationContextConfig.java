package com.xmheart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;
 
@Configuration
 
@ComponentScan("com.xmheart.*")
 
public class ApplicationContextConfig {
 
    @Bean(name = "viewResolver")
    static public ViewResolver getViewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();
        System.out.println("Create Bean viewResolver");
 
        viewResolver.setContentType("text/html");
        viewResolver.setCache(true);
        viewResolver.setPrefix("");
        viewResolver.setSuffix(".ftl");
        return viewResolver;
    }
 
    @Bean(name = "freemarkerConfig")
    static public FreeMarkerConfigurer getFreemarkerConfig() {
        FreeMarkerConfigurer config = new FreeMarkerConfigurer();
 
        // Folder containing FreeMarker templates.
        config.setTemplateLoaderPath("/WEB-INF/views/");
        
        config.setDefaultEncoding("UTF-8");
        System.out.println("getFreemarkerConfig");
        return config;
    }
 
}
