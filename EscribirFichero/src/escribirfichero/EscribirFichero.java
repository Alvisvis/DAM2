/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package escribirfichero;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author 2DAM
 */
public class EscribirFichero {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        //Añadir todas las fechas de 2025 al fichero
//     String contenido = "Visita a la ETSII para curso de Godot";
//     File archivo = new File("fechas.txt");
//     FileWriter escritor = new FileWriter(archivo,true);
//     escritor.write(contenido);
//     System.out.println("Texto escrito correctamente");
//     escritor.close();
     
     int anio = 2025;
     for(int mes =1; mes<=12; mes++){
         for(int dia = 30; dia<=30; dia++){
            String diaStr;
            if (dia < 10) {
                diaStr = "0" + dia;
            } else {
                diaStr = "" + dia;
            }
            
            String mesStr;
            if (mes < 10) {
                mesStr = "0" + mes;
            } else {
                mesStr = "" + mes;
            }
            String fecha = diaStr + "/" + mesStr + "/" + anio;
         }
     }
      //Con el .appendd, poner bien
     
     
     
    }
    
}
