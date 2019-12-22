package com.nutrix.core.repository;

import com.nutrix.core.entity.WeightHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightHistoryRepository extends JpaRepository<WeightHistory, Long> {
}
