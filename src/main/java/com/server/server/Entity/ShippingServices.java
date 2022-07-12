package com.server.server.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity

public class ShippingServices {
    @Id
    private  long id;
    private String delay;
    private String name;

    @ManyToOne
    private Carriers carriers;


}
