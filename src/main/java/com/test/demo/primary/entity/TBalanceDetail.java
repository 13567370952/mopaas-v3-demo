package com.test.demo.primary.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "BalanceDetail")
@Table(name="t_balance_detail")
public class TBalanceDetail {
    @Id
    private Long  id;
    @Column(name="user_admin")
    private String userAdmin;
    @Column(name="org_guid")
    private String orgGuid;
    @Column(name="balance_status")//0充值中,1充值成功
    private Long  balanceStatus;
    @Column(name="detail_balance")//0充值中,1充值成功
    private Float  detailBalance;
    @Column(name="balance_type")
    private Integer balanceType; // -1 迁移,0系统赠送,1-11支付宝
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="balance_date")//充值时间
    private Date balanceDate;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUserAdmin() {
        return userAdmin;
    }
    public void setUserAdmin(String userAdmin) {
        this.userAdmin = userAdmin;
    }

    public Long getBalanceStatus() {
        return balanceStatus;
    }
    public void setBalanceStatus(Long balanceStatus) {
        this.balanceStatus = balanceStatus;
    }
    public String getOrgGuid() {
        return orgGuid;
    }
    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }
    public Integer getBalanceType() {
        return balanceType;
    }
    public void setBalanceType(Integer balanceType) {
        this.balanceType = balanceType;
    }
    public Date getBalanceDate() {
        return balanceDate;
    }
    public void setBalanceDate(Date balanceDate) {
        this.balanceDate = balanceDate;
    }
    public Float getDetailBalance() {
        return detailBalance;
    }
    public void setDetailBalance(Float detailBalance) {
        this.detailBalance = detailBalance;
    }
    @Override
    public String toString() {
        return "TBalanceDetail [id=" + id + ", userAdmin=" + userAdmin + ", orgGuid=" + orgGuid
               + ", balanceStatus=" + balanceStatus + ", balanceType=" + balanceType
               + ", balanceDate=" + balanceDate + "]";
    }
}
