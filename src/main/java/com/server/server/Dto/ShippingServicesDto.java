package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Carriers;
import lombok.*;

import java.io.Serializable;


@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShippingServicesDto implements Serializable {
    private  long id;
    private String delay;
    private String name;
    private transient Carriers carriers;

}
