/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda;

/**
 *
 * @author 2DAM
 */
public class Producto {
    
    private int codProducto;
    private String nombrePro;
    private double cantidadPro;
    private String tipoPro;

    public Producto(int codProducto, String nombrePro, double cantidadPro, String tipoPro) {
        this.codProducto = codProducto;
        this.nombrePro = nombrePro;
        this.cantidadPro = cantidadPro;
        this.tipoPro = tipoPro;
    }

    public int getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(int codProducto) {
        this.codProducto = codProducto;
    }

    public String getNombrePro() {
        return nombrePro;
    }

    public void setNombrePro(String nombrePro) {
        this.nombrePro = nombrePro;
    }

    public double getCantidadPro() {
        return cantidadPro;
    }

    public void setCantidadPro(double cantidadPro) {
        this.cantidadPro = cantidadPro;
    }

    public String getTipoPro() {
        return tipoPro;
    }

    public void setTipoPro(String tipoPro) {
        this.tipoPro = tipoPro;
    }
    
    public double precio(String tipoPro) {
        double precio = 0.0;
        
        if (tipoPro.contains("Vinilo")) {
            precio = 20.0;
        } else if (tipoPro.contains("Tocadiscos")) {
            precio = 60.0;
        }else if (tipoPro.contains("Camisas")) {
            precio = 12.0;
        }
        return precio;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Producto{");
        sb.append("codProducto=").append(codProducto);
        sb.append(", nombrePro=").append(nombrePro);
        sb.append(", cantidadPro=").append(cantidadPro);
        sb.append(", tipoPro=").append(tipoPro);
        sb.append('}');
        return sb.toString();
    }
    
    
}
