package com.sample.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Plasament {

    @Getter @Setter
    private String nume;

    @Getter @Setter
    private String tip;

    @Getter @Setter
    private Double profitMediu;
}
