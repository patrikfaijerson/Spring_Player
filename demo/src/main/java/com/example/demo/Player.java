package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
class Player{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String name;
    private String jerseyNumber;
    private int age;

    public Player(String name, String jerseyNumber, int age){
        this.name = name;
        this.jerseyNumber = jerseyNumber;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Name:" + name + " JerseyNumber: " + jerseyNumber + " Age " + age;
    }

}