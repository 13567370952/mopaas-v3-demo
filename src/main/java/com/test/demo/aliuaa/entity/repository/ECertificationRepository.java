package com.test.demo.aliuaa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.aliuaa.entity.ECertification;
import com.test.demo.aliuaa.entity.UaaUser;

public interface ECertificationRepository extends JpaRepository<ECertification, String>,JpaSpecificationExecutor<ECertification>{
    ECertification findByUser(UaaUser user);
}
