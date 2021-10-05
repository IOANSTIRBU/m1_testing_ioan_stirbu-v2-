package com.project.poo.javaSE.App.Class;

import com.project.poo.javaSE.App.Ordenador;

import java.util.List;


/*
* Clase/Atributos
* */
public class Periferico extends Ordenador {
    private String titulo;
    private Double precio;
    private Boolean promocion;
    private List<String>perifericos;

//Constructor vacio
    public Periferico() {
    }
//Constructor con parametros
    public Periferico(String color,Double tamanio,String titulo, Double precio,Boolean promocion,List<String>perifericos) {
        super(color,tamanio);
        this.titulo = titulo;
        this.precio = precio;
        this.promocion = promocion;
        this.perifericos = perifericos;
    }

    //Gets y Sets
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }


    public boolean isPromocion() {
        return promocion;
    }

    public void setPromocion(boolean promocion) {
        this.promocion = promocion;
    }

    public List<String> getPerifericos() {
        return perifericos;
    }

    public void setPerifericos(List<String> perifericos) {
        this.perifericos = perifericos;
    }

    /*
    * Metodos
    * */
    //Aqui tambien si el precio esta por debajo no hacerle promocion y si esta por arriba hacerle promocion
    /*public int calcularPrecio(){
        int precio = 0;
            if(precio <= 50){
            //promocion = false;
                System.out.println("Tu periferico no esta en promocion");
            }else if(precio > 60 || precio <= 100){
           // promocion = true;
                System.out.println("Tu periferico esta en promocion");
            }

        return precio;
    }*/
//Aqui queria hacer que calcule el precio y el descuento pero no lo consegui hacer es decir no me ha salido como deberia ser
    /*public void calcularDescuento(){
        int precio = 0;
        double descuento = 0;
        if(precio > 50 && precio < 20) {
            descuento = precio * 0.5;
            System.out.println("");
        }else if(precio < 40 )
            descuento = precio * 0.20;
        System.out.println("El precio con descuento es : " + descuento);

    }*/

    @Override
    public String toString() {
        return "Periferico{" +
                "titulo='" + titulo + '\'' +
                ", precio=" + precio +
                ", Extra de perifericos elegidos=" + perifericos +
                ", color =" + super.getColor() +
                ", tamanio =" + super.getTamanio() +


        '}';
    }
}

