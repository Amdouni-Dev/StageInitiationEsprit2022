package com.server.server.Controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.server.server.Dto.EmployeeDto;
import com.server.server.Dto.PromotionDto;
import com.server.server.Entity.Employee;
import com.server.server.Entity.Promotion;
import com.server.server.Service.EmployeeService;

@RequestMapping("/oauth")
@RestController
public class EmployeeController {

  public final static String FOUND = "FOUND";
  public final static String BAD_REQUEST = "BAD_REQUEST";
  public final static String NOT_FOUND = "NOT_FOUND";
  public final static String NULL = "ID NULL DETECTED";

  @Autowired
  EmployeeService employeeService;

  @Autowired
  private ModelMapper modelMapper;

  //get all employees
  @GetMapping("/getEmployees")
  public List<EmployeeDto> getEmployees() {
    return employeeService.getEmployees().stream().map(employee -> modelMapper.map(employee, EmployeeDto.class))
        .collect(Collectors.toList());
  }

  //get employee by id
  @GetMapping(value = "/getEmployee/{id}")
  public ResponseEntity<Object> getEmployee(@PathVariable("id") long id) {
    ResponseEntity<Employee> employee = employeeService.getEmployee(id);
    if (employee.getStatusCodeValue() == 200) {
      EmployeeDto employeeDto = modelMapper.map(employee.getBody(), EmployeeDto.class);
      return new ResponseEntity<>(employeeDto, HttpStatus.OK);
    } else if(employee.getStatusCodeValue() == 404){
      return new ResponseEntity<>(NOT_FOUND,HttpStatus.OK);
    }else{
      return new ResponseEntity<>(NULL,HttpStatus.OK);
    }
  }

  //update employee profile
  @PutMapping(value = "/editProfile/{id}")
  public ResponseEntity<Object> updateProfile(@PathVariable("id") long id, @RequestBody EmployeeDto employeeDto) {
    Employee employeeReq = modelMapper.map(employeeDto, Employee.class);
    ResponseEntity<Employee> employee = employeeService.editProfile(id, employeeReq);

    if (employee.getStatusCodeValue() == 200) {
      EmployeeDto employeeRes = modelMapper.map(employee.getBody(), EmployeeDto.class);
      return new ResponseEntity<>(employeeRes, HttpStatus.OK);
    } else if(employee.getStatusCodeValue() == 400) {
      return new ResponseEntity<>(BAD_REQUEST, HttpStatus.BAD_REQUEST);
    } else if(employee.getStatusCodeValue() == 404){
      return new ResponseEntity<>(NOT_FOUND,HttpStatus.OK);
    }else{
      return new ResponseEntity<>(NULL,HttpStatus.OK);
    }
  }

  @DeleteMapping(value = "/deleteEmployee/{id}")
  public void deleteEmployee(@PathVariable("id") long id) {
    employeeService.deleteEmployee(id);
  }
}
