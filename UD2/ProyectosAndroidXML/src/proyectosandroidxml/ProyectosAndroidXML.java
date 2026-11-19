/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectosandroidxml;

import java.io.File;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author 2DAM
 */
public class ProyectosAndroidXML {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            File xmlFile = new File("proyectosAndroid.xml");
            
            GestorProyectosAndroid gestor = new GestorProyectosAndroid();
            
            //abrir el fichero
            gestor.abrirProyectosAndroid(xmlFile);
            
            //1. Listar id y titulo
            System.out.println("Ejercicio 1: ids y títulos ---------------------");
            List<String> idsYtitulos = gestor.listarIdsYTitulos();
            for (String s: idsYtitulos) {
                System.out.println(s);
                
            }
            
            //2. Contar y mostrar entregados
            System.out.println("Ejercicio 2: entregados ------------------------");
            String cuenta = gestor.cuentaProyectosYCompruebaEntregados();
            System.out.println(cuenta);
            
            //3. nombre y email
            System.out.println("Ejercicio 3: nombre y email --------------------");
            List<String> nombreEmail = gestor.nombreYEmailDe("P002");
            System.out.println("Nombre: "+ nombreEmail.get(0));
            System.out.println("Email: "+ nombreEmail.get(1));
        
            //4. listar todos los archivos
            System.out.println("Ejercicio 4: listar archivos -------------------");
            List<String> archivos = gestor.listarArchivosDe("P001");
            for (String a: archivos) {
                System.out.println(a);
            }

            //5. Calcula la nota media de todos los proyectos que sí tienen nota (ignora cadenas vacías). 
            System.out.println("Ejercicio 5: nota media de los proyectos -------------------");            
            double media = gestor.notaMedia();
            System.out.println(media);
            
            //6. Poryectos con mas de un 8
            System.out.println("Ejercicio 6: poryectos con mas de un 8 -------------------");            
            List<String> lista8 = gestor.proyectosConMasDeUn8();
            for (String s: lista8) {
                System.out.println(s);
            }
            
            //7. Proyectos kotlin
            System.out.println("Ejercicio 7: proyectos kotlin -------------------");            
            List<String> kotlin = gestor.filtradoKotlin();
            for (String k: kotlin) {
                System.out.println(k);
            }
            
            //8. Poryectos entregados despues de
            System.out.println("Ejercicio 8: Entrega desués de -------------------");            
            LocalDate fecha = LocalDate.of(2025,10,24);
            List<String> entregadosDespues = gestor.entregadosDespuesDe(fecha);
            for (String f: entregadosDespues) {
                System.out.println(f);
            }
            
            //9. Contiene sharedPreferences
            System.out.println("Ejercicio 9: Contiene sharedPreferences -------------------");            
            List<String> shared = gestor.titulosQueContienenSharePreferences();
            for (String s: shared) {
                System.out.println(s);
            }
            
            
        }catch(Exception e){
           e.getMessage();
        }
    }
    
}
