package com.server.server.Dto;

import java.util.List;

import com.server.server.Entity.Notification;
import com.server.server.Entity.Promotion;
import com.server.server.Enums.Role;

public class EmployeDto {
  private long id;

  private String nom;
  private String prenom;
  private String email;
  private String password;
  private Role role;
  private transient List<Promotion> promotions;
  private transient List<Notification> notifications;
}
