/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainproductoalmacen;

/**
 *
 * @author 2DAM
 */
public class Consumidor extends Thread {

    private Almacen almacen;
    private int id;

    public Consumidor(Almacen almacen, int id) {
        this.almacen = almacen;
        this.id = id;
    }

    @Override
    public void run() {
        int cont = 10;

        while (cont != 0) {
            try {
                int producto = almacen.retirar(id);

                Thread.sleep((int) (Math.random() * 1000) + 800);

                System.out.println("Consumidor " + id + " consume producto " + producto);
                cont--;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("""
                           
                           -------------------------------------
                           Consumidor """ + id + " ha terminado de consumir."
                + "\n-------------------------------------\n");
    }
}
