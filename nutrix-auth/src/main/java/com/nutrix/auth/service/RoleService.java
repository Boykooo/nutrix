package com.nutrix.auth.service;

import com.nutrix.auth.entity.Role;
import com.nutrix.auth.repository.RoleRepository;
import com.nutrix.common.security.Roles;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Role getDefaultRole() {
        return roleRepository.findByName(Roles.ROLE_USER);
    }

}
