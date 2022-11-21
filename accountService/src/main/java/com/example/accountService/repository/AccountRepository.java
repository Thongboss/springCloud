package com.example.accountService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.accountService.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

}
