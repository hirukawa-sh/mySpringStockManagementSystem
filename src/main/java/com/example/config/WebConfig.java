package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

import com.example.interceptor.LoginInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loginInterceptor)

                // 全URL対象
                .addPathPatterns("/**")

                // ログイン画面だけ除外
                .excludePathPatterns("/")

                // ログイン処理も除外
                .excludePathPatterns("/login")

                // CSS
                .excludePathPatterns("/css/**")

                // JavaScript
                .excludePathPatterns("/js/**")

                // 画像
                .excludePathPatterns("/images/**");
    }
}