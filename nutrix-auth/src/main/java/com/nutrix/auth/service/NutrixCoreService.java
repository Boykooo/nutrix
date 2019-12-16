package com.nutrix.auth.service;

import com.nutrix.auth.config.InternalRestTemplate;
import com.nutrix.auth.dto.AccountShortDto;
import com.nutrix.common.system.NutrixServiceName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class NutrixCoreService {

    @Autowired
    @InternalRestTemplate
    private RestTemplate restTemplate;

    public void createAccount(AccountShortDto account) {
        URI uri = URI.create(NutrixServiceName.NUTRIX_CORE + "/api/account");
        restTemplate.postForEntity(uri, account, Void.class);
    }

}
