package com.microservices.repository;

import java.util.List; 

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservices.model.CafeReview; 
  
 
  
public interface CafeReviewRepository extends JpaRepository<CafeReview,Integer> {
    List<CafeReview> findAllByCafeId(Integer cafeId); 
  
}
