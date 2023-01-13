package com.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.model.CafeInfo; 

  
public interface CafeInfoRepository extends JpaRepository<CafeInfo,Integer> { 
  
}
