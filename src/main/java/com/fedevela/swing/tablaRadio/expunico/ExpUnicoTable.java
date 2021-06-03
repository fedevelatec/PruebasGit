package com.fedevela.swing.tablaRadio.expunico;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author fvelazquez
 */
public class ExpUnicoTable extends JPanel  {
    
    private ComentariosCalidadModelDataTable tableModel;
    private JTable table;
    private JFrame frame = new JFrame("Expediente Unico");

    public ExpUnicoTable() {
        super(new BorderLayout(0, 5));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tableModel = new ComentariosCalidadModelDataTable();
        table = new JTable(tableModel);
        
////        table.setDefaultEditor(String.class, new DefaultCellEditor( new JTextField() ));
////        table.setDefaultEditor(String.class, new DefaultCellEditor( new JTextField() ));
        table.getColumn("Error De").setWidth(60);
        table.getColumn("Error De").setCellEditor(new ErrorEditor());
        //table.setDefaultEditor(ErrorDe.class, new ErrorEditor() );
////        table.setDefaultEditor(String.class, new DefaultCellEditor( new JCheckBox() ) );
        
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        tableModel.add( new CometariosCalidadBean() );
        tableModel.add( new CometariosCalidadBean() );
        tableModel.add( new CometariosCalidadBean() );
        tableModel.add( new CometariosCalidadBean() );
        //packTable();
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        table.setRowHeight(100);
        frame.pack();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
    }
    
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("TableRenderDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        ExpUnicoTable newContentPane = new ExpUnicoTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
    
    private void packTable() {
        TableColumnModel columnModel = table.getColumnModel();
        int columnCount = table.getColumnCount();
        int rowCount = table.getRowCount();
        int[][] preferredHeights = new int[columnCount][rowCount];
        TableCellRenderer renderer;
        Component comp;
        for (int col = 0; col < columnCount; col++) {
            renderer = columnModel.getColumn(col).getCellRenderer();
            if (renderer == null) {
                renderer = table.getDefaultRenderer(tableModel.getColumnClass(col));
            }
            for (int row = 0; row < rowCount; row++) {
                comp = renderer.getTableCellRendererComponent(table,
                        tableModel.getValueAt(row, col), false, false, row, col);
                preferredHeights[col][row] = (int) comp.getPreferredSize().getHeight();
            }
        }
        for (int row = 0; row < rowCount; row++) {
            int pref = 0;
            for (int col = 0; col < columnCount; col++) {
                pref = Math.max(pref, preferredHeights[col][row]);
            }
            table.setRowHeight(row, pref);
        }
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ExpUnicoTable tableTestPanel = new ExpUnicoTable();
            }
        });
    }
    
}
