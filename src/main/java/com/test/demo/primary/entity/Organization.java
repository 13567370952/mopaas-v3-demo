package com.test.demo.primary.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity(name = "Organization")
@Table(name="organizations")
public class Organization {
    @Id
    private Long  id;
    private String guid;  
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "organizations_managers",
            joinColumns = {@JoinColumn(name = "organization_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id", referencedColumnName ="id")})
    private List<User> orgManagers=new ArrayList<User>();
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
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<User> getOrgManagers() {
        return orgManagers;
    }
    public void setOrgManagers(List<User> orgManagers) {
        this.orgManagers = orgManagers;
    }
    @Override
    public String toString() {
        return "Organization [id=" + id + ", guid=" + guid + ", name=" + name + ", orgManagers="
               + orgManagers + "]";
    }
}
