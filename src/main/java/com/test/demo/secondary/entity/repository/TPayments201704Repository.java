package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201704;

public interface TPayments201704Repository extends JpaRepository<TPayments201704, Long>,JpaSpecificationExecutor<TPayments201704>{
    
    long countByorgGuid(String orgGuid);
}
