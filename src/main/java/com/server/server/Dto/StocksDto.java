package com.server.server.Dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class StocksDto implements Serializable {
    private long id;
    private long quantity;
    private long minHandlingDays;
    private long maxHandlingDays;
}
