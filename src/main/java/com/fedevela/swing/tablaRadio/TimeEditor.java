package com.fedevela.swing.tablaRadio;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author fvelazquez
 */
public class TimeEditor extends AbstractCellEditor implements TableCellEditor {

    private JSpinner theSpinner;
    private Object value;

    TimeEditor() {
        theSpinner = new JSpinner(new SpinnerDateModel());
        theSpinner.setOpaque(true);
        theSpinner.setEditor(new JSpinner.DateEditor(theSpinner, "HH:mm:ss,SSS"));
    }

    @Override
    public Object getCellEditorValue() {
        return theSpinner.getValue();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        theSpinner.setValue(value);
        if (isSelected) {
            theSpinner.setBackground(table.getSelectionBackground());
        } else {
            theSpinner.setBackground(table.getBackground());
        }
        return theSpinner;
    }
}