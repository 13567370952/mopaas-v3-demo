package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201701;

public interface TPayments201701Repository extends JpaRepository<TPayments201701, Long>,JpaSpecificationExecutor<TPayments201701>{
    
    long countByorgGuid(String orgGuid);
}
