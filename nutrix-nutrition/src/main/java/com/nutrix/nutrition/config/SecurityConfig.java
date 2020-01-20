package com.nutrix.nutrition.config;

import com.nutrix.nutrition.security.JwtSecurityFilter;
import com.nutrix.nutrition.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
public class SecurityConfig {

    @Configuration
    @RequiredArgsConstructor
    public class CoreSecurity extends WebSecurityConfigurerAdapter {

        private final SecurityService securityService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .addFilterAfter(jwtSecurityFilter(), SecurityContextPersistenceFilter.class)
                    .csrf().disable()
                    .cors();
        }

        private JwtSecurityFilter jwtSecurityFilter() {
            return new JwtSecurityFilter(securityService);
        }

    }

}
