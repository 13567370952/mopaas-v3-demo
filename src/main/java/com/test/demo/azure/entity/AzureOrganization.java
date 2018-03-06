package com.test.demo.azure.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "AzureOrganization")
@Table(name="organizations")
public class AzureOrganization {
    @Id
    private Long  id;
    private String guid;  
    private String name;
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
    @Override
    public String toString() {
        return "Organization [id=" + id + ", guid=" + guid + ", name=" + name + "]";
    }
}
