/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author ruben
 */
public class Item {
    private int id_item;
    private int cantidad;
    private Articulo articulo;
    private Double subtotal;
    
    public Item(){}

    public Item(int id_item, int cantidad, Articulo articulo, Double subtotal) {
        this.id_item = id_item;
        this.cantidad = cantidad;
        this.articulo = articulo;
        this.subtotal = subtotal;
    }

    public int getId_item() {
        return id_item;
    }

    public void setId_item(int id_itrem) {
        this.id_item = id_item;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.cantidad = Cantidad;
    }

    public Articulo getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulo articulo) {
        this.articulo = articulo;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }
    
    
    
}
