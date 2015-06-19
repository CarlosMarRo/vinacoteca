/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import Data.TipoUvaContenedor;
import vinacoteca.TipoUva;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Susana
 */
public class tipoUvaTableModel extends AbstractTableModel{

    private TipoUvaContenedor tipoUvaContenedor;

    public tipoUvaTableModel(TipoUvaContenedor tipoUva){
        this.tipoUvaContenedor = tipoUva;
    }
    
    
    @Override
    public int getRowCount() {
        return tipoUvaContenedor.getListaUvas().size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object tipoUva = tipoUvaContenedor.getListaUvas().get(rowIndex);
        switch(columnIndex){
            case 0:
                return tipoUva;
            case 1:
                return tipoUva.getCaracteristicas();
            case 2:
                return tipoUva.getColor();
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
                return "Caracteristica";
            case 2:
                return "Color";
            default:
                return null;
        
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

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TipoUva tipoUva = tipoUvaContenedor.getListaUvas().get(rowIndex);
        switch(columnIndex){
            case 0:
                tipoUva.setId(Integer.valueOf((String)aValue));
                break;
            case 1:
                tipoUva.setNombre((String)aValue);
                break;  
            case 2:
                tipoUva.setCaracteristicas((String)aValue);
                break;
            case 3:
                tipoUva.setColor((String)aValue);
                break;
        }
    
    }
    
}
