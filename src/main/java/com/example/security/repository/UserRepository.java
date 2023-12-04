package com.example.security.repository;

import com.example.security.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserAccount, Long> {

    UserAccount findByUsername(String userName);
}
