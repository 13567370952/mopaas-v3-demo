package com.test.demo.aliuaa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.aliuaa.entity.PCertification;
import com.test.demo.aliuaa.entity.UaaUser;

public interface PCertificationRepository extends JpaRepository<PCertification, String>,JpaSpecificationExecutor<PCertification>{
    PCertification findByUser(UaaUser user);
}
