package com.nutrix.auth.dto.register;

import com.nutrix.common.dto.Gender;
import com.nutrix.common.dto.WeightGoal;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@NoArgsConstructor
public class AccountPhysicalDataDto {
    private String name;
    @NotNull
    private WeightGoal goal;
    @NotNull
    private Gender gender;
    @Min(0)
    private String birthday;
    @Min(100)
    private Integer height;
    @Min(30)
    private Integer weight;
    @Min(30)
    @Max(300)
    private Integer targetWeight;

    public AccountPhysicalDataDto(AccountPhysicalDataDto accountInfo) {
        this.name = accountInfo.getName();
        this.goal = accountInfo.getGoal();
        this.gender = accountInfo.getGender();
        this.birthday = accountInfo.getBirthday();
        this.height = accountInfo.getHeight();
        this.weight = accountInfo.getWeight();
        this.targetWeight = accountInfo.getTargetWeight();
    }

}
