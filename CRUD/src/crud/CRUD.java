/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package crud;

/**
 *
 * @author 2DAM
 */
public class CRUD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      GestorConexion gestor = new GestorConexion();
        ParcelaCamping parcela1 = new ParcelaCamping("Matalascañas", 4, true, 50.50, "Buen estado", true);
        parcela1.create(gestor);
        ParcelaCamping parcela2 = new ParcelaCamping("Huelva", 6, true, 45.00, "Buen estado", true);
        parcela2.create(gestor);
        ParcelaCamping parcela3 = new ParcelaCamping("Cádiz", 5, false, 55.75, "Excelente", true);
        parcela3.create(gestor);
        ParcelaCamping parcela4 = new ParcelaCamping("Málaga", 4, true, 48.50, "Muy buena", false);
        parcela4.create(gestor);
        
        //leer
        parcela1.read(gestor);
        
        //actaulizar
        parcela2.setCapacidad(3);
        parcela2.setPrecioPorNoche(35);
        parcela2.update(gestor);
        
        //eliminar
        parcela2.delete(gestor);
    }
    
}
