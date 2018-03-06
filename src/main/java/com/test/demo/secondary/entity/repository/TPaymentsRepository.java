package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TPayments;

public interface TPaymentsRepository extends JpaRepository<TPayments, Long>,JpaSpecificationExecutor<TPayments>{
    
    long countByorgGuid(String orgGuid);
}
