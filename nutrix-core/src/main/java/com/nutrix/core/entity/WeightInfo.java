package com.nutrix.core.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Data
@Entity
public class WeightInfo {

    @Id
    @Column(name = "account_id")
    private Long accountId;

    @OneToOne(fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    private Account account;

    @Column(name = "start_weight")
    private int startWeight;

    @Column(name = "current_weight")
    private int currentWeight;

    @Column(name = "target_weight")
    private int targetWeight;

}
