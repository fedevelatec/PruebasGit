package com.fedevela.swing.tablaRadio;

import java.awt.Component;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author fvelazquez
 */
public class DateRenderer extends DefaultTableCellRenderer {
    
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!(value instanceof Date)) {
            return this;
        }
        setText(DATE_FORMAT.format((Date) value));
        return this;
    }
}