package com.server.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.server.server.Entity.Produit;
import com.server.server.Service.ProduitService;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;

@SpringBootApplication
@EnableScheduling

public class ServerApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProduitService produitService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<Produit>> typeReference = new TypeReference<List<Produit>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Produit.json");
            try {
                List<Produit> produits = mapper.readValue(inputStream,typeReference);
                produitService.save(produits);
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }
}
