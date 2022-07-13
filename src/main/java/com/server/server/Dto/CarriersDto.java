package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.server.server.Entity.Orders;
import com.server.server.Entity.ShippingCountries;
import com.server.server.Entity.ShippingServices;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CarriersDto implements Serializable {
    private long id;
    private String name;
    private transient List<ShippingServices> shippingServices;
    private transient List<ShippingCountries> shippingCountries;
    private transient Orders orders;
}

