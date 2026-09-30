/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gestorprocesosavanzado;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author 2DAM
 */
public class EcoDatos {

    public static void main(String[] args) {
        mayusTexto();
    }
    public static void mayusTexto() {
        try {
            BufferedReader entrada = new BufferedReader(new InputStreamReader(System.in));

            String linea;

            while ((linea = entrada.readLine()) != null) {
                System.out.println(linea.toUpperCase());
            }

            entrada.close();
        } catch (IOException e) {
            System.out.println("Error en EcoDatos: " + e.getMessage());
        }
    }
}
