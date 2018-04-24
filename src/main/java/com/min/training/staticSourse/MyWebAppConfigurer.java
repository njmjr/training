package com.min.training.staticSourse;

import com.min.training.filter.LoginInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurationSupport {

    @Value ("${staticSourse.picFile}")
    private String staticFile;
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		registry.addResourceHandler("/myres/**").addResourceLocations(staticFile);
		super.addResourceHandlers(registry);

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/**").excludePathPatterns("/login")
				.excludePathPatterns("/respJson").excludePathPatterns("/myres/**");
	}
}
