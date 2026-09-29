/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import java.time.LocalDate;

/**
 *
 * @author 2DAM
 */
public class Pedido {

    private Cliente cliente;
    private Producto producto;
    private LocalDate fecha;

    public Pedido(Cliente cliente, Producto producto) {
        this.cliente = cliente;
        this.producto = producto;
        this.fecha = LocalDate.now();
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

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pedido");
        sb.append("\nCliente: ").append(cliente.getCodCliente());
        sb.append("\nProducto: ").append(producto.getNombrePro());
        sb.append("\nFecha: ").append(fecha);
        return sb.toString();
    }
    
    
    
}
