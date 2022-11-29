/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ruben
 */
public class Articulo {
    private int id_articulo;
    private String nombre;
    private Double precio;
    
    public Articulo(){}

    public Articulo(int id_articulo, String nombre, Double precio) {
        this.id_articulo = id_articulo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

     
    
}
