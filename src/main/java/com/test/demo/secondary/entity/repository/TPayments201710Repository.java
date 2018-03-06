package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201710;

public interface TPayments201710Repository extends JpaRepository<TPayments201710, Long>,JpaSpecificationExecutor<TPayments201710>{
    
    long countByorgGuid(String orgGuid);
}
