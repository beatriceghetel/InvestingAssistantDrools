package com.sample.entities;

import com.sample.classifications.Cariera;
import com.sample.classifications.Venit;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Investitor {

    private static final Double MIN_CHELT_SUBZISTENTA = 250.0;
    private static final Integer MIN_LUNI_STABILE = 6;

    @Getter @Setter
    private String email;

    @Getter @Setter
    private Cariera etapaCarierei;

    @Getter @Setter
    private Venit categoriaVeniturilor;

    @Getter @Setter
    private Double avereaPersonala;

    @Getter @Setter
    private Double datoriiLunare;

    @Getter @Setter
    private Double venitulMediu;
    
    @Getter @Setter
    private Boolean experientaInTranzactionare;
    
    @Getter @Setter
    private Boolean abonatLaMail;

    public Boolean areExpunerePesteMarja() {
        return (this.avereaPersonala - MIN_LUNI_STABILE * (this.venitulMediu - this.datoriiLunare - MIN_CHELT_SUBZISTENTA)) > 0.4 * this.avereaPersonala;
    }
}
