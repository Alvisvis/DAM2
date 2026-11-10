/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciodom;

import java.io.File;
import org.w3c.dom.Document;

/**
 *
 * @author 2DAM
 */
public class Main {
    public static void main(String[] args) {
        File ficheroXML = new File("proyectosAndroid.xml");
        
        GestionarXML gestor = new GestionarXML();
        
        Document resultado = gestor.abrirXMLDOM(ficheroXML);
        System.out.println(gestor.mostrarIdYTitulo()); //ej1
        System.out.println(gestor.contarProyectos()); //ej2
        System.out.println(gestor.buscarAlumno()); //ej3
        System.out.println(gestor.listarArchivos()); //ej4
        System.out.println(gestor.calcularMedia()); //ej5
        
        if(resultado != null){
            System.out.println(resultado);
        }else{
            System.out.println("No se ha podido cargar el archivo xml");
        }
        
    }
    
}
