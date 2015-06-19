
package model;

import Data.TipoUva;
import Data.VinoContenedor;
import Data.Vino;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author Carlos Marchante
 */
public class vinoTableModel extends AbstractTableModel{

    
    @Override
    public int getRowCount() {
        if (VinoContenedor.getListaVinos()==null)
            return 0;
        return VinoContenedor.getListaVinos().size();
    }
    
    
    
    
    

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       Vino vino  = (Vino) VinoContenedor.getListaVinos().get(rowIndex);
       switch(columnIndex){
           case 0:
               return vino.getNombre();
           case 1:
               return vino.getPrecio();
           case 2:
               return vino.getOrigen();
           case 3:
               return vino.getFecha();
           case 4:
               return vino.isDenominacion();
           default:
               return null;
       }
    }

    @Override
    public String getColumnName(int column) {
        
        switch(column){
            case 0:
                return "Nombre";
            case 1:
                return "Precio";
            case 2:
                return "Origen";
            case 3:
                return "Fecha";
            case 4:
                return "Denominación de Origen";
            default:
                return null;
        }
    
    
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
   
        Vino vino  = (Vino) VinoContenedor.getListaVinos().get(rowIndex);
        switch(columnIndex){
            case 0:
                vino.setId(Integer.valueOf((String)aValue));
            case 1:
                vino.setNombre((String)aValue);
                break;
            case 2:
                vino.setOrigen((String)aValue);
                break;
            case 3:
                vino.setPrecio(Double.valueOf((String)aValue));
                break;
            case 4:
                vino.setFecha((String)aValue);
                break;
            case 5:
               // vino.setImagen((String)aValue);
                break;
            case 6:
                vino.setDenominacion(Boolean.valueOf((String)aValue));
                break;
          case 7:
                vino.setTipoUva((TipoUva)aValue);
                break;
                
            
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
      
        switch(columnIndex) {
            case 0:
            case 3:
                return false;
            default:
                return true;
        }
                
    }

}
