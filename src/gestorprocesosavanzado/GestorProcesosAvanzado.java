/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package gestorprocesosavanzado;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author 2DAM
 */
public class GestorProcesosAvanzado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Lanzamos todos los procesos
        Process dir = lanzarDir();
        Process whoami = lanzarWhoami();
        Process ipconfig = lanzarIpconfig();
        Process pingMicrosoft = lanzarPingMicro();
        Process pingApple = lanzarPingApple();

        // Esperamos
        try {
            dir.waitFor();
            whoami.waitFor();
            ipconfig.waitFor();
            pingMicrosoft.waitFor();
            pingApple.waitFor();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lanzarEco();
    }

    public static void lanzarEco() {
        try {
            String java = System.getProperty("java.home") + "\\bin\\java";
            String classpath = System.getProperty("java.class.path");

            ProcessBuilder pb = new ProcessBuilder(java, "-cp", classpath, "EcoDatos");

            Process proceso = pb.start();
            BufferedWriter wr = new BufferedWriter(
                    new OutputStreamWriter(proceso.getOutputStream()));

            wr.write("Hola EcoDatos");
            wr.newLine();

            wr.close();

            BufferedReader le = new BufferedReader(new InputStreamReader(proceso.getInputStream()));

            String linea;
            while ((linea = le.readLine()) != null) {
                System.out.println(linea);
            }

            le.close();
            int codigo = proceso.waitFor();
            System.out.println("EcoDatos terminó: " + codigo);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error " + e.getMessage());
        }
    }

    private static Process lanzarDir() {
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

            return proceso;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Process lanzarIpconfig() {
        try {
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

            return proceso;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Process lanzarWhoami() {
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

            return proceso;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lanza ping a www.microsoft.com
     *
     * @return proceso
     */
    public static Process lanzarPingMicro() {
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
            return proceso;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Lanza ping a www.apple.com
     *
     * @return proceso
     */
    public static Process lanzarPingApple() {
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
            return proceso;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
