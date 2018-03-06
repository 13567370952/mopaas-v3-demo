package com.test.demo.primary.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "CCUsers")
@Table(name="users")
public class User {
    @Id
    private Long  id;
    private String guid;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    @Override
    public String toString() {
        return "User [id=" + id + ", guid=" + guid + "]";
    }
}
