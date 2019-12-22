package com.nutrix.core.dto.converter;

import com.nutrix.core.dto.NewAccountDto;
import com.nutrix.core.entity.Account;

public final class AccountConverter {

    public static Account convert(NewAccountDto newAccount) {
        var account = new Account();
        account.setAge(newAccount.getAge());
        account.setHeight(newAccount.getHeight());
        account.setName(newAccount.getName());
        account.setSex(newAccount.getSex());
        account.setWeightGoal(newAccount.getWeightGoal());
        return account;
    }

}
