/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectosandroidxml;

import java.io.File;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 * @author 2DAM
 */
public class GestorProyectosAndroid {
    Document doc;
    
    public Document abrirProyectosAndroid(File fichero){
        Document resultado = null;
        this.doc = null;
        
        try{
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringElementContentWhitespace(true);
            
            DocumentBuilder builder = factory.newDocumentBuilder();
            resultado = builder.parse(fichero);
            resultado.getDocumentElement().normalize();
        
            //asignacion al atributo
            this.doc = resultado;
        }catch (Exception e){
            System.out.println(e.getMessage());
            this.doc = null;
            
        }
       return resultado;
    }
    
    //Lee el XML y muestra por consola la lista de todos los id de proyecto y su título
    public List<String> listarIdsYTitulos(){
        List<String> result = new ArrayList<>();
        //acceder al elemento "proyecto" -> son muchos -> lista de nodos
        NodeList proyectos = doc.getElementsByTagName("proyecto"); //lista de nodos con los elementos "proyecto"
        for (int i = 0; i < proyectos.getLength() ; i++) {
            Element p = (Element)proyectos.item(i);
            String id = p.getAttribute("id");
            String titulo = "";
            NodeList tn1 = p.getElementsByTagName("titulo");
            if(tn1.getLength()>0){
                titulo = tn1.item(0).getTextContent().trim();                
            }
            result.add(id + " - " + titulo);
        }
        return result;
    }
    
    public String cuentaProyectosYCompruebaEntregados(){
        NodeList proyectos = doc.getElementsByTagName("proyecto");
        int total = proyectos.getLength();
        int entregadosTrue = 0;
        int entregadosFalse = 0;
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element p = (Element)proyectos.item(i);
            String entregado = p.getAttribute("entregado");
            
            if(entregado!=null){
                if (entregado.equalsIgnoreCase("true")) {
                    entregadosTrue++;
                }else if(entregado.equalsIgnoreCase("false")){
                    entregadosFalse++;
                }else{
                    //en caso de qe no ponga ni true ni false
                    entregadosFalse++;
                }
            }else{
                entregadosFalse++;
            }
        }
        return "Total: " + total + ", entregados a true: " + entregadosTrue + ", entregados a false: " + entregadosFalse;
    }
    
    public List<String> nombreYEmailDe (String idProyecto) {
        List<String> result = new ArrayList<>();
        NodeList proyectos = doc.getElementsByTagName("proyecto");
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element p = (Element) proyectos.item(i);
            if (idProyecto.equals(p.getAttribute("id"))) {
                NodeList alumnos = p.getElementsByTagName("alumno");
                if (alumnos.getLength() > 0) {
                    Element alumno = (Element) alumnos.item(0);
                    String nombre = "";
                    String email = "";
                    NodeList nn = alumno.getElementsByTagName("nombre");
                    nombre = nn.item(0).getTextContent().trim();
                    NodeList ne = alumno.getElementsByTagName("email");
                    email = ne.item(0).getTextContent().trim();
                    result.add(nombre);
                    result.add(email);
                }
            }
        }
        return result;
    }
    
    public List<String> listarArchivosDe (String idProyecto){
        List<String> listaDeArchivos = new ArrayList<>();
        NodeList proyectos = doc.getElementsByTagName("proyecto");
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element p = (Element)proyectos.item(i);
            if(idProyecto.equals(p.getAttribute("id"))){
                NodeList archivos = p.getElementsByTagName("archivo");
                for (int j = 0; j < archivos.getLength(); j++) {
                    listaDeArchivos.add(archivos.item(j).getTextContent().trim());
                }
            }
        }
        return listaDeArchivos;
    }
    
    public double notaMedia(){
        double resultado;
        NodeList proyectos = doc.getElementsByTagName("proyecto");
        double sum = 0.0;
        double count = 0;
        
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element p = (Element)proyectos.item(i);
            String notaStr = p.getAttribute("nota");
            if(!notaStr.isEmpty()){
                double nota = Double.parseDouble(notaStr);
                sum = sum +nota;
                count =  count +1;
            }
        }
        
        return sum / count;
    }
    
    public List<String> proyectosConMasDeUn8(){
        List<String> salida = new ArrayList<>();
        NodeList proyectos = doc.getElementsByTagName("proyecto");
        
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element  p = (Element)proyectos.item(i);
            String notaStr = p.getAttribute("nota");
            if(!notaStr.isEmpty()){
                double nota = Double.parseDouble(notaStr);
                String titulo = "";
                if(nota >= 8.0){
                    
                    NodeList titulos = p.getElementsByTagName("titulo");
                    titulo = titulos.item(0).getTextContent().trim();
                    salida.add(p.getAttribute("id") + " - " + titulo + " - " + nota);
                }
                
            }
        }
        return salida;
    }
    
    public List<String> filtradoKotlin() {
    List<String> salida = new ArrayList<>();
    NodeList proyectos = doc.getElementsByTagName("proyecto");

        for (int i = 0; i < proyectos.getLength(); i++) {
            Element p = (Element) proyectos.item(i);
            String lenguaje = p.getAttribute("lenguaje");

            if ("Kotlin".equalsIgnoreCase(lenguaje)) {
                String titulo = "";
                NodeList titulos = p.getElementsByTagName("titulo");

                if (titulos.getLength() > 0) {
                    titulo = titulos.item(0).getTextContent().trim();
                    salida.add(p.getAttribute("id") + " - " + titulo);
                }
            }
        }
        return salida;
    }
    
    public List<String> entregadosDespuesDe(LocalDate fechaEntrega){
        List<String> salida = new ArrayList<>();
        NodeList proyectos = doc.getElementsByTagName("proyecto");
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element p = (Element)proyectos.item(i);
            String entregado = p.getAttribute("entregado");
            boolean esEntregado = false;
            
            if (entregado.equalsIgnoreCase("true")) {
                esEntregado = true;
            }
            
            if(esEntregado){
                NodeList listaFechas = p.getElementsByTagName("fechaEntrega");
                String fechaEntregaStr = listaFechas.item(0).getTextContent().trim();
                LocalDate fechaEntregaConvertida = LocalDate.parse(fechaEntregaStr);
                if(fechaEntregaConvertida.isAfter(fechaEntrega)){
                    String titulo = "";
                    NodeList titulos = p.getElementsByTagName("titulo");
                    titulo = titulos.item(0).getTextContent().trim();
                    salida.add(p.getAttribute("id") + " - " + titulo + " - " + fechaEntregaStr);
                }
                
            }
        }
        return salida;
    }
    
    public List<String> titulosQueContienenSharePreferences(){
        List<String> salida = new ArrayList<>();
        NodeList proyectos = doc.getElementsByTagName("proyecto");
        for (int i = 0; i < proyectos.getLength(); i++) {
            Element p = (Element)proyectos.item(i);
            NodeList componentes = p.getElementsByTagName("componente");
            boolean usaShared = false;
            for (int j = 0; j < componentes.getLength(); j++) {
                String textoComponente = componentes.item(j).getTextContent();
                if (textoComponente.contains("SharedPreferences")) {
                    usaShared = true;
                }
            }
            if (usaShared) {
                NodeList titulos = p.getElementsByTagName("titulo");
                String titulo = titulos.item(0).getTextContent().trim();
                salida.add(p.getAttribute("id") + " - " + titulo);
            }
            
        }
        return salida;
    }
}

