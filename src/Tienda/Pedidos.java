/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda;

import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author 2DAM
 */
public class Pedidos {

    private Cliente cliente;
    private Producto producto;
    private GregorianCalendar fecha = new GregorianCalendar();

    public Pedidos(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = new GregorianCalendar(Locale.ITALY);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }
    
    
    
}
