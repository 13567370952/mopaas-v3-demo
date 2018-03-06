package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201611;

public interface TPayments201611Repository extends JpaRepository<TPayments201611, Long>,JpaSpecificationExecutor<TPayments201611>{
    
    long countByorgGuid(String orgGuid);
}
