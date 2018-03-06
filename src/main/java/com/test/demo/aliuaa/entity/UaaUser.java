package com.test.demo.aliuaa.entity;

import javax.persistence.*;

@Entity(name = "uaausers")
@Table(name="users")
public class UaaUser {
    @Id
    private String  id;
    private String username;
    private String email;
    @Column(name="phonenumber")
    private String phone;
    @Column(name="external_id")
    private String externalId;
    private Integer source;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
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
    public String getExternalId() {
        return externalId;
    }
    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }
    public Integer getSource() {
        return source;
    }
    public void setSource(Integer source) {
        this.source = source;
    }
    @Override
    public String toString() {
        return "UaaUser [id=" + id + ", username=" + username + ", email=" + email + ", phone="
               + phone + ", externalId=" + externalId + ", source=" + source + "]";
    }
}
