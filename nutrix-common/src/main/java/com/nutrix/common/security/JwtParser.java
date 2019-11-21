package com.nutrix.common.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nutrix.common.exception.TokenExpiredException;
import com.nutrix.common.utils.DateUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public final class JwtParser {

    private final static ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    public static final String PAYLOAD_HEADER = "PAYLOAD";

    public static <T> T parse(String token, String key, boolean checkExpiration, Class<T> requiredType) {
        Claims body = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token)
                .getBody();
        if (checkExpiration && DateUtils.expired(body.getExpiration())) {
            throw new TokenExpiredException();
        }
        return OBJECT_MAPPER.convertValue(body.get(PAYLOAD_HEADER), requiredType);
    }

}
