package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import com.server.server.Entity.Client;

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
public class ReclamationDto {
  private long id;

  private String msgBody;
  private String subject;
  private String attachment;
  private transient Client client;

}


