package com.microservices.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.microservices.model.CafeReview;
import com.microservices.service.CafeReviewService; 
   
@Controller
public class CafeReviewController {

    @Autowired
    CafeReviewService cafeReviewService; 
  


    @GetMapping("/")
    public String index() {
        return "index";        
    }

    @PostMapping("/addReview")
    public String addCafe(@ModelAttribute("cafeId") String cafeId,@ModelAttribute("cafeRating")String cafeRating,@ModelAttribute("cafeRemarks")String cafeRemarks) {
        System.out.println("Inside the controller addReview post method");
        CafeReview cafeReview=new CafeReview(Integer.valueOf(cafeId),Integer.valueOf(cafeRating),cafeRemarks);
        System.out.println("details of cafeReview is:"+cafeReview.getCafeId()+" "+cafeReview.getCafeRating()+" "+cafeReview.getCafeRemarks());

        CafeReview savedCafeReview=cafeReviewService.addReview(cafeReview);
        if (savedCafeReview!=null)
        {
            return "success";
        }
        else
        {
            return "fail";
        }

    }

    @GetMapping("/getReviews")
    @ResponseBody
    public List<CafeReview> getReviews() {
        return cafeReviewService.getReviews();        
    }

    @GetMapping("/count")
    @ResponseBody
    public String getReviewCount() {
        return String.valueOf(cafeReviewService.getReviews().size());        
    }

    @GetMapping("/getReview/{cafeId}")
    @ResponseBody
    public List<CafeReview> getReview(@PathVariable("cafeId")Integer cafeId)
    {
        System.out.println("Inside the getReview Controller method");
        return cafeReviewService.getReview(cafeId);
    }
  
}

