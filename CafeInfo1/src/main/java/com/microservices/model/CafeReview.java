package com.microservices.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CafeReview {
    @Id
    @GeneratedValue
    private Integer reviewId;
    private Integer cafeId;
    private Integer cafeRating;
    private String cafeRemarks;

    public CafeReview() {
        super();
    }
    public CafeReview(Integer cafeId, Integer cafeRating, String cafeRemarks) {
        super();
        this.cafeId = cafeId;
        this.cafeRating = cafeRating;
        this.cafeRemarks = cafeRemarks;
    }
    public Integer getReviewId() {
        return reviewId;
    }
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }
    public Integer getCafeId() {
        return cafeId;
    }
    public void setCafeId(Integer cafeId) {
        this.cafeId = cafeId;
    }
    public Integer getCafeRating() {
        return cafeRating;
    }
    public void setCafeRating(Integer cafeRating) {
        this.cafeRating = cafeRating;
    }
    public String getCafeRemarks() {
        return cafeRemarks;
    }
    public void setCafeRemarks(String cafeRemarks) {
        this.cafeRemarks = cafeRemarks;
    }


  
}

