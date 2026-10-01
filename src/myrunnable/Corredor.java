/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package myrunnable;

/**
 *
 * @author 2DAM
 */
public class Corredor implements Runnable {

    private int cont = 1;
    private String name;

    public Corredor() {
    }

    public Corredor(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (cont > 0 && cont < 6) {
            System.out.println("Corredor: " + name + " " + cont);
            cont++;
        }
    }

    public static void main(String[] args) {
        Corredor corre1 = new Corredor("Pepe");
        Corredor corre2 = new Corredor("Ana");
        System.out.println("Comienza la cuenta!");

        Thread hilo1 = new Thread(corre1);
        Thread hilo2 = new Thread(corre2);

        hilo1.start();
        hilo2.start();
    }
}
