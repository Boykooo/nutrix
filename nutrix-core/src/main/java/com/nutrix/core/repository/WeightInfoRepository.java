package com.nutrix.core.repository;

import com.nutrix.core.entity.WeightInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeightInfoRepository extends JpaRepository<WeightInfo, Long> {
}
