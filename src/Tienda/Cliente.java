/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tienda;

/**
 *
 * @author 2DAM
 */
public class Cliente {

    private int codCliente;
    private String nombreCli;
    private int telefono;
    private String correoEletronico;
    private int NumVinilosReservados;

    public Cliente(String nombreCli, int telefono, String correoEletronico, int codCliente) {
        this.nombreCli = nombreCli;
        this.telefono = telefono;
        this.correoEletronico = correoEletronico;
        this.codCliente = codCliente;
        this.NumVinilosReservados = 0;
    }

    public String getNombre() {
        return nombreCli;
    }

    public void setNombre(String nombre) {
        this.nombreCli = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreoEletronico() {
        return correoEletronico;
    }

    public void setCorreoEletronico(String correoEletronico) {
        this.correoEletronico = correoEletronico;
    }

    public int getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(int codCliente) {
        this.codCliente = codCliente;
    }

    public int getNumVinilosReservados() {
        return NumVinilosReservados;
    }

    public void setNumVinilosReservados(int NumVinilosReservados) {
        this.NumVinilosReservados = NumVinilosReservados;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cliente{");
        sb.append("codCliente=").append(codCliente);
        sb.append(", nombreCli=").append(nombreCli);
        sb.append(", telefono=").append(telefono);
        sb.append(", correoEletronico=").append(correoEletronico);
        sb.append(", NumVinilosReservados=").append(NumVinilosReservados);
        sb.append('}');
        return sb.toString();
    }

    
}
