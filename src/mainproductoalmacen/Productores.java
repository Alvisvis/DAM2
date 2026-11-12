/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainproductoalmacen;

/**
 *
 * @author 2DAM
 */
public class Productores extends Thread {

    private Almacen almacen;
    private int id;

    public Productores(Almacen almacen, int id) {
        this.almacen = almacen;
        this.id = id;
    }

    @Override
    public void run() {
        int producto = 0;
        int cont = 10;
        while (cont != 0) {
            try {
                producto++;

                Thread.sleep((int) (Math.random() * 1000) + 800);

                System.out.println("Productor " + id + " fabrica producto " + producto);

                almacen.introducirProducto(producto, id);

                cont--;
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
        System.out.println("\n-------------------------------------\n"
                + "Productor " + id + " ha terminado de fabricar."
                        + "\n-------------------------------------\n");
    }
}
