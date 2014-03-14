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
public class TimeRenderer extends DefaultTableCellRenderer {
    
    private static final DateFormat TIME_FORMAT_LONG = new SimpleDateFormat("HH:mm:ss,SSS");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        if (!(value instanceof Date)) {
            return this;
        }
        setText(TIME_FORMAT_LONG.format((Date) value));
        return this;
    }
}