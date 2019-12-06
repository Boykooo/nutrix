package com.nutrix.auth.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

    @Id
    @Column(name = "account_id")
    private Long accountId;

    @OneToOne
    @PrimaryKeyJoinColumn
    private Account account;

    @Column(name = "token")
    private String token;

    public RefreshToken(Long accountId, String token) {
        this.accountId = accountId;
        this.account = new Account(accountId);
        this.token = token;
    }

}
