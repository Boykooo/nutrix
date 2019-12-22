package com.nutrix.auth.dto;

import com.nutrix.common.dto.Sex;
import com.nutrix.common.dto.WeightGoal;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class RegisterAccountInfoDto {
    @NotEmpty(message = "Name must be not empty.")
    private String name;
    @NotNull
    private WeightGoal weightGoal;
    @NotNull
    private Sex sex;
    @Min(0)
    private Integer age;
    @Min(0)
    private Integer height;
    @Min(0)
    private Integer startWeight;
    @Min(0)
    private Integer targetWeight;

    public RegisterAccountInfoDto(RegisterAccountInfoDto accountInfo) {
        this.name = accountInfo.getName();
        this.weightGoal = accountInfo.getWeightGoal();
        this.sex = accountInfo.getSex();
        this.age = accountInfo.getAge();
        this.height = accountInfo.getHeight();
        this.startWeight = accountInfo.getStartWeight();
        this.targetWeight = accountInfo.getTargetWeight();
    }

}
