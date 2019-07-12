package com.sweet.intercept;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginInterceptConfiguration implements WebMvcConfigurer{

	@Override
    public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginIntercept())
                .addPathPatterns("/**/**").excludePathPatterns("/SysUserInfo/findUser","/cmd/start","/cmd/stop").order(2);
    }
	

}
