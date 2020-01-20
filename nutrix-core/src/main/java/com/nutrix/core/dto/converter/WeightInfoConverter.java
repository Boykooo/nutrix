package com.nutrix.core.dto.converter;

import com.nutrix.core.dto.NewAccountDto;
import com.nutrix.core.entity.WeightInfo;

public final class WeightInfoConverter {

    public static WeightInfo convert(Long accountId, NewAccountDto newAccountDto) {
        var weightInfo = new WeightInfo();
        weightInfo.setAccountId(accountId);
        weightInfo.setStartWeight(newAccountDto.getWeight());
        weightInfo.setCurrentWeight(newAccountDto.getWeight());
        weightInfo.setTargetWeight(newAccountDto.getTargetWeight());
        return weightInfo;
    }

}
