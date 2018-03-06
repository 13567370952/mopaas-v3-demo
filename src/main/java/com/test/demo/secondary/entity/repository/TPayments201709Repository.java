package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments201709;

public interface TPayments201709Repository extends JpaRepository<TPayments201709, Long>,JpaSpecificationExecutor<TPayments201709>{
    
    long countByorgGuid(String orgGuid);
}
