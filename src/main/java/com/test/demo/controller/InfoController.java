package com.test.demo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.aliuaa.entity.ECertification;
import com.test.demo.aliuaa.entity.PCertification;
import com.test.demo.aliuaa.entity.UaaUser;
import com.test.demo.aliuaa.entity.repository.ECertificationRepository;
import com.test.demo.aliuaa.entity.repository.PCertificationRepository;
import com.test.demo.aliuaa.entity.repository.UaaUserRepository;
import com.test.demo.azure.entity.AzureApp;
import com.test.demo.azure.entity.repository.AzureAppsRepository;
import com.test.demo.primary.entity.App;
import com.test.demo.primary.entity.Balance;
import com.test.demo.primary.entity.Organization;
import com.test.demo.primary.entity.TBalanceDetail;
import com.test.demo.primary.entity.repository.AppsRepository;
import com.test.demo.primary.entity.repository.BalanceRepository;
import com.test.demo.primary.entity.repository.OrganizationRepository;
import com.test.demo.primary.entity.repository.TBalanceDetailRepository;
import com.test.demo.secondary.entity.TAppInfo;
import com.test.demo.secondary.entity.repository.AppInfoRepository;

@RestController
public class InfoController {
    @Autowired
    private AppsRepository appsRepository;
    @Autowired 
    private TBalanceDetailRepository tBalanceDetailRepository;
    @Autowired
    private BalanceRepository balanceRepository;
    
    @Autowired
    private UaaUserRepository uaaUserRepository;
    
    @Autowired
    private AppInfoRepository appInfoRepository;
    @Autowired
    private ECertificationRepository eCertificationRepository;
    @Autowired
    private PCertificationRepository pCertificationRepository;
    @Autowired
    private AzureAppsRepository azureAppsRepository;
    @Autowired
    private OrganizationRepository organizationRepository;
    
    @RequestMapping(value = "/aliyun", method = RequestMethod.GET)
    public void aliyun(HttpServletRequest request,HttpServletResponse response) {
        long start = System.currentTimeMillis();
        System.out.println("###################################start######################################");
        List<App> list = appsRepository.findAll();
        if (null!= list && list.size()>0) {
            for (App app : list) {
                TAppInfo tAppInfo =new TAppInfo();
                tAppInfo.setName(app.getName());
                tAppInfo.setPlat("阿里云");
                if (app.getState().equals("STARTED")) {
                    tAppInfo.setState("运行");
                }else if (app.getState().equals("STOPPED")) {
                    tAppInfo.setState("停止");
                }else {
                    tAppInfo.setState("异常");
                }
                tAppInfo.setUsed(app.getUpdatedAt());
               
                tAppInfo.setEmail("--");//邮箱
                tAppInfo.setPhone("--");//手机
                tAppInfo.setOrigin("--");//来源
                tAppInfo.setCretification("未认证");//认证
                tAppInfo.setCretstate("--");//认证状态
                
                tAppInfo.setInfo("--");//充值记录
                
                tAppInfo.setTime(null);//最近一次充值时间
                tAppInfo.setMoney("0");//最近一次充值金额
                
                tAppInfo.setBalance("0");//余额
                
                try {
                    if (null!=app.getSpace().getOrganization()&&null!=app.getSpace().getOrganization().getGuid()) {
                        List<Balance> balanceList = balanceRepository.findByorgGuid(app.getSpace().getOrganization().getGuid());
                        Double balanceTotal=0.0;
                        for (Balance balance : balanceList) {
                            balanceTotal+= balance.getBalance()==null?0:balance.getBalance();
                        }
                        tAppInfo.setBalance(balanceTotal+"");
                        
                        Sort sort = new Sort(Sort.Direction.DESC,"id");
                        List<TBalanceDetail> tBalanceList = tBalanceDetailRepository.findByorgGuid(app.getSpace().getOrganization().getGuid(),sort); //迁移
                        if (null!=tBalanceList&&tBalanceList.size()>0) {
                            for (TBalanceDetail tBalanceDetail : tBalanceList) {
                                if (tBalanceDetail.getBalanceStatus()==1) {
                                    tAppInfo.setTime(tBalanceDetail.getBalanceDate());
                                    tAppInfo.setMoney(Double.valueOf(tBalanceDetail.getDetailBalance())+"");
                                    break;
                                }
                            }
                            double q=0;
                            double s=0;
                            double u=0;
                            for (TBalanceDetail tBalanceDetail : tBalanceList) {
                                if (tBalanceDetail.getBalanceStatus()==1) {
                                    if (tBalanceDetail.getBalanceType()==-1) {
                                        q+=tBalanceDetail.getDetailBalance();
                                    }else if (tBalanceDetail.getBalanceType()==0){
                                        s+=tBalanceDetail.getDetailBalance();
                                    }else if (tBalanceDetail.getBalanceType()>0){
                                        u+=tBalanceDetail.getDetailBalance();
                                    }
                                }
                            }
                            tAppInfo.setInfo("余额迁移:" + q + ",系统赠送:" + s + ",用户充值:" + u );
                        }
                        if (null!=app.getSpace().getOrganization().getOrgManagers()&&app.getSpace().getOrganization().getOrgManagers().size()>0) {
                            UaaUser uaaUser = uaaUserRepository.findOne(app.getSpace().getOrganization().getOrgManagers().get(0).getGuid()); 
                            if (null != uaaUser) {
                                tAppInfo.setEmail(uaaUser.getEmail());//邮箱
                                if (null!=uaaUser.getExternalId()) {
                                    tAppInfo.setPhone(uaaUser.getExternalId());//手机
                                }else {
                                    tAppInfo.setPhone(uaaUser.getPhone());//手机
                                }
                             
                                if (uaaUser.getSource()==0) {
                                    tAppInfo.setOrigin("V2");//来源
                                }else if (uaaUser.getSource()==1) {
                                    tAppInfo.setOrigin("V3");//来源
                                }else if (uaaUser.getSource()==2) {
                                    tAppInfo.setOrigin("上海软件园");//来源
                                }else if (uaaUser.getSource()==3) {
                                    tAppInfo.setOrigin("OSC");//来源
                                }else if (uaaUser.getSource()==4) {
                                    tAppInfo.setOrigin("瀚云");//来源
                                }
                                
   
                                PCertification pCert = pCertificationRepository.findByUser(uaaUser);
                                if (null!=pCert) {
                                    tAppInfo.setCretification("个人认证");
                                    if (pCert.getState()==1) {
                                        tAppInfo.setCretstate("审核通过");
                                    }else if (pCert.getState()==-1) {
                                        tAppInfo.setCretstate("已驳回");
                                    }else {
                                        tAppInfo.setCretstate("待审核");
                                    }
                                }
                                
                                ECertification eCert = eCertificationRepository.findByUser(uaaUser);
                                if (null!=eCert) {
                                    tAppInfo.setCretification("企业认证");//认证
                                    if (eCert.getState()==1) {
                                        tAppInfo.setCretstate("审核通过");//认证状态
                                    }else if (pCert.getState()==-1) {
                                        tAppInfo.setCretstate("已驳回");
                                    }else {
                                        tAppInfo.setCretstate("待审核");
                                    }
                                }
                            }
                        }
                    }
                   
                    appInfoRepository.save(tAppInfo);
                } catch (Exception e) {
                    appInfoRepository.save(tAppInfo);
                    continue;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("###################################end######################################time=" + (end-start));
    }
    
    
    
    @RequestMapping(value = "/azure", method = RequestMethod.GET)
    public void azure(HttpServletRequest request,HttpServletResponse response) {
        long start = System.currentTimeMillis();
        System.out.println("###################################start######################################");
        List<AzureApp> list = azureAppsRepository.findAll();
        if (null!= list && list.size()>0) {
            for (AzureApp app : list) {
                TAppInfo tAppInfo =new TAppInfo();
                tAppInfo.setName(app.getName());
                tAppInfo.setPlat("微软azure");
                if (app.getState().equals("STARTED")) {
                    tAppInfo.setState("运行");
                }else if (app.getState().equals("STOPPED")) {
                    tAppInfo.setState("停止");
                }else {
                    tAppInfo.setState("异常");
                }
                tAppInfo.setUsed(app.getUpdatedAt());
               
                tAppInfo.setEmail("--");//邮箱
                tAppInfo.setPhone("--");//手机
                tAppInfo.setOrigin("--");//来源
                tAppInfo.setCretification("未认证");//认证
                tAppInfo.setCretstate("--");//认证状态
                
                tAppInfo.setInfo("--");//充值记录
                
                tAppInfo.setTime(null);//最近一次充值时间
                tAppInfo.setMoney("0");//最近一次充值金额
                
                tAppInfo.setBalance("0");//余额
                
                try {
                    if (null!=app.getSpace().getAzureorganization()&&null!=app.getSpace().getAzureorganization().getGuid()) {
                        List<Balance> balanceList = balanceRepository.findByorgGuid(app.getSpace().getAzureorganization().getGuid());
                        Double balanceTotal=0.0;
                        for (Balance balance : balanceList) {
                            balanceTotal+= balance.getBalance()==null?0:balance.getBalance();
                        }
                        tAppInfo.setBalance(balanceTotal+"");
                        
                        Sort sort = new Sort(Sort.Direction.DESC,"id");
                        List<TBalanceDetail> tBalanceList = tBalanceDetailRepository.findByorgGuid(app.getSpace().getAzureorganization().getGuid(),sort); //迁移
                        if (null!=tBalanceList&&tBalanceList.size()>0) {
                            for (TBalanceDetail tBalanceDetail : tBalanceList) {
                                if (tBalanceDetail.getBalanceStatus()==1) {
                                    tAppInfo.setTime(tBalanceDetail.getBalanceDate());
                                    tAppInfo.setMoney(Double.valueOf(tBalanceDetail.getDetailBalance())+"");
                                    break;
                                }
                            }
                            double q=0;
                            double s=0;
                            double u=0;
                            for (TBalanceDetail tBalanceDetail : tBalanceList) {
                                if (tBalanceDetail.getBalanceStatus()==1) {
                                    if (tBalanceDetail.getBalanceType()==-1) {
                                        q+=tBalanceDetail.getDetailBalance();
                                    }else if (tBalanceDetail.getBalanceType()==0){
                                        s+=tBalanceDetail.getDetailBalance();
                                    }else if (tBalanceDetail.getBalanceType()>0){
                                        u+=tBalanceDetail.getDetailBalance();
                                    }
                                }
                            }
                            tAppInfo.setInfo("余额迁移:" + q + ",系统赠送:" + s + ",用户充值:" + u );
                        }
                        
                        Organization organizatio = organizationRepository.findByGuid(app.getSpace().getAzureorganization().getGuid());
                        if (null != organizatio) {
                            if (null!=organizatio.getOrgManagers()&&organizatio.getOrgManagers().size()>0) {
                                UaaUser uaaUser = uaaUserRepository.findOne(organizatio.getOrgManagers().get(0).getGuid()); 
                                if (null != uaaUser) {
                                    tAppInfo.setEmail(uaaUser.getEmail());//邮箱
                                    if (null!=uaaUser.getExternalId()) {
                                        tAppInfo.setPhone(uaaUser.getExternalId());//手机
                                    }else {
                                        tAppInfo.setPhone(uaaUser.getPhone());//手机
                                    }
                                 
                                    if (uaaUser.getSource()==0) {
                                        tAppInfo.setOrigin("V2");//来源
                                    }else if (uaaUser.getSource()==1) {
                                        tAppInfo.setOrigin("V3");//来源
                                    }else if (uaaUser.getSource()==2) {
                                        tAppInfo.setOrigin("上海软件园");//来源
                                    }else if (uaaUser.getSource()==3) {
                                        tAppInfo.setOrigin("OSC");//来源
                                    }else if (uaaUser.getSource()==4) {
                                        tAppInfo.setOrigin("瀚云");//来源
                                    }
                                    
       
                                    PCertification pCert = pCertificationRepository.findByUser(uaaUser);
                                    if (null!=pCert) {
                                        tAppInfo.setCretification("个人认证");
                                        if (pCert.getState()==1) {
                                            tAppInfo.setCretstate("审核通过");
                                        }else if (pCert.getState()==-1) {
                                            tAppInfo.setCretstate("已驳回");
                                        }else {
                                            tAppInfo.setCretstate("待审核");
                                        }
                                    }
                                    
                                    ECertification eCert = eCertificationRepository.findByUser(uaaUser);
                                    if (null!=eCert) {
                                        tAppInfo.setCretification("企业认证");//认证
                                        if (eCert.getState()==1) {
                                            tAppInfo.setCretstate("审核通过");//认证状态
                                        }else if (pCert.getState()==-1) {
                                            tAppInfo.setCretstate("已驳回");
                                        }else {
                                            tAppInfo.setCretstate("待审核");
                                        }
                                    }
                                }
                            }
                        }
                    }
                   
                    appInfoRepository.save(tAppInfo);
                } catch (Exception e) {
                    appInfoRepository.save(tAppInfo);
                    continue;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("###################################end######################################time=" + (end-start));
    }
    
    
    @RequestMapping(value = "/app", method = RequestMethod.GET)
    public void appInfo(HttpServletRequest request,HttpServletResponse response) {
        long start = System.currentTimeMillis();
        System.out.println("###################################start######################################");
        //查询阿里云上的应用
        List<App> list = appsRepository.findAll();
        if (null!= list && list.size()>0) {
            for (App app : list) {
                TAppInfo tAppInfo =new TAppInfo();
                tAppInfo.setName(app.getName());
                tAppInfo.setPlat("阿里云");
                if (app.getState().equals("STARTED")) {
                    tAppInfo.setState("运行");
                }else if (app.getState().equals("STOPPED")) {
                    tAppInfo.setState("停止");
                }else {
                    tAppInfo.setState("异常");
                }
                tAppInfo.setUsed(app.getUpdatedAt());
               
                tAppInfo.setEmail("--");//邮箱
                tAppInfo.setPhone("--");//手机
                tAppInfo.setOrigin("--");//来源
                tAppInfo.setCretification("未认证");//认证
                tAppInfo.setCretstate("--");//认证状态
                
                tAppInfo.setInfo("--");//充值记录
                
                tAppInfo.setTime(null);//最近一次充值时间
                tAppInfo.setMoney("0");//最近一次充值金额
                
                tAppInfo.setBalance("0");//余额
                
                try {
                    if (null!=app.getSpace().getOrganization()&&null!=app.getSpace().getOrganization().getGuid()) {
                        List<Balance> balanceList = balanceRepository.findByorgGuid(app.getSpace().getOrganization().getGuid());
                        Double balanceTotal=0.0;
                        for (Balance balance : balanceList) {
                            balanceTotal+= balance.getBalance()==null?0:balance.getBalance();
                        }
                        tAppInfo.setBalance(balanceTotal+"");
                        
                        Sort sort = new Sort(Sort.Direction.DESC,"id");
                        List<TBalanceDetail> tBalanceList = tBalanceDetailRepository.findByorgGuid(app.getSpace().getOrganization().getGuid(),sort); //迁移
                        if (null!=tBalanceList&&tBalanceList.size()>0) {
                            for (TBalanceDetail tBalanceDetail : tBalanceList) {
                                if (tBalanceDetail.getBalanceStatus()==1) {
                                    tAppInfo.setTime(tBalanceDetail.getBalanceDate());
                                    tAppInfo.setMoney(Double.valueOf(tBalanceDetail.getDetailBalance())+"");
                                    break;
                                }
                            }
                            double q=0;
                            double s=0;
                            double u=0;
                            for (TBalanceDetail tBalanceDetail : tBalanceList) {
                                if (tBalanceDetail.getBalanceStatus()==1) {
                                    if (tBalanceDetail.getBalanceType()==-1) {
                                        q+=tBalanceDetail.getDetailBalance();
                                    }else if (tBalanceDetail.getBalanceType()==0){
                                        s+=tBalanceDetail.getDetailBalance();
                                    }else if (tBalanceDetail.getBalanceType()>0){
                                        u+=tBalanceDetail.getDetailBalance();
                                    }
                                }
                            }
                            tAppInfo.setInfo("余额迁移:" + q + ",系统赠送:" + s + ",用户充值:" + u );
                        }
                        if (null!=app.getSpace().getOrganization().getOrgManagers()&&app.getSpace().getOrganization().getOrgManagers().size()>0) {
                            UaaUser uaaUser = uaaUserRepository.findOne(app.getSpace().getOrganization().getOrgManagers().get(0).getGuid()); 
                            if (null != uaaUser) {
                                tAppInfo.setEmail(uaaUser.getEmail());//邮箱
                                if (null!=uaaUser.getExternalId()) {
                                    tAppInfo.setPhone(uaaUser.getExternalId());//手机
                                }else {
                                    tAppInfo.setPhone(uaaUser.getPhone());//手机
                                }
                             
                                if (uaaUser.getSource()==0) {
                                    tAppInfo.setOrigin("V2");//来源
                                }else if (uaaUser.getSource()==1) {
                                    tAppInfo.setOrigin("V3");//来源
                                }else if (uaaUser.getSource()==2) {
                                    tAppInfo.setOrigin("上海软件园");//来源
                                }else if (uaaUser.getSource()==3) {
                                    tAppInfo.setOrigin("OSC");//来源
                                }else if (uaaUser.getSource()==4) {
                                    tAppInfo.setOrigin("瀚云");//来源
                                }
                                
   
                                PCertification pCert = pCertificationRepository.findByUser(uaaUser);
                                if (null!=pCert) {
                                    tAppInfo.setCretification("个人认证");
                                    if (pCert.getState()==1) {
                                        tAppInfo.setCretstate("审核通过");
                                    }else if (pCert.getState()==-1) {
                                        tAppInfo.setCretstate("已驳回");
                                    }else {
                                        tAppInfo.setCretstate("待审核");
                                    }
                                }
                                
                                ECertification eCert = eCertificationRepository.findByUser(uaaUser);
                                if (null!=eCert) {
                                    tAppInfo.setCretification("企业认证");//认证
                                    if (eCert.getState()==1) {
                                        tAppInfo.setCretstate("审核通过");//认证状态
                                    }else if (pCert.getState()==-1) {
                                        tAppInfo.setCretstate("已驳回");
                                    }else {
                                        tAppInfo.setCretstate("待审核");
                                    }
                                }
                            }
                        }
                    }
                   
                    appInfoRepository.save(tAppInfo);
                } catch (Exception e) {
                    appInfoRepository.save(tAppInfo);
                    continue;
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("###################################end######################################time=" + (end-start));
    }
}
