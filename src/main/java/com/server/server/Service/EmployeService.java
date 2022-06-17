package com.server.server.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.server.server.Repository.EmployeRepository;

@Service
public class EmployeService {
  @Autowired
  EmployeRepository employeRepository;
}
