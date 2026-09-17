/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresatransporte;

/**
 *
 * @author 2DAM
 */
public abstract class Vehiculo {

    private String marca;
    private String matricula;
    private int anioFabricacion;

    public Vehiculo(String marca, String matricula, int anioFabricacion) {
        this.marca = marca;
        this.matricula = matricula;
        this.anioFabricacion = anioFabricacion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public abstract double calcularCostoViaje(double kilometros);

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Marca: ").append(marca);
        sb.append("\nMatricula: ").append(matricula);
        sb.append("\tAño de fabricacion: ").append(anioFabricacion);
        return sb.toString();
    }

}
