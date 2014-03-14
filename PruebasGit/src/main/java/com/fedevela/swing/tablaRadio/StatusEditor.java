package com.fedevela.swing.tablaRadio;

import java.awt.Component;
import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

/**
 *
 * @author fvelazquez
 */
public class StatusEditor extends AbstractCellEditor implements TableCellEditor {

    private StatusPanel theStatusPanel;

    StatusEditor() {
        theStatusPanel = new StatusPanel();
    }

    @Override
    public Object getCellEditorValue() {
        return theStatusPanel.getStatus();
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        theStatusPanel.setStatus((Status) value);
        if (isSelected) {
            theStatusPanel.setBackground(table.getSelectionBackground());
        } else {
            theStatusPanel.setBackground(table.getBackground());
        }
        return theStatusPanel;
    }
}