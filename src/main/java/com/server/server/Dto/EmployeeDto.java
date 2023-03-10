package com.server.server.Dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Notification;
import com.server.server.Entity.Promotion;
import com.server.server.Enums.Role;
import lombok.*;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeDto implements Serializable {
  private long id;
  private String first_name;
  private String last_name;
  private String email;
  private String password;
  private Role role;
  private transient List<Promotion> promotions;
  private transient List<Notification> notifications;
}
