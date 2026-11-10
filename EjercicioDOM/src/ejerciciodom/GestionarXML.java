/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejerciciodom;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author 2DAM
 */
public class GestionarXML {
    
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
   
   //ej1
   
   public String mostrarIdYTitulo() {
        String salida = "";
        String[] datosProyecto;

        Node nodoProyectos = this.doc.getFirstChild();
        NodeList listaProyectos = nodoProyectos.getChildNodes();

        for (int i = 0; i < listaProyectos.getLength(); i++) {
            Node nodoProyecto = listaProyectos.item(i);

            if (nodoProyecto.getNodeType() == Node.ELEMENT_NODE) {
                datosProyecto = procesarProyecto(nodoProyecto);

                salida = salida + "\n ID: " + datosProyecto[0];
                salida = salida + "\n El título es: " + datosProyecto[1];
                salida = salida + "\n ----------------";
            }
        }

        return salida;
    };
   
   
   private String[] procesarProyecto(Node proyecto) {
        String[] datos = new String[2];
        datos[0] = "";
        datos[1] = "";

        Node atributo = proyecto.getAttributes().getNamedItem("id");
        datos[0] = atributo.getNodeValue();

        NodeList hijos = proyecto.getChildNodes();
        for (int i = 0; i < hijos.getLength(); i++) {
            Node hijo = hijos.item(i);

            if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                String nombre = hijo.getNodeName();

                if (nombre.equals("titulo")) {
                    datos[1] = hijo.getTextContent();
                }
            }
        }

        return datos;
    }
   
   
   
   
   
   //ej2
    public String contarProyectos() {
        int total = 0;
        int entregados = 0;
        int noEntregados = 0;
        String salida = "";
        String[] datosProyecto;

        Node nodoProyectos = this.doc.getFirstChild();
        NodeList listaProyectos = nodoProyectos.getChildNodes();

        for (int i = 0; i < listaProyectos.getLength(); i++) {
            Node nodoProyecto = listaProyectos.item(i);

            if (nodoProyecto.getNodeType() == Node.ELEMENT_NODE) {
                total++;
                datosProyecto = procesarProyectoEntregado(nodoProyecto);

                if (datosProyecto[0].equals("true")) {
                    entregados++;
                } else {
                    noEntregados++;
                }
            }
        }

        salida = salida + "\nTotal de proyectos: " + total;
        salida = salida + "\nProyectos entregados: " + entregados;
        salida = salida + "\nProyectos no entregados: " + noEntregados;

        return salida;
    }
   
    private String[] procesarProyectoEntregado(Node proyecto) {
        String[] datos = new String[1];
        datos[0] = "";
        Node atributo = proyecto.getAttributes().getNamedItem("entregado");
        datos[0] = atributo.getNodeValue();
        return datos;
    }
    
    
    //ej3
    public String buscarAlumno(){
        String salida = "";
        String[] datosProyecto;
        
        Node nodoProyectos = this.doc.getFirstChild();
        NodeList listaProyectos = nodoProyectos.getChildNodes();

        for (int i = 0; i < listaProyectos.getLength(); i++) {
            Node nodoProyecto = listaProyectos.item(i);

            if (nodoProyecto.getNodeType() == Node.ELEMENT_NODE) {
                Node atributo = nodoProyecto.getAttributes().getNamedItem("id");

                if (atributo.getNodeValue().equals("P002")) {
                    datosProyecto = procesarAlumno(nodoProyecto);

                    salida = salida + "\nNombre del alumno: " + datosProyecto[0];
                    salida = salida + "\nEmail del alumno: " + datosProyecto[1];
                }
            }
        }
        
        return salida;
    }
    
    private String[] procesarAlumno(Node proyecto){
        String[] datos = new String[2];
        datos[0] = "";
        datos[1] = "";
        
        NodeList hijos = proyecto.getChildNodes();

        for (int i = 0; i < hijos.getLength(); i++) {
            Node hijo = hijos.item(i);
            if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                if (hijo.getNodeName().equals("alumno")) {
                    datos[0] = hijo.getChildNodes().item(1).getTextContent();
                    datos[1] = hijo.getChildNodes().item(3).getTextContent();
                }
            }
        }
        return datos;
    }
    
    
    
    //ej4
    public String listarArchivos(){
        String salida = "";
        String[] datosProyecto;
        
        Node nodeProyectos = this.doc.getFirstChild();
        NodeList listaProyectos = nodeProyectos.getChildNodes();
        
        for (int i = 0; i < listaProyectos.getLength(); i++) {
            Node nodoProyecto = listaProyectos.item(i);
            
            if (nodoProyecto.getNodeType() == Node.ELEMENT_NODE) {
                Node atributo = nodoProyecto.getAttributes().getNamedItem("id");
                
                if (atributo.getNodeValue().equals("P001")){
                    datosProyecto = procesarArchivos(nodoProyecto);

                    salida = salida + "\nArchivos del proyecto P001:";
                    salida = salida + "\n" + datosProyecto[0];
                    salida = salida + "\n" + datosProyecto[1];
                }
            }
        }
        return salida;
    }
    
    private String[] procesarArchivos(Node proyecto) {
        String[] datos = new String[2];
        datos[0] = "";
        datos[1] = "";

        NodeList hijos = proyecto.getChildNodes();

        for (int i = 0; i < hijos.getLength(); i++) {
            Node hijo = hijos.item(i);
            if (hijo.getNodeType() == Node.ELEMENT_NODE) {
                if (hijo.getNodeName().equals("meta:archivos")) {
                    NodeList archivos = hijo.getChildNodes();
                    for (int j = 0; j < archivos.getLength(); j++) {
                        Node archivo = archivos.item(j);
                        if (archivo.getNodeType() == Node.ELEMENT_NODE) {
                            if (archivo.getNodeName().equals("archivo")) {
                                if (datos[0].equals("")) {
                                    datos[0] = archivo.getTextContent();
                                } else {
                                    datos[1] = archivo.getTextContent();
                                }
                            }
                        }
                    }
                }
            }
        }
        return datos;
    }
    
    
    
    
    //ej5 // Calcula la nota media de todos los proyectos que sí tienen nota (ignora cadenas vacías). 

    //ej5
    public String calcularMedia() {
        double suma = 0;
        int contador = 0;
        String salida = "";
        String[] datosProyecto;

        Node nodoProyectos = this.doc.getFirstChild();
        NodeList listaProyectos = nodoProyectos.getChildNodes();

        for (int i = 0; i < listaProyectos.getLength(); i++) {
            Node nodoProyecto = listaProyectos.item(i);

            if (nodoProyecto.getNodeType() == Node.ELEMENT_NODE) {
                datosProyecto = procesarMedia(nodoProyecto);

                if (!datosProyecto[0].equals("")) {
                    suma = suma + Double.parseDouble(datosProyecto[0]);
                    contador++;
                }
            }
        }

        double media = suma / contador;
        
        salida = salida + "\nLa media de las notas es: " + media;
        return salida;
    }
    
    private String[] procesarMedia(Node proyecto){
        String[] datos = new String[1];
        datos[0] = "";

        Node atributo = proyecto.getAttributes().getNamedItem("nota");
        datos[0] = atributo.getNodeValue();

        return datos;
    }
    
    
    //ej6
    
   
    
}
