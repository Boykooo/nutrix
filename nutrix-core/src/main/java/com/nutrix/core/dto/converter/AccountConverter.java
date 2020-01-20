package com.nutrix.core.dto.converter;

import com.nutrix.common.utils.DateUtils;
import com.nutrix.core.dto.NewAccountDto;
import com.nutrix.core.entity.Account;

public final class AccountConverter {

    public static Account convert(NewAccountDto newAccount) {
        var account = new Account();
        account.setId(newAccount.getId());
        account.setName(newAccount.getName());
        account.setBirthday(DateUtils.parse(newAccount.getBirthday()));
        account.setHeight(newAccount.getHeight());
        account.setGender(newAccount.getGender());
        account.setWeightGoal(newAccount.getGoal());
        return account;
    }

}
