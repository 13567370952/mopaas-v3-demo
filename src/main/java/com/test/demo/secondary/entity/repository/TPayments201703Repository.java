package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201703;

public interface TPayments201703Repository extends JpaRepository<TPayments201703, Long>,JpaSpecificationExecutor<TPayments201703>{
    
    long countByorgGuid(String orgGuid);
}
