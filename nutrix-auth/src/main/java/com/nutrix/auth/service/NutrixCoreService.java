package com.nutrix.auth.service;

import com.nutrix.auth.config.InternalRestTemplate;
import com.nutrix.auth.dto.AccountWithPhysicalDataDto;
import com.nutrix.common.system.NutrixServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * Service for communication with CORE module
 */
@Service
public class NutrixCoreService {

    @Autowired
    @InternalRestTemplate
    private RestTemplate restTemplate;

    public void createAccount(AccountWithPhysicalDataDto account) {
        URI uri = URI.create(NutrixServiceName.NUTRIX_CORE + "/api/account");
        restTemplate.postForEntity(uri, account, Void.class);
    }

}
