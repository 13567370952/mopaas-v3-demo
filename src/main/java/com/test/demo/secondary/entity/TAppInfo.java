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


@Entity(name = "AppInfo")
@Table(name="t_app_info")
public class TAppInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String name;
    private String plat;
    private String state;
    private String email;
    private String phone;
    private String origin;
    private String cretification;
    private String cretstate;
    private String info;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="time")
    private Date time;
    private String money;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="used")
    private Date used;
    private String balance;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPlat() {
        return plat;
    }
    public void setPlat(String plat) {
        this.plat = plat;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public String getCretification() {
        return cretification;
    }
    public void setCretification(String cretification) {
        this.cretification = cretification;
    }
    public String getInfo() {
        return info;
    }
    public void setInfo(String info) {
        this.info = info;
    }
    public Date getTime() {
        return time;
    }
    public void setTime(Date time) {
        this.time = time;
    }
    public String getMoney() {
        return money;
    }
    public void setMoney(String money) {
        this.money = money;
    }
    public Date getUsed() {
        return used;
    }
    public void setUsed(Date used) {
        this.used = used;
    }
    public String getBalance() {
        return balance;
    }
    public void setBalance(String balance) {
        this.balance = balance;
    }
    public String getCretstate() {
        return cretstate;
    }
    public void setCretstate(String cretstate) {
        this.cretstate = cretstate;
    }
    @Override
    public String toString() {
        return "TAppInfo [id=" + id + ", name=" + name + ", plat=" + plat + ", state=" + state
               + ", email=" + email + ", phone=" + phone + ", origin=" + origin
               + ", cretification=" + cretification + ", info=" + info + ", time=" + time
               + ", money=" + money + ", used=" + used + ", balance=" + balance + "]";
    }
}
