package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TUserPay;

public interface TUserPayRepository extends JpaRepository<TUserPay, Long>,JpaSpecificationExecutor<TUserPay>{
    
    long countByName(String name);
    
    TUserPay findByName(String name);
    
}
