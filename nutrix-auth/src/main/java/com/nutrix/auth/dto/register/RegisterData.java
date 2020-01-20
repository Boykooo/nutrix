package com.nutrix.auth.dto.register;

import lombok.Getter;

/**
 * Object for Username and Password registration
 */
@Getter
public class RegisterData extends Credentials {
    private AccountPhysicalDataDto physicalData;
}
