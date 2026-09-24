/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package procesos;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author 2DAM
 */
public class Procesos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            String comando = "ping -n 2 www.google.com";

            ProcessBuilder pb = new ProcessBuilder("ping", "-n", "2", "www.google.com");
            Process proceso = pb.start();

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(proceso.getInputStream())
            );
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            int exitCode = proceso.waitFor();
            System.out.println("El proceso termino con codigo: " + exitCode);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            String comando = "notepad.exe";

            Process[] procesos = new Process[3];

            for (int i = 0; i < procesos.length; i++) {
                procesos[i] = Runtime.getRuntime().exec(comando);
                System.out.println("Proceso " + (i + 1) + " lanzado");
            }

            for (int i = 0; i < procesos.length; i++) {
                int exitVal = procesos[i].waitFor();
                System.out.println("Proceso " + (i + 1) + " termino con estado " + exitVal);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
