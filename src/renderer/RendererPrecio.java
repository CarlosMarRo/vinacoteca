/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import java.text.NumberFormat;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Carlos Marchante
 */
public class RendererPrecio extends DefaultTableCellRenderer{

    @Override
    protected void setValue(Object value) {
        NumberFormat formato = NumberFormat.getCurrencyInstance();
        
        //Dar el formato a la columna que seleccionemos por parametro.
        setText(formato.format(value));
    }
    
    
}
