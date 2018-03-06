package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201702;

public interface TPayments201702Repository extends JpaRepository<TPayments201702, Long>,JpaSpecificationExecutor<TPayments201702>{
    
    long countByorgGuid(String orgGuid);
}
