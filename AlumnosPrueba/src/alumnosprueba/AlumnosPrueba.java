/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package alumnosprueba;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
public class AlumnosPrueba {
    private int id;
    private String nombre;
    private String apellido;
    private double nota;
    private String curso;
    
    public AlumnosPrueba(int id, String nombre, String apellido, double nota, String curso){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nota = nota;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public double getNota() {
        return nota;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
    
    
    public static void eliminarAlumno(GestorConexion gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Escribe un nombre:");
        String alumno = sc.nextLine();

        try {
            ResultSet datosAlumnos = gestor.datosAlumnos();

            while (datosAlumnos.next()) {
                if (datosAlumnos.getString("nombre").equals(alumno)) {
                    datosAlumnos.deleteRow();
                }
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
    
    public static void mostrarAlumnos(GestorConexion gestor) {
        try {
            ResultSet datosAlumnos = gestor.datosAlumnos();
            while (datosAlumnos.next()) {
                System.out.println(datosAlumnos.getString("nombre"));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    
   

    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*GestorConexion gestor = new GestorConexion();
        ResultSet datosAlumnos = gestor.datosAlumnos();
        try{
            while (datosAlumnos.next()) {
                String nombre = datosAlumnos.getString("nombre");
                System.out.println(nombre);
            }
            eliminarAlumno(gestor);
        }catch(SQLException e){
            e.getMessage();
        }*/
        
        GestorConexion gestor = new GestorConexion();
       
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la nota de corte");
        double notaCorte =  sc.nextDouble();
        sc.nextLine();
        System.out.println("Introduce el curso");
        String curso =  sc.nextLine();
        
        ResultSet alumnosAprobados = gestor.alumnosAprobados(notaCorte,curso);
        try{
            while (alumnosAprobados.next()){
                String aprobados = alumnosAprobados.getString("nombre") + " " +alumnosAprobados.getDouble("nota");
                System.out.println(aprobados);
            }
        }catch(SQLException e){
             e.getMessage();
        }
        
        
    }
    
}

