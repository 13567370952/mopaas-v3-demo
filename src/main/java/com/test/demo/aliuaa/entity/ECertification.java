package com.test.demo.aliuaa.entity;

import javax.persistence.*;

@Entity
@Table(name = "t_enterprise_certification")
public class ECertification {
    @Id
    private Long  id;
    @OneToOne
    @JoinColumn(name = "user_guid", referencedColumnName = "id")
    private UaaUser user;
    private Integer state;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public UaaUser getUser() {
        return user;
    }
    public void setUser(UaaUser user) {
        this.user = user;
    }
   
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
    }
}
