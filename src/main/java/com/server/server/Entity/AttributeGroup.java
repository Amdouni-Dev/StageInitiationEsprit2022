package com.server.server.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
public class AttributeGroup {
  @Id
  private long id;
  private  String name;
  private  String isoCode;

  @JsonIgnore
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "attributeGroup")
  private List<Attributes> attributes;
}
