package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201711;

public interface TPayments201711Repository extends JpaRepository<TPayments201711, Long>,JpaSpecificationExecutor<TPayments201711>{
    
    long countByorgGuid(String orgGuid);
}
