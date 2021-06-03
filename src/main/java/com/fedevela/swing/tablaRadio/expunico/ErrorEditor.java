package com.fedevela.swing.tablaRadio.expunico;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author fvelazquez
 */
public class ErrorEditor extends AbstractCellEditor implements TableCellEditor{
    
    private ErrorPanel errorPanel;

    public ErrorEditor() {
        errorPanel = new ErrorPanel();
    }
    
    @Override
    public Object getCellEditorValue() {
        return errorPanel.getStatus();
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        errorPanel.setStatus( (ErrorDe)value );
        if( isSelected ){
            errorPanel.setBackground(table.getSelectionBackground());
        }else{
            errorPanel.setBackground( table.getSelectionBackground() );
        }
        return errorPanel;
    }
    
}
