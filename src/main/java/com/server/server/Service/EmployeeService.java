package com.server.server.Service;

import java.util.List;
import java.util.Optional;

import com.server.server.Entity.Client;
import com.server.server.Entity.Employee;
import com.server.server.Entity.Promotion;
import com.server.server.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  //get all employees
  public List<Employee> getEmployees() {
    return employeeRepository.findAll();
  }

  //get employee by id
  public ResponseEntity<Employee> getEmployee(long id) {

    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    if (optionalEmployee.isPresent()) {
      return ResponseEntity.ok(optionalEmployee.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  //update employee profile
  public ResponseEntity<Employee> editProfile(long id, Employee employee) {
    if (employee == null) {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    Optional<Employee> optionalEmployee = employeeRepository.findById(id);
    if (optionalEmployee.isPresent()) {
      employee.setId(id);
      employee.setPassword(optionalEmployee.get().getPassword());
      employeeRepository.save(employee);
      return ResponseEntity.ok(optionalEmployee.get());
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

  //delete employee
  public void deleteEmployee(long id) {
    employeeRepository.deleteById(id);
  }
}
