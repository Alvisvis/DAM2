/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package negocio;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 2DAM
 */
public class Negocio {

    public static void main(String[] args) {
        ConexionSQL gestor = new ConexionSQL();

//        selectDefault(gestor);
//        selectPersonalizado(gestor);
//        updateDefault(gestor);
//        eliminarCliente(gestor);
//        insertarCliente(gestor);

        gestor.cerrarConexion();

    }

    /**
     * Metodo que muestra los nombre de los clientes de la tabla Cliente
     *
     * @param gestor
     */
    public static void selectDefault(ConexionSQL gestor) {
        ResultSet tiendaMusica = gestor.selectTienda();
        try {
            while (tiendaMusica.next()) {
                String nombreCliente = tiendaMusica.getString("nombreCli");
                System.out.println(nombreCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo que muestra los datos que pidas de la tabla que digas
     *
     * @param gestor
     */
    public static void selectPersonalizado(ConexionSQL gestor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¿Que tipo de la tabla quieres seleccionar?");
        String tipo = sc.next();

        System.out.println("¿Cual es la tabla?");
        String tabla = sc.next();
        ResultSet tiendaMusica = gestor.pedirDatos(tipo, tabla);

        try {
            while (tiendaMusica.next()) {
                String nombreCliente = tiendaMusica.getString(tipo);
                System.out.println(nombreCliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateDefault(ConexionSQL gestor) {
        ResultSet tiendaMusica = gestor.selectTienda();
        System.out.println("Entra 1");
        try {
            while (tiendaMusica.next()) {

                System.out.println("Entra 2");
                String nombreCli = tiendaMusica.getString("nombreCli");
                System.out.println(nombreCli);
                int numVinilosReservado = tiendaMusica.getInt("numVinilosReservado");
                System.out.println(numVinilosReservado);

                if (tiendaMusica.getString("nombreCli").equals("Juan Antonio")) {
                    tiendaMusica.updateInt("numVinilosReservado", 2);
                    tiendaMusica.updateRow();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void eliminarCliente(ConexionSQL gestor) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el nombre del cliente que quieres eliminar:");
        String nombre = sc.nextLine();

        gestor.eliminarCliente(nombre);
    }

    public static void insertarCliente(ConexionSQL gestor) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Introduce el ID del cliente:");
        int idCliente = sc.nextInt();

        sc.nextLine();

        System.out.println("Introduce el nombre del cliente:");
        String nombreCli = sc.nextLine();

        System.out.println("Introduce el teléfono:");
        String telefono = sc.nextLine();

        System.out.println("Introduce el correo electrónico:");
        String correo = sc.nextLine();

        System.out.println("Introduce el número de vinilos reservados:");
        int numVinilos = sc.nextInt();

        gestor.insertarCliente(idCliente, nombreCli, telefono, correo, numVinilos);
    }
}
