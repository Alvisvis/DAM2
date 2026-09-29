/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package negocio;

import java.util.ArrayList;

/**
 *
 * @author 2DAM
 */
public class Negocio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Cliente cl = new Cliente("Alvis", "64654174", "alvivis@gmail.com", 1);
        Cliente c2 = new Cliente("Jose", "4877216", "Josejojo@gmail.com", 2);
        System.out.println(cl.toString());
        System.out.println(c2.toString());

        Producto p1 = new Producto(1, "Camisa de Quevedo", 50, "Camisa");
        Producto p2 = new Producto(2, "DTMF", 50, "Vinilo");
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        
        ArrayList<Producto> productos = new ArrayList();
        productos.add(p1);
        productos.add(p2);

        Pedido q1 = new Pedido(cl, p2);

        System.out.println(q1.toString());
    }

}
