package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201712;

public interface TPayments201712Repository extends JpaRepository<TPayments201712, Long>,JpaSpecificationExecutor<TPayments201712>{
    
    long countByorgGuid(String orgGuid);
}
