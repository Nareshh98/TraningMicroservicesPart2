package com.microservices.services;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional; 
  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.microservices.model.CafeInfo;
import com.microservices.model.CafeReview;
import com.microservices.repository.CafeInfoRepository; 
  


  
@Service
@EnableAutoConfiguration
public class CafeInfoService {
    @Autowired
    CafeInfoRepository cafeInfoRepository;

    @Autowired
    RestTemplate restTemplate;
  

    public CafeInfo addCafe(CafeInfo cafeInfo)    {
        System.out.println("new cafeInfo details inside addCafe service is:"+cafeInfo.getCafeName()+" "+cafeInfo.getCafeDesc());
        System.out.println("repo object:"+cafeInfoRepository);
        return cafeInfoRepository.save(cafeInfo);
    }

    public List<CafeInfo> getCafes() {
        return cafeInfoRepository.findAll();
    } 
  
    public Optional<CafeInfo> getCafe(Integer cafeId) {
        return cafeInfoRepository.findById(cafeId);
    }



    @Autowired
    private DiscoveryClient discoveryClient; 
  
    
    @Value("${pivotal.cafereviewservice.name}")  //See in yml file
     protected String cafereviewservice;  //another  microservice to make call

    public ModelAndView getAll(Integer cafeId)
    {
        ModelAndView mv=new ModelAndView();
        mv.addObject("cafeInfo",this.getCafe(cafeId).get());
        // add cafeInfo detials into ModelAndView


        //getting instances using discoveryClient object  from Eureka Server      
        List<ServiceInstance> instances=  discoveryClient.getInstances(cafereviewservice);
        URI uri=instances.get(0).getUri();  
        // get(0) means geeting first object and getUri() means getting url of object


        
        String url=uri.toString()+"/getReview/"+cafeId;  // creating url for Cafereview
        System.out.println("========================================");
        System.out.println("CafeReview-Service.URI========="+url);

        //final String uri = "http://localhost:8096/getReview/cafeId;

             

        List<CafeReview> result = restTemplate.getForObject(url, List.class);
        
        
        // we are making call by using restTemplate by passing url 
        //and return type of object will be list because user will give so many reviews
        
        System.out.println("details of results:"+result.toString());

        //use below line if using feign
        //List<CafeReview> result=cafeInfoProxy.getReview(cafeId);

        mv.addObject("cafeReview",result); // by  using reference we are adding result into ModelAndView

        mv.setViewName("cafeAll");   // printing in cafeAll 
        return mv;


    } 
   
}

