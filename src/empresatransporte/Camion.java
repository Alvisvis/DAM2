/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresatransporte;

/**
 *
 * @author 2DAM
 */
public class Camion extends Vehiculo{

    private int capacidad;
    
    public Camion(String marca, String matricula, int anioFabricacion, int capacidad) {
        super(marca, matricula, anioFabricacion);
        this.capacidad = capacidad;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return (kilometros * 0.35) + (10*capacidad);
    }
    
}
