package com.test.demo.primary.entity.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.primary.entity.Balance;

public interface BalanceRepository extends JpaRepository<Balance, Long>,JpaSpecificationExecutor<Balance>{
    List<Balance> findByorgGuid(String orgGuid);
}
