package com.test.demo.secondary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "AliyunAppInfo")
@Table(name="t_aliyun_appinfo")
public class TAliyunAppInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;//编号
    @Column(name="app_name")//应用名
    private String appName;
    @Column(name="app_state")//０stop  1run
    private Integer appState;
    @Column(name="cert_state")//０未认证  1认证
    private Integer certState;
    @Column(name="last_state")//０最近使用小于６个月  1大于６个月
    private Integer lastState;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="last_time")//最后使用时间
    private Date lastTime;
    @Column(name="user_name")//用户名
    private String userName;
    @Column(name="user_email")//邮箱
    private String userEmail;
    @Column(name="user_tel")//邮箱
    private String userTel;
    @Column(name="user_system")//赠送余额
    private Double userSystem;
    @Column(name="user_recharge")//充值余额
    private Double userRecharge;
    @Column(name="user_balance")//余额
    private Double userBalance;
    @Column(name="user_type")//用户类型,参照文档
    private Integer userType;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="user_time")//用户最后一次登入时间
    private Date userTime;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public Integer getAppState() {
        return appState;
    }
    public void setAppState(Integer appState) {
        this.appState = appState;
    }
    public Integer getCertState() {
        return certState;
    }
    public void setCertState(Integer certState) {
        this.certState = certState;
    }
    public Integer getLastState() {
        return lastState;
    }
    public void setLastState(Integer lastState) {
        this.lastState = lastState;
    }
    public Date getLastTime() {
        return lastTime;
    }
    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserEmail() {
        return userEmail;
    }
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
    public String getUserTel() {
        return userTel;
    }
    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }
    public Double getUserSystem() {
        return userSystem;
    }
    public void setUserSystem(Double userSystem) {
        this.userSystem = userSystem;
    }
    public Double getUserRecharge() {
        return userRecharge;
    }
    public void setUserRecharge(Double userRecharge) {
        this.userRecharge = userRecharge;
    }
    public Double getUserBalance() {
        return userBalance;
    }
    public void setUserBalance(Double userBalance) {
        this.userBalance = userBalance;
    }
    public Integer getUserType() {
        return userType;
    }
    public void setUserType(Integer userType) {
        this.userType = userType;
    }
    public Date getUserTime() {
        return userTime;
    }
    public void setUserTime(Date userTime) {
        this.userTime = userTime;
    }
    @Override
    public String toString() {
        return "TAliyunAppInfo [id=" + id + ", appName=" + appName + ", appState=" + appState
               + ", certState=" + certState + ", lastState=" + lastState + ", lastTime=" + lastTime
               + ", userName=" + userName + ", userEmail=" + userEmail + ", userTel=" + userTel
               + ", userSystem=" + userSystem + ", userRecharge=" + userRecharge + ", userBalance="
               + userBalance + ", userType=" + userType + ", userTime=" + userTime + "]";
    }
}
