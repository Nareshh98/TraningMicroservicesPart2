package com.microservices.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id; 


  
@Entity
public class CafeInfo {
    @Id
    @GeneratedValue
    private Integer cafeId;
    private String cafeName;
    private String cafeDesc;
    public CafeInfo() {
        super();
    }
    public CafeInfo(String cafeName, String cafeDesc) {
        super();
        this.cafeName = cafeName;
        this.cafeDesc = cafeDesc;
    }
    public Integer getCafeId() {
        return cafeId;
    }
    public void setCafeId(Integer cafeId) {
        this.cafeId = cafeId;
    }
    public String getCafeName() {
        return cafeName;
    }
    public void setCafeName(String cafeName) {
        this.cafeName = cafeName;
    }
    public String getCafeDesc() {
        return cafeDesc;
    }
    public void setCafeDesc(String cafeDesc) {
        this.cafeDesc = cafeDesc;
    }
    @Override
    public String toString() {
        return "CafeInfo [cafeId=" + cafeId + ", cafeName=" + cafeName + ", cafeDesc=" + cafeDesc + "]";
    }
  
}

