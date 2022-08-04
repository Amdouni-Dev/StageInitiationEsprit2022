package com.server.server.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Stocks {
    @Id
    private long id;
    private long quantity;
    private long minHandlingDays;
    private long maxHandlingDays;

    @OneToOne()
    private Product product;
}
