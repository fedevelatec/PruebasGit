package com.fedevela.swing.tablaRadio;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;

/**
 *
 * @author fvelazquez
 */
public class RadioButtonEditor extends DefaultCellEditor implements ItemListener {

    public JPanel pnl = new JPanel();
    public ButtonGroup group1 = new ButtonGroup();
    public JRadioButton btnOne = new JRadioButton("Capturista");
    public JRadioButton btnTwo = new JRadioButton("Calidad");
    public JRadioButton btnThree = new JRadioButton("Diferencia");

    public RadioButtonEditor(JCheckBox checkBox) {
        super(checkBox);
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
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
        btnTwo.setSelected(false);
        btnOne.setSelected(false);
        System.out.println("RadioButtonEditor. Value: " + value.toString());
        switch ((String) value) {
            case "Diferencia":
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

    @Override
    public Object getCellEditorValue() {
        if (btnTwo.isSelected() == true) {
            return "Calidad";
        }
        if (btnOne.isSelected() == true) {
            return "Capturista";
        }
        if (btnThree.isSelected() == true) {
            return "Diferencia";
        }
        return "";

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        super.fireEditingStopped();
    }
}