package com.server.server.Controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.server.Entity.Carriers;
import com.server.server.Service.CarriersService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RequestMapping("/oauth")
@RestController
public class CronController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    CarriersService carriersService;
    @Autowired
    private ModelMapper modelMapper;

    // Call microservice
    HttpHeaders createHeaders(){
        return new HttpHeaders() {
            {
                String authHeader ="Bearer YjQwYWVhNTg2MWRhZmUwYjk4YWJlNzY5Y2Q1YjlkYjE5NzY1YTUwMzM2ZTM5NDM1Yjc3M2MzYmExNTI1OWE2Zg";
                set( "Authorization", authHeader );
            }
        };

    }
    // call carriers microservice
    @RequestMapping(value = "/cron/getCarriers")
    public String getCarriers() {
        String path;
        path = restTemplate.exchange("http://localhost:8000/carriers", HttpMethod.GET, new HttpEntity<String>(createHeaders()), String.class).getBody();
        return path;
    }

    /*@Bean
    CommandLineRunner runner(CarriersService carriersService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Carriers>> typeReference = new TypeReference<List<Carriers>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/test.json");
            try {
                List<Carriers> carriers = mapper.readValue(inputStream,typeReference);
                carriersService.save(carriers);
                System.out.println("Products Saved!");
            } catch (IOException e){
                System.out.println("Unable to save products: " + e.getMessage());
            }
        };

    }*/

}