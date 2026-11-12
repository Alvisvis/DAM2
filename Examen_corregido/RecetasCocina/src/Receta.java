/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author 2DAM
 */
import java.util.ArrayList;

public class Receta {

    private int id;
    private String titulo;
    private String instrucciones;
    private Usuario creador;
    private ArrayList<Ingrediente> ingredientes;

    public Receta(int id, String titulo, String instrucciones, Usuario creador, ArrayList<Ingrediente> ingredientes) {
        this.id = id;
        this.titulo = titulo;
        this.instrucciones = instrucciones;
        this.creador = creador;
        this.ingredientes = ingredientes;
    }
    
    
}