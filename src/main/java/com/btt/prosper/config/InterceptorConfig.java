//package com.btt.prosper.config;
//
//import com.btt.prosper.interceptor.JwtTokenAdminInterceptor;
//import com.btt.prosper.interceptor.JwtTokenUserInterceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.DelegatingWebMvcConfiguration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//
//@Configuration
//public class InterceptorConfig extends DelegatingWebMvcConfiguration {
//
//    @Autowired
//    private JwtTokenAdminInterceptor jwtTokenAdminInterceptor;
//
//    @Autowired
//    private JwtTokenUserInterceptor jwtTokenUserInterceptor;
//
//    @Override
//    protected void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(jwtTokenAdminInterceptor)
//                .addPathPatterns("/admin/**")
//                .excludePathPatterns("/admin/login");
//
//        registry.addInterceptor(jwtTokenUserInterceptor)
//                .addPathPatterns("/user/**")
//                .addPathPatterns("/test/**")
//                .excludePathPatterns("/user/login");
//    }
//}
