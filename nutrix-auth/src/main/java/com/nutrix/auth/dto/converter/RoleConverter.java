package com.nutrix.auth.dto.converter;

import com.nutrix.auth.entity.Role;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public final class RoleConverter {

    public static List<String> extractRoleNames(Collection<Role> roles) {
        return CollectionUtils.isEmpty(roles) ? Collections.EMPTY_LIST
                : roles.stream().map(Role::getName).collect(Collectors.toList());
    }

}
