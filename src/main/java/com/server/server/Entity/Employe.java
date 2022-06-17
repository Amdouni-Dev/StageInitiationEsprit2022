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
public class Employe {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String nom;
  private String prenom;
  private String email;
  private String password;
  private Role role;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employe")
  private List<Promotion> promotions;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "employe")
  private List<Notification> notifications;
}
