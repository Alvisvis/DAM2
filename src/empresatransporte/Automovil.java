/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresatransporte;

/**
 *
 * @author 2DAM
 */
public class Automovil extends Vehiculo{

    private int numeroPasajero;
    
    public Automovil(String marca, String matricula, int anioFabricacion, int numeroPasajero) {
        super(marca, matricula, anioFabricacion);
        this.numeroPasajero = numeroPasajero;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return kilometros *= 0.20;
    }
}
