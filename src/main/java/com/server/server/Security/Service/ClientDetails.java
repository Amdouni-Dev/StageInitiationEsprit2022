package com.server.server.Security.Service;

import java.util.Collection;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.server.server.Entity.Client;

public class ClientDetails implements UserDetails {

  private Long id;
  private String email;
  private String username;
  private static final long serialVersionUID = 1L;

  @JsonIgnore
  private String password;

  private Collection<? extends GrantedAuthority> authorities;

  public ClientDetails(Long id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public static ClientDetails build(Client client) {
    return new ClientDetails(
        client.getId(),
        client.getEmail(),
        client.getPassword()
    );
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return authorities;
  }


  public Long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return username;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ClientDetails client = (ClientDetails) o;
    return Objects.equals(id, client.id);
  }
}
