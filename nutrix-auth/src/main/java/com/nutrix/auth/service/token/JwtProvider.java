package com.nutrix.auth.service.token;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutrix.auth.dto.token.TokenWrapper;
import com.nutrix.common.utils.DateUtils;
import com.nutrix.common.security.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;

@Service
public class JwtProvider {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Value("${token.access-expiration-days}")
    private int accessExpirationDays;

    @Value("${token.refresh-expiration-days}")
    private int refreshExpirationDays;

    @Value("${token.key}")
    private String secretKey;

    public TokenWrapper generateAccess(Object payload) {
        return generate(payload, accessExpirationDays);
    }

    public TokenWrapper generateRefresh(Object payload) {
        return generate(payload, refreshExpirationDays);
    }

    @SneakyThrows
    private TokenWrapper generate(Object payload, int expirationDays) {
        Date expired = DateUtils.addDays(new Date(), expirationDays);
        String jwt = Jwts.builder()
                .setExpiration(saltDate(expired))
                .claim(JwtParser.PAYLOAD_HEADER, payload)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return new TokenWrapper(jwt, DateUtils.toReadableDate(expired));
    }

    private Date saltDate(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.SECOND, 1 + new Random().nextInt(120));
        return calendar.getTime();
    }

}
