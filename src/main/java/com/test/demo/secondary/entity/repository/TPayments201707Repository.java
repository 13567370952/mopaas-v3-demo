package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201707;

public interface TPayments201707Repository extends JpaRepository<TPayments201707, Long>,JpaSpecificationExecutor<TPayments201707>{
    
    long countByorgGuid(String orgGuid);
}
