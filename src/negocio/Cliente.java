/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

/**
 *
 * @author 2DAM
 */
public class Cliente {

    private int codCliente;
    private String nombreCli;
    private String telefono;
    private String correoEletronico;
    private int NumVinilosReservados;

    public Cliente(String nombreCli, String telefono, String correoEletronico, int codCliente) {
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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
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
        sb.append("Cliente");
        sb.append("\nCodigo de cliente:").append(codCliente);
        sb.append("\tNombre del cliente: ").append(nombreCli);
        sb.append("\nNumero telefono: ").append(telefono);
        sb.append("\tCorreo Eletronico: ").append(correoEletronico);
        sb.append("\nNumero de vinilos reservados: ").append(NumVinilosReservados);
        return sb.toString();
    }

    
}
