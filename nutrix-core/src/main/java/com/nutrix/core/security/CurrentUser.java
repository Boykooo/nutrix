package com.nutrix.core.security;

import com.nutrix.common.security.AccountInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class CurrentUser extends AccountInfo {
}
