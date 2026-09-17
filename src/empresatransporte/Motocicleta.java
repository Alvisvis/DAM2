/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empresatransporte;

/**
 *
 * @author 2DAM
 */
public class Motocicleta extends Vehiculo{

    private int cilindrada;
    
    public Motocicleta(String marca, String matricula, int anioFabricacion, int cilindrada) {
        super(marca, matricula, anioFabricacion);
        this.cilindrada = cilindrada;
    }

    @Override
    public double calcularCostoViaje(double kilometros) {
        return kilometros *= 0.10;
    }
    
}
