package com.nutrix.core.dto;

import com.nutrix.core.entity.Sex;
import com.nutrix.core.entity.WeightGoal;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class NewAccountDto {
    @NotNull
    private Long id;
    private String name;
    private WeightGoal weightGoal;
    private Sex sex;
    private Integer age;
    private Integer height;
    private Integer startWeight;
    private Integer currentWeight;
    private Integer targetWeight;
}
