/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package carrera;

/**
 *
 * @author 2DAM
 */
public class Coche extends Thread {

    private String nombre;
    private int dorsal;
    private int distancia;

    public Coche(String nombre, int dorsal, int distancia) {
        this.nombre = nombre;
        this.dorsal = dorsal;
        this.distancia = distancia;
    }

    @Override
    public void run() {
        while (distancia < 21) {
            if (distancia == 20) {
                System.out.println("Meta: [" + dorsal + "] " + nombre);
                break;
            }
            System.out.println("[" + dorsal + "] " + nombre + " - posición " + distancia);
            distancia++;

        }

    }

}
