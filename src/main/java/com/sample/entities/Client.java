package com.sample.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class Client {

    @Getter @Setter
    private String name;

    @Getter @Setter
    private String tip;
}
