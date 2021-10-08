package com.m1_testing_ioan_stirbu.project.poo.javaSE.app;

public class Ordenador {
    protected String color;
    protected Double tamanio;


    public Ordenador(){}


    public Ordenador(String color, Double tamanio) {
        this.setColor(color);
        this.tamanio = tamanio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getTamanio() {
        return tamanio;
    }

    public void setTamanio(Double tamanio) {
        this.tamanio = tamanio;
    }

    @Override
    public String toString() {
        return "Ordenador{" +
                "color='" + getColor() + '\'' +
                ", tamanio=" + tamanio +
                '}';
    }
}
