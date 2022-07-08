package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.server.server.Entity.Orders;

import com.server.server.Entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class NotificationDto {
  private long id;


  private String msgBody;
  private String subject;
  private String attachment;

  private transient Orders orders;
  private transient Employee employee;
}
