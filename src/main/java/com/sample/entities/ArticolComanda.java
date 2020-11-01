package com.sample.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class ArticolComanda {

    @Getter @Setter
    private Comanda comanda;

    @Getter @Setter
    private Produs produs;

    @Getter @Setter
    private Double cantitate;

    @Getter @Setter
    private Double discount;

    public ArticolComanda(Comanda comanda, Produs produs, Double cantitate) {
        this.comanda = comanda;
        this.produs = produs;
        this.cantitate = cantitate;
    }
}
