/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package renderer;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Susana
 */
public class RendererImagen extends DefaultTableCellRenderer{

      public void imagenRenderer() {
        setHorizontalAlignment(SwingConstants.CENTER);
    }
 
    @Override
    public void setValue(Object aValue) {
 
        if ((aValue != null) && (aValue instanceof String)) {
            String rutaimagen = String.valueOf(aValue);
            setIcon(new ImageIcon(getClass().getResource(rutaimagen)));
        }
    }
}
