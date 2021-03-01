package com.example.demo;

class Player{

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