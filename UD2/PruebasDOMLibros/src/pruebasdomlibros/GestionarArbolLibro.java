/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pruebasdomlibros;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


/**
 *
 * @author 2DAM
 */
public class GestionarArbolLibro {

    Document doc;
   public Document abrirXMLDOM(File fichero){
       Document resultado = null;
       this.doc = null;
       
       try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            factory.setIgnoringElementContentWhitespace(true);

            DocumentBuilder builder = factory.newDocumentBuilder();
            resultado = builder.parse(fichero);
           this.doc = resultado;
       }catch(Exception e){
           e.getMessage();
           this.doc = null;
       }
        return resultado;
       
   }
   
   public String recorrerDOMyMostrar(){
       String salida ="";
       String[] datosLibro;
       Node nodoLibros = this.doc.getFirstChild(); //Obtiene el primer odo del DOM (primer hijo)
       
       NodeList listaLibros = nodoLibros.getChildNodes(); // obtiene una lista de nodos con todos los nodos hijos del raiz
       for (int i = 0; i < listaLibros.getLength(); i++) { //procesa todo los nodos hijos
           Node nodoLibro = listaLibros.item(i);
           if (nodoLibro.getNodeType()==Node.ELEMENT_NODE) {
               datosLibro = procesarLibro(nodoLibro);
               salida = salida + "\n Publicado en: " + datosLibro[0];
               salida = salida + "\n El autor es: " + datosLibro[2];
               salida = salida + "\n El título es: " + datosLibro[1];
               salida = salida + "\n ----------------";
           }
       }
       
       return salida;
   }
   
   private String[] procesarLibro(Node libro){
       String[] datos = new String[3];
       datos[0] = "";
       datos[1] = "";
       datos[2] = "";
       
       Node atributo = libro.getAttributes().getNamedItem("publicado_en");
       datos[0] = atributo.getNodeValue();
       
       NodeList hijos = libro.getChildNodes();
       for (int i = 0; i < hijos.getLength(); i++) {
           Node hijo = hijos.item(i);
           if (hijo.getNodeType()==Node.ELEMENT_NODE) {
               String nombre = hijo.getNodeName();
               if(nombre.equals("Titulo")){
                   datos[1] = hijo.getTextContent();
               }
               if(nombre.equals("Autor")){
                   datos[2] = hijo.getTextContent();
               }
           }
          
       }
       return datos;
   }
   
   public void annadirLibro(String titulo, String autor, String publicado){
       //crear nodo libro
       Element nodoLibro = this.doc.createElement("Libro");
       //crear atributo
       nodoLibro.setAttribute("publicado_en", publicado);
       
       //obtener el nodo raiz
       Node nodoLibroas = this.doc.getDocumentElement();
       
       
       //crear nodo titulo
       Node nodoTitulo = this.doc.createElement("Titulo");
       nodoLibro.appendChild(nodoTitulo);
       Node textoTitulo = this.doc.createTextNode(titulo);
       nodoTitulo.appendChild(textoTitulo);
       
       Node nodoAutor = this.doc.createElement("Autor");
       nodoLibro.appendChild(nodoAutor);
       nodoAutor.setTextContent(autor); //otra forma mas sencilla de ponerle texto
       
       //agregar el libro al arbol
       nodoLibroas.appendChild(nodoLibro);
       // o quitando la linea de arriba y poner:
       //this.doc.getDocumentElement().appendChild(nodoLibro);
       
   }
    
}
