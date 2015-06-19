/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.List;

/**
 *
 * @author Carlos Marchante
 */
public class TipoUvaContenedor {
       private static List<Uva> listaUvas ;
    
    public static List getListaUvas(){
        return listaUvas;
    }
    
     public static void setDataList(List<Uva> U){
         listaUvas = U;
     }
    
}
