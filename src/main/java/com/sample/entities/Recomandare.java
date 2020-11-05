package com.sample.entities;

import lombok.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Recomandare {

    @Getter @Setter
    private Date dataRecomandare;

    @Getter @Setter
    private Investitor investitor;

    @Getter @Setter
    private List<PlasamentRecomandat> plasamente = new ArrayList<>();

    private Double profitPeRecomandare = 0.0;
    
    @Getter @Setter
    private Double marjaEconomii = 0.0;
    
    /**
     * Metoda parcurge toate plasamentele financiare recomandate unui investitor si calculeaza profitul pe care acesta
     * obtine, in functie de procentul investit in fiecare plasament si procentul de profit mediu pentru acel
     * plasament.
     * @return profitul pentru toate plasamentele recomandate in RON
     */
    public Double getProfitPeRecomandare() {
    	this.profitPeRecomandare = 0.0;
        for (PlasamentRecomandat plasamentRecomandat : this.plasamente) {
        	this.profitPeRecomandare += (plasamentRecomandat.getProcent() * (investitor.getAvereaPersonala() - this.marjaEconomii * investitor.getAvereaPersonala()) * plasamentRecomandat.getPlasament().getProfitMediu());
        }
        return profitPeRecomandare;
    }

    public Recomandare(Date dataRecomandare, Investitor investitor) {
        this.dataRecomandare = dataRecomandare;
        this.investitor = investitor;
    }
}
