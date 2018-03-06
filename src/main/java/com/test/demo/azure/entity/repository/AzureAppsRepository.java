package com.test.demo.azure.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.azure.entity.AzureApp;

public interface AzureAppsRepository extends JpaRepository<AzureApp, Long>,JpaSpecificationExecutor<AzureApp>{

}
