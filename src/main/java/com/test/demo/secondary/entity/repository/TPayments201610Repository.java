package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201610;

public interface TPayments201610Repository extends JpaRepository<TPayments201610, Long>,JpaSpecificationExecutor<TPayments201610>{
    
    long countByorgGuid(String orgGuid);
}
