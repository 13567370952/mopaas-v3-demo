package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201705;

public interface TPayments201705Repository extends JpaRepository<TPayments201705, Long>,JpaSpecificationExecutor<TPayments201705>{
    
    long countByorgGuid(String orgGuid);
}
