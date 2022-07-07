package com.server.server.Service;

import com.server.server.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;
}
