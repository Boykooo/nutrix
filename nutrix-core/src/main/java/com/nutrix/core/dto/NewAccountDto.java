package com.nutrix.core.dto;

import com.nutrix.common.dto.Gender;
import com.nutrix.common.dto.WeightGoal;
import lombok.Getter;

@Getter
public class NewAccountDto {
    private long id;
    private String name;
    private WeightGoal goal;
    private Gender gender;
    private String birthday;
    private int height;
    private int weight;
    private int targetWeight;
}
