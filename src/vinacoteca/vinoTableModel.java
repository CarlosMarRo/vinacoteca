
package vinacoteca;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Carlos Marchante
 */
public class vinoTableModel extends AbstractTableModel{

    @Override
    public int getRowCount() {
        return 5;
    }

    @Override
    public int getColumnCount() {
        return 10;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
       return "hello";
    }
    
    
    
}
