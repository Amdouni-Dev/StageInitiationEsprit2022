package com.server.server.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Carriers {

    @Id
    private long id;
    private String name;


    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carriers")
    private List<ShippingServices> shippingServices;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "carriers")
    private List<ShippingCountries> shippingCountries;

    @ManyToOne
    private Orders orders;
}
