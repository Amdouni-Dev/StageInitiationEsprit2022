package com.server.server.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.server.Enums.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String first_name;
  private String last_name;
  private String email;
  private String password;
  private Role role;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
  private List<Promotion> promotions;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee")
  private List<Notification> notifications;
}
