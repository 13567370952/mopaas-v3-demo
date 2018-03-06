package com.test.demo.azure.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "AzureSpace")
@Table(name="spaces")
public class AzureSpace {
    @Id
    private Long  id;
    private String name;
    private String guid;  
    @ManyToOne
    @JoinColumn(name="organization_id")
    private AzureOrganization Azureorganization;
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
    public AzureOrganization getAzureorganization() {
        return Azureorganization;
    }
    public void setAzureorganization(AzureOrganization azureorganization) {
        Azureorganization = azureorganization;
    }
    public String getGuid() {
        return guid;
    }
    public void setGuid(String guid) {
        this.guid = guid;
    }
    @Override
    public String toString() {
        return "AzureSpace [id=" + id + ", name=" + name + ", guid=" + guid
               + ", Azureorganization=" + Azureorganization + "]";
    }
}
