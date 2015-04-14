/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinacoteca;

import java.util.ArrayList;

/**
 *
 * @author Carlos Marchante
 */
public class ListaUva {
    
    private ArrayList<TipoUva> listaUva = new ArrayList();
    
     public ArrayList<TipoUva> getListaUvas(){
        return listaUva;
    }
    
    public TipoUva getTipoUvaByID(int id){
        for(TipoUva c : listaUva){
            if(c.getId() == id){
                return c;
            }
        }
        return null;
    }
}
