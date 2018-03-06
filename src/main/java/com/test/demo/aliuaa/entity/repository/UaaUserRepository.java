package com.test.demo.aliuaa.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.aliuaa.entity.UaaUser;

public interface UaaUserRepository extends JpaRepository<UaaUser, String>,JpaSpecificationExecutor<UaaUser>{

}
