/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorprocesosavanzado;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
public class GestorProcesosAvanzado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    public static void ejecutablesWindows() {
        Scanner sc = new Scanner(System.in);
        int op_;
        System.out.println("""
                           \u00bfQue utilidad quieres usar?
                           1- cmd/c dir/b 
                                (ejecuta un listado simple de archivos)
                           2- whoami /user 
                                (muestra el usuario actual)
                           3- ipconfig /all 
                                (muestra la configuracion de red completa)""");
        op_ = sc.nextInt();

        switch (op_) {
            case 1:
                try {
                    // Ejecutar 'ping' a google.com 3 veces
                    ProcessBuilder pb = new ProcessBuilder("ping", "-n", "3", "www.google.com");
                    Process proceso = pb.start();

                    // Leer la salida del comando
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(proceso.getInputStream())
                    );
                    String linea;
                    while ((linea = reader.readLine()) != null) {
                        System.out.println(linea);
                    }

                    int exitCode = proceso.waitFor();
                    System.out.println("El proceso terminó con código: " + exitCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case 2:
                try {
                    // Abrir el Bloc de notas
                    Process proceso = Runtime.getRuntime().exec("notepad.exe");

                    // Esperar a que el usuario cierre el Bloc de notas
                    proceso.waitFor();

                    System.out.println("El proceso Notepad ha terminado.");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            case 3:
                try {
                    // Abrir el Bloc de notas
                    Process proceso = Runtime.getRuntime().exec("notepad.exe");

                    // Esperar a que el usuario cierre el Bloc de notas
                    proceso.waitFor();

                    System.out.println("El proceso Notepad ha terminado.");
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            default:
                throw new AssertionError();
        }
    }

}
