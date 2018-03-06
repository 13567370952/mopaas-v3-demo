package com.test.demo.primary.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.primary.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>,JpaSpecificationExecutor<Organization>{
    Organization findByGuid(String guid);
}
