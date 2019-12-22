package com.nutrix.core.service;

import com.nutrix.core.dto.NewAccountDto;
import com.nutrix.core.dto.converter.WeightInfoConverter;
import com.nutrix.core.repository.WeightInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WeightInfoService {

    private final WeightInfoRepository weightInfoRepository;
    private final WeightHistoryService weightHistoryService;

    @Transactional
    public void create(Long accountId, NewAccountDto newAccountDto) {
        var weightInfo = WeightInfoConverter.convert(newAccountDto);
        weightInfo.setAccountId(accountId);
        weightInfoRepository.save(weightInfo);
        weightHistoryService.save(accountId, newAccountDto.getStartWeight());
    }

}
