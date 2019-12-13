package com.nutrix.auth.repository;

import com.nutrix.auth.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByEmail(String email);

    @Modifying
    @Query("update Account acc " +
            "set acc.name = :newName " +
            "where acc.id = :id")
    void updateName(Long id, String newName);

}
