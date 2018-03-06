package com.test.demo.secondary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.secondary.entity.TAppInfo;

public interface AppInfoRepository extends JpaRepository<TAppInfo, Long>,JpaSpecificationExecutor<TAppInfo>{
}
