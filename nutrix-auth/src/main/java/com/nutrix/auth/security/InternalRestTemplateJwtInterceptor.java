package com.nutrix.auth.security;

import com.nutrix.common.exception.InternalServerException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.security.core.context.SecurityContextHolder;

import java.io.IOException;

@Slf4j
public class InternalRestTemplateJwtInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest req, byte[] bytes, ClientHttpRequestExecution clientHttpRequestExecution) throws IOException {
        try {
            var authentication = SecurityContextHolder.getContext().getAuthentication();
            if (authentication != null && authentication.isAuthenticated() && authentication.getCredentials() != null) {
                //jwt token
                String token = (String) authentication.getCredentials();
                HttpHeaders headers = req.getHeaders();
                headers.set(JwtSecurityFilter.TOKEN_HEADER, token);
            }
            return clientHttpRequestExecution.execute(req, bytes);
        } catch (Exception e) {
            log.error("Internal request FAILED! URI = {}, Error message = {}", req.getURI().toString(), e.getMessage());
            throw new InternalServerException();
        }
    }

}
