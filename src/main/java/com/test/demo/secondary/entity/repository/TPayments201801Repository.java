package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201801;

public interface TPayments201801Repository extends JpaRepository<TPayments201801, Long>,JpaSpecificationExecutor<TPayments201801>{
    
    long countByorgGuid(String orgGuid);
}
