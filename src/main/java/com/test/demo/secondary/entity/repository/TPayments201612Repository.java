package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201612;

public interface TPayments201612Repository extends JpaRepository<TPayments201612, Long>,JpaSpecificationExecutor<TPayments201612>{
    
    long countByorgGuid(String orgGuid);
}
