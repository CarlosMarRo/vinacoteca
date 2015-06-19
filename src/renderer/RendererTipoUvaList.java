
package renderer;

import Data.TipoUva;
import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class RendererTipoUvaList extends DefaultListCellRenderer{

    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        
        TipoUva tipoUva = (TipoUva)value;
        setText(tipoUva.getNombre());
        if(isSelected){
            this.setBackground(Color.blue);
        }else{
            this.setBackground(Color.white);
        }
        return this;
    }
    
}
