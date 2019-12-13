package com.nutrix.auth.security;

import com.nutrix.common.security.AccountInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class CurrentUser extends AccountInfo {

    public void build(AccountInfo accountInfo) {
        this.id = accountInfo.getId();
        this.email = accountInfo.getEmail();
        this.name = accountInfo.getName();
        this.roles = accountInfo.getRoles();
    }

}
