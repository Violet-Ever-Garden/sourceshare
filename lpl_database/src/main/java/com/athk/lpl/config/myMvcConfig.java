package com.athk.lpl.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class myMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/lplmenber").setViewName("list");

    }

    public WebMvcConfigurer webMvcConfigurer(){
        WebMvcConfigurer configurer = new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/player").setViewName("player");
                registry.addViewController("/team").setViewName("team");
                registry.addViewController("/coach").setViewName("coach");
                registry.addViewController("/match").setViewName("match");
                registry.addViewController("clubchange").setViewName("clubchange");
            }


        };
        return  configurer;
    }

   // @Bean
   // public LocaleResolver localeResolver(){
    //    return  new MyLocaleResolver
    //}
}
