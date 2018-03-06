package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201706;

public interface TPayments201706Repository extends JpaRepository<TPayments201706, Long>,JpaSpecificationExecutor<TPayments201706>{
    
    long countByorgGuid(String orgGuid);
}
