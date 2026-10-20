package parcelacampingmejorado;

import java.sql.Connection;

/**
 *
 * @author 2DAM
 */
public class ParcelaCampingMejorado {

    private static ParcelaCampingMejorado pcM;
    
    public static void main(String[] args) {
        
        ParcelaDAO.CreateBDyTabla(pcM);
    }

}
