package com.sample.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
public class Comanda {

    @Getter
    @Setter
    private Date dataComanda;

    @Getter
    @Setter
    private Client client;

    @Getter
    @Setter
    private List<ArticolComanda> articole;

    @Getter
    @Setter
    private Double discountPeComanda;

    public Comanda(Date dataComanda, Client client) {
        this.dataComanda = dataComanda;
        this.client = client;
    }

    private Double valoareComanda;

    public Double getValoareComanda() {
        this.valoareComanda = 0.0;
        for (ArticolComanda a : this.articole)
            if (a.getDiscount() != null)
                this.valoareComanda += (a.getCantitate() * a.getProdus().getPret()) - (a.getDiscount() * a.getCantitate() * a.getProdus().getPret());
            else this.valoareComanda += a.getCantitate() * a.getProdus().getPret();
        if (discountPeComanda != null)
            valoareComanda = valoareComanda - discountPeComanda;
        return valoareComanda;
    }

}
