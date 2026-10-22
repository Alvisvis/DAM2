/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recetas;

/**
 *
 * @author 2DAM
 */
public class Recetas {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) {
        gestorConexion gestor = new gestorConexion();
        
        usuarioDTO Ana = new usuarioDTO("Ana Pérez", "ana@gmail.com", "ana2000");
        usuarioDTO Carlos = new usuarioDTO("Carlos Ruiz", "carlos@gmail.com", "carlosRuiz");
        usuarioDTO Lucia = new usuarioDTO("Lucía Torres", "lucia@gmail.com", "lucia23424");
        usuarioDTO Miguel = new usuarioDTO("Miguel Díaz", "miguel@gmail.com", "miguelDiaz33");
        usuarioDAO dao = new usuarioDAO();
        //dao.create(gestor, Ana);
        
        //dao.listar(gestor);
        
        
    }
    
}
