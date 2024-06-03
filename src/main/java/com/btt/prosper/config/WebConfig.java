//package com.btt.prosper.config;
//
//import com.btt.prosper.interceptor.JwtTokenUserInterceptor;
//import com.btt.prosper.interceptor.LoginCheckInteceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    private  LoginCheckInteceptor loginCheckInteceptor;
//    @Autowired
//    private  JwtTokenUserInterceptor jwtTokenUserInterceptor;
//
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
////        registry.addInterceptor(loginCheckInteceptor).addPathPatterns("/user/**");
//        registry.addInterceptor(jwtTokenUserInterceptor).addPathPatterns("/user/**");
//    }
//}
