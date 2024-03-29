package com.nutrix.core.service;

import com.nutrix.core.entity.Account;
import com.nutrix.core.entity.WeightHistory;
import com.nutrix.core.repository.WeightHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class WeightHistoryService {

    private final WeightHistoryRepository weightHistoryRepository;

    public void save(Long accountId, int weight) {
        var weightHistory = new WeightHistory();
        weightHistory.setAccount(Account.of(accountId));
        weightHistory.setDate(Instant.now());
        weightHistory.setWeight(weight);
        weightHistoryRepository.save(weightHistory);
    }
}
