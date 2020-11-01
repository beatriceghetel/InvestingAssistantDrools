package com.sample.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
public class PlasamentRecomandat {

    @Getter @Setter
    private Recomandare recomandare;

    @Getter @Setter
    private Plasament plasament;

    @Getter @Setter
    private Double procent;

    @Getter @Setter
    private Double profit = 0.0;

    public PlasamentRecomandat(Recomandare recomandare, Plasament plasament, Double procent) {
        this.recomandare = recomandare;
        this.plasament = plasament;
        this.procent = procent;
    }

}
