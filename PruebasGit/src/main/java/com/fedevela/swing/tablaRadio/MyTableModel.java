package com.fedevela.swing.tablaRadio;

import java.util.Date;
import java.util.Vector;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fvelazquez
 */
public class MyTableModel extends AbstractTableModel {

    private static final String[] COLUMN_NAMES = {
        "List ID", "Expiration Date", "Status", "Date Created"};
    private Vector<Object> theEntries;

    MyTableModel() {
        theEntries = new Vector<Object>();
    }

    @SuppressWarnings("unchecked")
    public void add(TableEntry anEntry) {
        int index = theEntries.size();
        theEntries.add(anEntry);
        fireTableRowsInserted(index, index);
    }

    public void remove(int aRowIndex) {
        if (aRowIndex < 0 || aRowIndex >= theEntries.size()) {
            return;
        }
        theEntries.removeElementAt(aRowIndex);
        fireTableRowsDeleted(aRowIndex, aRowIndex);

    }

    @Override
    public int getRowCount() {
        return theEntries.size();
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Long.class;
            case 1:
                return Date.class;
            case 2:
                return Status.class;
            case 3:
                return Date.class;
        }
        return Object.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        TableEntry entry = (TableEntry) theEntries.elementAt(rowIndex);
        switch (columnIndex) {
            case 0:
                try {
                    entry.setId(new Long(Long.parseLong(aValue.toString())));
                } catch (NumberFormatException nfe) {
                    return;
                }
                break;
            case 1:
                entry.setExpirationDate((Date) aValue);
                break;
            case 2:
                entry.setStatus((Status) aValue);
                break;
            case 3:
                entry.setCreationDate((Date) aValue);
                break;
            default:
                return;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TableEntry entry = (TableEntry) theEntries.elementAt(rowIndex);
        switch (columnIndex) {
            case 0:
                return entry.getId();
            case 1:
                return entry.getExpirationDate();
            case 2:
                return entry.getStatus();
            case 3:
                return entry.getCreationDate();
        }
        return null;
    }
}