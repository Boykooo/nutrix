package com.nutrix.core.entity;

import com.nutrix.common.dto.Gender;
import com.nutrix.common.dto.WeightGoal;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.time.Instant;

@Data
@Entity
@NoArgsConstructor
public class Account {

    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "goal")
    @Enumerated(EnumType.STRING)
    private WeightGoal weightGoal;

    @Column(name = "birthday")
    private Instant birthday;

    @Column(name = "height")
    private int height;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "photo_id")
    private Photo photo;

    private Account(Long id) {
        this.id = id;
    }

    public static Account of(Long id) {
        return new Account(id);
    }

}



