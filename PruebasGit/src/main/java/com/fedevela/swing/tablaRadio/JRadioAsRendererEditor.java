package com.fedevela.swing.tablaRadio;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.util.Date;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author fvelazquez
 */
public class JRadioAsRendererEditor extends JPanel  {

////    private static final String[] COLUMN_NAMES = {
////        "List ID", "Expiration Date", "Status", "Date Created"};
////    private static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
////    private static final DateFormat TIME_FORMAT_LONG = new SimpleDateFormat("HH:mm:ss,SSS");
    private MyTableModel tableModel;
    private JTable table;
    private JFrame frame = new JFrame("TestRadioButtonRenderer");

    public JRadioAsRendererEditor() {
        super(new BorderLayout(0, 5));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tableModel = new MyTableModel();
        table = new JTable(tableModel);
        table.setDefaultEditor(Date.class, new DateEditor());
        table.setDefaultRenderer(Date.class, new DateRenderer());
        table.setDefaultEditor(Status.class, new StatusEditor());
        table.setDefaultRenderer(Status.class, new StatusRenderer());
// comment the two preceding lines and uncomment the following for a standard editor
// table.setDefaultEditor(Status.class, new DefaultCellEditor(
// new JComboBox(new Status[]{Status.Single, Status.Married, Status.Divorced})));

        add(new JScrollPane(table), BorderLayout.CENTER);
        JToolBar toolBar = new JToolBar();
        toolBar.setFloatable(false);
        toolBar.add(new AbstractAction("Add new") {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.add(new TableEntry());
                packTable();
            }
        });
        toolBar.add(new AbstractAction("Remove") {
            @Override
            public void actionPerformed(ActionEvent e) {
                tableModel.remove(table.getSelectedRow());
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);
        frame.add(toolBar, BorderLayout.NORTH);
        frame.pack();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frame.setVisible(true);
            }
        });
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
                JRadioAsRendererEditor tableTestPanel = new JRadioAsRendererEditor();
            }
        });
    }
}
