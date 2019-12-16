package com.nutrix.auth.security;

import com.nutrix.common.security.AccountInfo;
import com.nutrix.common.security.JwtParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityService {

    private static final String ROLE_PREFIX = "ROLE_";
    private final CurrentUser currentUser;

    @Value("${token.key}")
    public String key;

    public void process(String token) {
        if (StringUtils.isEmpty(token)) {
            return;
        }
        try {
            AccountInfo userInfo = JwtParser.parse(token, key, true, AccountInfo.class);
            List<SimpleGrantedAuthority> roles = userInfo.getRoles()
                    .stream()
                    .map(role -> new SimpleGrantedAuthority(ROLE_PREFIX + role))
                    .collect(Collectors.toList());
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(userInfo, token, roles));
            currentUser.build(userInfo);
        } catch (Exception ex) {
            log.error("Authentication has been failed. Couldn't parse token");
        }
    }

}
