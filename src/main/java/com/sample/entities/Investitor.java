package com.sample.entities;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Investitor {

    private static final Double MIN_CHELT_SUBZISTENTA = 250.0;
    private static final Integer MIN_LUNI_STABILE = 6;

//    public enum Venit { FIX, VARIABIL, ALTELE }

//    public enum Cariera { INCEPUT, ACTIV, FAMILIE, PERSONALE, RETRAS }

    @Getter @Setter
    private String email;

    @Getter @Setter
    private String etapaCarierei;

    @Getter @Setter
    private String categoriaVeniturilor;

    @Getter @Setter
    private Double avereaPersonala;

    @Getter @Setter
    private Double datoriiLunare;

    @Getter @Setter
    private Double venitulMediu;

    public Boolean areExpunerePesteMarja() {
        return (this.avereaPersonala - MIN_LUNI_STABILE * (this.venitulMediu - this.datoriiLunare - MIN_CHELT_SUBZISTENTA)) > 0.4 * this.avereaPersonala;
    }
}
