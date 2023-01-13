package com.microservices.service;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.model.CafeReview;
import com.microservices.repository.CafeReviewRepository; 
  

  
@Service
public class CafeReviewService {

    @Autowired
    CafeReviewRepository cafeReviewRepository; 
  
    public CafeReview addReview(CafeReview cafeReview) {
        // TODO Auto-generated method stub
        return cafeReviewRepository.save(cafeReview);
    } 
  
    public List<CafeReview> getReviews() {
        // TODO Auto-generated method stub
        return cafeReviewRepository.findAll();
    } 
  
    public List<CafeReview> getReview(Integer cafeId) {
        System.out.println("Inside the getReview Service method");
        return cafeReviewRepository.findAllByCafeId(cafeId);
    } 
  
}

