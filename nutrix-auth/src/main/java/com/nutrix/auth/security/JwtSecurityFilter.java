package com.nutrix.auth.security;

import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtSecurityFilter extends OncePerRequestFilter {

    private static final String TOKEN_HEADER = "at";

    private SecurityService securityService;

    public JwtSecurityFilter(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
        String token = request.getHeader(TOKEN_HEADER);
        securityService.process(token);
        chain.doFilter(request, response);
    }

}
