package com.nutrix.auth.config;

import com.nutrix.auth.security.InternalRestTemplateJwtInterceptor;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
public class WebConfig {

    @Configuration
    public class CorsConfig implements WebMvcConfigurer {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowCredentials(true)
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                    .allowedOrigins("*");
        }
    }

    /**
     * Rest template for communication with internal Nutrix Services
     */
    @Bean
    @LoadBalanced
    @InternalRestTemplate
    public RestTemplate internalRestTemplate() {
        RestTemplate rt = new RestTemplate();
        var interceptors = rt.getInterceptors();
        if (CollectionUtils.isEmpty(interceptors)) {
            interceptors = new ArrayList<>();
        }
        interceptors.add(new InternalRestTemplateJwtInterceptor());
        rt.setInterceptors(interceptors);
        return rt;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
