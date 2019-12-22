package com.nutrix.core.dto;

import com.nutrix.common.dto.Sex;
import com.nutrix.common.dto.WeightGoal;
import lombok.Getter;

@Getter
public class NewAccountDto {
    private long id;
    private String name;
    private WeightGoal weightGoal;
    private Sex sex;
    private int age;
    private int height;
    private int startWeight;
    private int targetWeight;
}
