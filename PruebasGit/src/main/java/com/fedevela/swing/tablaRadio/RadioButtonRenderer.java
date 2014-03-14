package com.fedevela.swing.tablaRadio;

import java.awt.Component;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author fvelazquez
 */
public class RadioButtonRenderer implements TableCellRenderer {

    public JPanel pnl = new JPanel();
    public ButtonGroup group1 = new ButtonGroup();
    public JRadioButton btnOne = new JRadioButton("Capturista");
    public JRadioButton btnTwo = new JRadioButton("Calidad");
    public JRadioButton btnThree = new JRadioButton("Diferencias");

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if (value == null) {
            return null;
        }

        group1.add(btnOne);
        group1.add(btnTwo);
        group1.add(btnThree);
        pnl.add(btnOne);
        pnl.add(btnTwo);
        pnl.add(btnThree);

        btnThree.setSelected(false);
        btnOne.setSelected(false);
        btnTwo.setSelected(false);
        System.out.println("RadioButtonRenderer. Value: " + value.toString());
        switch ((String) value) {

            case "Diferencias":
                btnThree.setSelected(true);
                break;
            case "Calidad":
                btnTwo.setSelected(true);
                break;
            case "Capturista":
                btnOne.setSelected(true);
                break;
        }
        return pnl;
    }
}