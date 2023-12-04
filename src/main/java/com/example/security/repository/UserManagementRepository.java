package com.example.security.repository;

import com.example.security.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserManagementRepository extends JpaRepository<UserAccount,Long> {


}
