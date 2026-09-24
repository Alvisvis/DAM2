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
//        ejecutablesWindows();
//        lanzarPins();

    }

    public static void lanzarPins() {
        Scanner sc = new Scanner(System.in);
        int op_;
        System.out.println("""
                           \u00bfA quien le quieres lanzar un Ping?
                           1- Microsoft 
                           2- Apple """);
        op_ = sc.nextInt();
        switch (op_) {
            case 1:
                try {
                    ProcessBuilder pb = new ProcessBuilder("ping", "-n", "4", "www.microsoft.com");
                    Process proceso = pb.start();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(proceso.getInputStream())
                    );
                    String linea;
                    int cont = 0;
                    while ((linea = reader.readLine()) != null) {

                        if (cont < 4) {
                            System.out.println(linea);
                            cont++;
                        }
                    }

                    int exitCode = proceso.waitFor();
                    System.out.println("El proceso termino con codigo: " + exitCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
                
            case 2:
                try {
                    ProcessBuilder pb = new ProcessBuilder("ping", "-n", "4", "www.apple.com");
                    Process proceso = pb.start();

                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(proceso.getInputStream())
                    );
                    String linea;
                    int cont = 0;
                    while ((linea = reader.readLine()) != null) {

                        if (cont < 4) {
                            System.out.println(linea);
                            cont++;
                        }
                    }
                    int exitCode = proceso.waitFor();
                    System.out.println("El proceso termino con codigo: " + exitCode);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
        }
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
                    ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir", "/b");
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
                    // Ejecutar 'ping' a google.com 3 veces
                    ProcessBuilder pb = new ProcessBuilder("whoami", "/user");
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
                
            case 3:
                try {
                    // Ejecutar 'ping' a google.com 3 veces
                    ProcessBuilder pb = new ProcessBuilder("ipconfig", "/all");
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
        }
    }

}
