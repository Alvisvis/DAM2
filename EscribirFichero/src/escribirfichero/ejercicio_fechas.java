/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package escribirfichero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 2DAM
 */
public class ejercicio_fechas {
    public static void main(String[] args) throws IOException {
     String contenido = "Visita a la ETSII para curso de Godot";
     File archivo = new File("archivo.txt");
     FileWriter escritor = new FileWriter(archivo);
     escritor.write(contenido);
     System.out.println("Texto escrito correctamente");
     escritor.close();
    }
    
}
