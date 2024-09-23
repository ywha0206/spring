package com.ch10.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {

    private final long MAX_AGE_SECS = 3600;

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        //RESTfull 서비스를 위한 CORS 설정
        registry.addMapping("/**")      //모든 엔드 포인트에 대한 접근 허용
                .allowedOrigins("http://127.0.0.1:5500", "http://localhost:5500")    //해당 도메인 origin의 요청 허용
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")//허용할 method 설정
                .allowedHeaders("*")    //모든 헤더 정보 허용
                .allowCredentials(true) //모든 자격증명 허용
                .maxAge(MAX_AGE_SECS);          //pre-flight 요청의 유효시간 설정

        WebMvcConfigurer.super.addCorsMappings(registry);
    }


}
