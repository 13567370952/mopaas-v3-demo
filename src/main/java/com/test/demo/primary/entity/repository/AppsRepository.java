package com.test.demo.primary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.primary.entity.App;

public interface AppsRepository extends JpaRepository<App, Long>,JpaSpecificationExecutor<App>{

}
