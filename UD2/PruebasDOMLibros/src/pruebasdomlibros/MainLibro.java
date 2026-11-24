/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pruebasdomlibros;

import java.io.File;
import org.w3c.dom.Document;

/**
 *
 * @author 2DAM
 */
public class MainLibro {
    public static void main(String[] args) {
        File ficheroXML = new File("LibrosXML.xml");
        
      
        GestionarArbolLibro gestor = new  GestionarArbolLibro();
        
        Document resultado = gestor.abrirXMLDOM(ficheroXML);
        System.out.println(gestor.recorrerDOMyMostrar());
        gestor.annadirLibro("El Quijote", "Cervantes", "1605");
        System.out.println(gestor.recorrerDOMyMostrar());
        if(resultado !=null){
            System.out.println(resultado);
        }else{
            System.out.println("No se ha pordido cargar el archivo xml");
        }
                
        //Crear el fichero XML
        gestor.escribirXML("nuevoLibros.xml");
    }
    
}
