package com.tts.dealership.car.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Car
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    //One to many mapping.    
    @ManyToOne
    @JoinColumn(name="dealer")
    @NotNull
    private Dealer dealer;

    @NotNull
    private String color;
       
    //Manufacturers suggested retail price.
    private double msrp;
    
    @NotNull    
    private String model;
    
    @NotNull
    private String make;
}
