package com.nutrix.auth.config;

import com.nutrix.auth.security.JwtSecurityFilter;
import com.nutrix.auth.security.SecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;

@Configuration
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @RequiredArgsConstructor
    public class CoreSecurity extends WebSecurityConfigurerAdapter {

        private final SecurityService securityService;

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/api/auth/**").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .addFilterAfter(new JwtSecurityFilter(securityService), SecurityContextPersistenceFilter.class)
                    .csrf().disable()
                    .cors();
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
        }
    }

}
