package com.server.server.Service;


import com.server.server.Entity.Carriers;
import com.server.server.Repository.CarriersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CarriersService {



        private final CarriersRepository carriersRepository;

        public CarriersService(CarriersRepository carriersRepository) {
            this.carriersRepository = carriersRepository;
        }


        public Iterable<Carriers> list() {
            return carriersRepository.findAll();
        }

        public Carriers save(Carriers carriers) {
            return carriersRepository.save(carriers);
        }

        public void save(List<Carriers> carriers) {
            carriersRepository.saveAll(carriers);
        }

    }

