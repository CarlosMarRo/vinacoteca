/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos Marchante
 */
public class VinoContenedor {

     private static List<Vino> listaVino ;
    
    public static List getListaVinos(){
        return listaVino;
    }
    
     public static void setDataList(List<Vino> L){
        listaVino= L;
    }
}
