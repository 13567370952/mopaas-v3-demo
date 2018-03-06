package com.test.demo.aliuaa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_personal_certification")
public class PCertification {
    @Id
    private Long  id;
    @OneToOne
    @JoinColumn(name = "user_guid", referencedColumnName = "id")
    private UaaUser user;
    private Integer state; // 0待审核 -1不通过 1通过
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