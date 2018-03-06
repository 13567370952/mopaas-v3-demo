package com.test.demo.azure.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "AzureApps")
@Table(name="apps")
public class AzureApp {
    @Id
    private Long  id;
    private String name;
    private String guid;  
    private String state;
    @ManyToOne
    @JoinColumn(name="space_id")
    private AzureSpace space;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="updated_at")//最后使用时间
    private Date updatedAt;
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
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public AzureSpace getSpace() {
        return space;
    }
    public void setSpace(AzureSpace space) {
        this.space = space;
    }
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    public Date getUpdatedAt() {
        return updatedAt;
    }
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
    @Override
    public String toString() {
        return "App [id=" + id + ", name=" + name + ", guid=" + guid + ", state=" + state
               + ", space=" + space + ", updatedAt=" + updatedAt + "]";
    }
    
}
