package com.fedevela.swing.tablaRadio.expunico;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fvelazquez
 */
public class ComentariosCalidadModelDataTable extends AbstractTableModel {
    
    private static final String[] COLUMN_NAMES = {
        "Errores", "Comentarios", "Error De", "Autorizar"};
    
    private List<CometariosCalidadBean> comentarioList;

    public ComentariosCalidadModelDataTable() {
        comentarioList = new ArrayList<>();
    }
    
    @SuppressWarnings("unchecked")
    public void add(CometariosCalidadBean comentarios){
        int index = comentarioList.size();
        comentarioList.add(comentarios);
        fireTableRowsInserted(index, index);
    }
    
    public void remove(int aRowIndex) {
        if (aRowIndex < 0 || aRowIndex >= comentarioList.size()) {
            return;
        }
        comentarioList.remove(aRowIndex);
        fireTableRowsDeleted(aRowIndex, aRowIndex);
    }
    
    @Override
    public int getRowCount() {
        return comentarioList.size();
    }
    
    @Override
    public String getColumnName(int column) {
        return COLUMN_NAMES[column];
    }
    
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return ErrorDe.class;
            case 3:
                return Boolean.class;
        }
        return Object.class;
    }
    
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        CometariosCalidadBean entry = comentarioList.get(rowIndex);
        System.out.println("ComentariosCalidadModelDataTable - setValueAt: " + entry.toString());
        switch (columnIndex) {
            case 0:
                entry.setError(aValue.toString());
                break;
            case 1:
                entry.setComentario(aValue.toString());
                break;
            case 2:
                entry.setErrorDe((ErrorDe)aValue);
                break;
            case 3:
                entry.setAutorizado( (Boolean)aValue );
                break;
            default:
                return;
        }
        fireTableCellUpdated(rowIndex, columnIndex);
////        comentarioList.set(rowIndex, entry);
        System.out.println("ComentariosCalidadModelDataTable - setValueAt: " + entry.toString());
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if( columnIndex == 0 ){
            return false;
        }else{
            return true;
        }
////        return true;
    }
    
    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        CometariosCalidadBean entry = comentarioList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return entry.getError();
            case 1:
                return entry.getComentario();
            case 2:
                return entry.getErrorDe();
            case 3:
                return entry.getAutorizado();
        }
        return null;
    }
    
    public CometariosCalidadBean getValueRow( int rowIndex ){
        return comentarioList.get(rowIndex);
    }
    
}
