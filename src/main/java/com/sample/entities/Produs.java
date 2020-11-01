package com.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Produs {

    @Getter @Setter
    private String denumire;

    @Getter @Setter
    private String tip;

    @Getter @Setter
    private Double pret;
}
