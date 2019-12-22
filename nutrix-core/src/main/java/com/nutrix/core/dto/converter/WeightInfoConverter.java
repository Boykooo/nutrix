package com.nutrix.core.dto.converter;

import com.nutrix.core.dto.NewAccountDto;
import com.nutrix.core.entity.WeightInfo;

public final class WeightInfoConverter {

    public static WeightInfo convert(NewAccountDto newAccountDto) {
        var weightInfo = new WeightInfo();
        weightInfo.setStartWeight(newAccountDto.getStartWeight());
        weightInfo.setCurrentWeight(newAccountDto.getCurrentWeight());
        weightInfo.setTargetWeight(newAccountDto.getTargetWeight());
        return weightInfo;
    }

}
