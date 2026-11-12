/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainproductoalmacen;

/**
 *
 * @author 2DAM
 */
public class MainProductoAlmacen {

    public static void main(String[] args) {

        Almacen a = new Almacen();

        for (int i = 1; i < 10; i++) {
            Productores p = new Productores(a, i);
            Consumidor c = new Consumidor(a, i);
            
            p.start();
            c.start();

        }
    }

}
