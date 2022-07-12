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
public class ShippingCountriesDto  implements Serializable {



    private long id;

    private String isoCountry;
    private transient Carriers carriers;

}
