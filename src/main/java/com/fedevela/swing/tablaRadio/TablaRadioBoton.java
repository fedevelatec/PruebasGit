package com.fedevela.swing.tablaRadio;

import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.event.TableModelEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author fvelazquez
 */
public class TablaRadioBoton extends JPanel {

    private JFrame frame = new JFrame("Prueba Boton");

    public TablaRadioBoton() {

        super(new BorderLayout(0, 5));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JTable jTable = new JTable() {
            @Override
            public void tableChanged(TableModelEvent e) {
                super.tableChanged(e);
                repaint();
            }
        };

        DefaultTableModel jTableDT = new DefaultTableModel(
                new Object[][]{},
                new String[]{
            "Enroll", "Student Id", "Student Name", "Attendance"});

        jTable.setModel(jTableDT);
        jTable.getColumn("Attendance").setCellRenderer(new RadioButtonRenderer());
        jTable.getColumn("Attendance").setCellEditor(new RadioButtonEditor(new JCheckBox()));
        
        jTable.setRowHeight(100);
        
        Object[] fila = {"Comentario","Error","NOmbre estudiante","4"};
        jTableDT.addRow( fila );

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(jTable), BorderLayout.CENTER);

        frame.pack();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                TablaRadioBoton tableTestPanel = new TablaRadioBoton();
            }
        });
    }
}
