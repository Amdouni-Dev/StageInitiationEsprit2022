package com.server.server;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.server.server.Entity.Carriers;
import com.server.server.Service.CarriersService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ServerApplication {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    public static void main(String[] args) {

        SpringApplication.run(ServerApplication.class, args);

        System.out.println("Mail Sent Successfully...");
    }

    /*
    @Bean
    CommandLineRunner runner(CarriersService carriersService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            //String path = getCarriers();
            //  System.out.println("ooooooooooooooooo"+path);
            com.fasterxml.jackson.core.type.TypeReference<List<Carriers>> typeReference = new com.fasterxml.jackson.core.type.TypeReference<List<Carriers>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/test.json");
            try {
                List<Carriers> carriers = mapper.readValue(inputStream,typeReference);
                carriersService.save(carriers);
                System.out.println("Products Saved!");
            } catch (IOException e){
                System.out.println("Unable to save products: " + e.getMessage());
            }
        };
/
    }*/

}
