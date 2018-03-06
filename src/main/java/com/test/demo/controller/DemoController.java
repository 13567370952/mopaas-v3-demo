package com.test.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.primary.entity.TBalanceDetail;
import com.test.demo.primary.entity.repository.TBalanceDetailRepository;
import com.test.demo.secondary.entity.TUserPay;
import com.test.demo.secondary.entity.repository.TPayments201610Repository;
import com.test.demo.secondary.entity.repository.TPayments201611Repository;
import com.test.demo.secondary.entity.repository.TPayments201612Repository;
import com.test.demo.secondary.entity.repository.TPayments201701Repository;
import com.test.demo.secondary.entity.repository.TPayments201702Repository;
import com.test.demo.secondary.entity.repository.TPayments201703Repository;
import com.test.demo.secondary.entity.repository.TPayments201704Repository;
import com.test.demo.secondary.entity.repository.TPayments201705Repository;
import com.test.demo.secondary.entity.repository.TPayments201706Repository;
import com.test.demo.secondary.entity.repository.TPayments201707Repository;
import com.test.demo.secondary.entity.repository.TPayments201708Repository;
import com.test.demo.secondary.entity.repository.TPayments201709Repository;
import com.test.demo.secondary.entity.repository.TPayments201710Repository;
import com.test.demo.secondary.entity.repository.TPayments201711Repository;
import com.test.demo.secondary.entity.repository.TPayments201712Repository;
import com.test.demo.secondary.entity.repository.TPayments201801Repository;
import com.test.demo.secondary.entity.repository.TPaymentsRepository;
import com.test.demo.secondary.entity.repository.TUserPayRepository;

@RestController
public class DemoController {

    @Autowired
    private TBalanceDetailRepository tBalanceDetailRepository;
    
    @Autowired
    private TUserPayRepository tUserPayRepository;
    
    @Autowired
    private TPaymentsRepository tPaymentsRepository;
    
    @Autowired
    private TPayments201610Repository tPayments201610Repository;
    
    @Autowired
    private TPayments201611Repository tPayments201611Repository;
    
    @Autowired
    private TPayments201612Repository tPayments201612Repository;
    
    @Autowired
    private TPayments201701Repository tPayments201701Repository;
    
    @Autowired
    private TPayments201702Repository tPayments201702Repository;
    
    @Autowired
    private TPayments201703Repository tPayments201703Repository;
    
    @Autowired
    private TPayments201704Repository tPayments201704Repository;
    
    @Autowired
    private TPayments201705Repository tPayments201705Repository;
    
    
    @Autowired
    private TPayments201706Repository tPayments201706Repository;
    
    @Autowired
    private TPayments201707Repository tPayments201707Repository;
    
    @Autowired
    private TPayments201708Repository tPayments201708Repository;
    
    @Autowired
    private TPayments201709Repository tPayments201709Repository;
    
    @Autowired
    private TPayments201710Repository tPayments201710Repository;
    
    @Autowired
    private TPayments201711Repository tPayments201711Repository;
    
    @Autowired
    private TPayments201712Repository tPayments201712Repository;
    
    @Autowired
    private TPayments201801Repository tPayments201801Repository;
    
    
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public void insert(HttpServletRequest request) {
        long start = System.currentTimeMillis();
        System.out.println("****************************************************start************************************");
        List<TBalanceDetail> list = tBalanceDetailRepository.findBybalanceStatus(1L);
        if (list!=null && list.size()>0) {
            long count =0;
            long total=0;
            for (TBalanceDetail tBalanceDetail : list) {
                 count =0;
                 total++;
                if (tBalanceDetail.getUserAdmin()!=null&&tBalanceDetail.getUserAdmin()!="") {
                        System.out.println("##################user="+tBalanceDetail.getUserAdmin()+"##################orgGuid="+tBalanceDetail.getOrgGuid()+",###############total="+total);
                        long nameCount = tUserPayRepository.countByName(tBalanceDetail.getOrgGuid());
                        if (nameCount>0) {
                            continue;
                        }
                        TUserPay tUserPay = new TUserPay();
                        tUserPay.setName(tBalanceDetail.getUserAdmin());
                        tUserPay.setStatus(0);
                        
                        count = tPaymentsRepository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201610Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201611Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        
                        count = tPayments201612Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        
                        count = tPayments201701Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        
                        count = tPayments201702Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201703Repository.countByorgGuid(tBalanceDetail.getUserAdmin());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201704Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        
                        count = tPayments201705Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        
                        count = tPayments201706Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201707Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201708Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201709Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201710Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201711Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201712Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        count = tPayments201801Repository.countByorgGuid(tBalanceDetail.getOrgGuid());
                        if (count>0) {
                            tUserPay.setStatus(1);
                            tUserPayRepository.save(tUserPay);
                            continue;
                        }
                        
                        tUserPayRepository.save(tUserPay);
                }
            }
        }
        System.out.println("****************************************************end************************************time="+(System.currentTimeMillis()-start));
    }
    

}