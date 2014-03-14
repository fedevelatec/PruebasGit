package com.fedevela.swing.tabla0;

import java.util.LinkedList;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author fvelazquez
 */
public class ModelTableImpl implements TableModel{
    
    private LinkedList datos = new LinkedList();
    

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int i) {
        // Devuelve el nombre de cada columna. Este texto aparecerá en la
        // cabecera de la tabla.
        switch (i)
        {
            case 0:
                return "Error";
            case 1:
                return "Comentario";
            default:
                return null;
        }
    }

    @Override
    public Class<?> getColumnClass(int i) {
        // Devuelve la clase que hay en cada columna.
        switch (i)
        {
            case 0:
                // La columna cero contiene el nombre de la persona, que es
                // un String
                return String.class;
            case 1:
                // La columna uno contiene el apellido de la persona, que es
                // un String
                return String.class;
            default:
                // Devuelve una clase Object por defecto.
                return Object.class;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if( columnIndex == 1 ){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object getValueAt(int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setValueAt(Object o, int i, int i1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeTableModelListener(TableModelListener tl) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
