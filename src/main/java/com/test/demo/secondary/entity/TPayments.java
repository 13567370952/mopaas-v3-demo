package com.test.demo.secondary.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "TPayments")
@Table(name="t_payments")
public class TPayments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(name="org_guid")
    private String orgGuid;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getOrgGuid() {
        return orgGuid;
    }
    public void setOrgGuid(String orgGuid) {
        this.orgGuid = orgGuid;
    }
}
