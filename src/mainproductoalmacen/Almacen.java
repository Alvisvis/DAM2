/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainproductoalmacen;

/**
 *
 * @author 2DAM
 */
public class Almacen {

    private int[] productos = new int[5];

    private int entrada = 0;
    private int salida = 0;
    private int cantidad = 0;

    public synchronized void introducirProducto(int producto, int idProductor)
            throws InterruptedException {

        while (cantidad == 5) {
            System.out.println("Productor " + idProductor + ": Almacen lleno. Esperando...");
            wait();
        }

        productos[entrada] = producto;

        entrada = (entrada + 1) % 5;
        cantidad++;

        System.out.println("Productor " + idProductor + " deposita producto " + producto);

        System.out.println("Productos almacenados: " + cantidad);

        notifyAll();
    }

    public synchronized int retirar(int idConsumidor)
            throws InterruptedException {

        while (cantidad == 0) {
            System.out.println("Consumidor " + idConsumidor + ": Almacen vacio. Esperando...");

            wait();
        }

        int producto = productos[salida];

        salida = (salida + 1) % 5;
        cantidad--;

        System.out.println("Consumidor " + idConsumidor + " retira producto " + producto);

        System.out.println("Productos almacenados: " + cantidad);

        notifyAll();

        return producto;
    }
}
