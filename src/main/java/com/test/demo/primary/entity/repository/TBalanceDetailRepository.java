package com.test.demo.primary.entity.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.test.demo.primary.entity.TBalanceDetail;

public interface TBalanceDetailRepository extends JpaRepository<TBalanceDetail, Long>,JpaSpecificationExecutor<TBalanceDetail>{
    
    List<TBalanceDetail> findDistinctuserAdminBybalanceStatus(Long balanceStatus);
    
    List<TBalanceDetail> findBybalanceStatus(Long balanceStatus);
    
    List<TBalanceDetail> findBybalanceStatus(Long balanceStatus, Pageable pageable);
   
    List<TBalanceDetail> findByorgGuid(String orgGuid,Sort sort);
    
    long countBybalanceStatus(Long balanceStatus);
}
