package com.server.server.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class ShippingCountries {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; // mafamch fl API

    private String isoCountry;

    @ManyToOne
    private Carriers carriers;
}
