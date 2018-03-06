package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201708;

public interface TPayments201708Repository extends JpaRepository<TPayments201708, Long>,JpaSpecificationExecutor<TPayments201708>{
    
    long countByorgGuid(String orgGuid);
}
