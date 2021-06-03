package com.fedevela.swing.tablaRadio;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author fvelazquez
 */
public class StatusPanel extends JPanel {

        private JRadioButton theSingleOption;
        private JRadioButton theMarriedOption;
        private JRadioButton theDivorcedOption;
        private ButtonGroup buttonGroup = new ButtonGroup();

        StatusPanel() {
            super(new GridLayout(0, 1));
            setOpaque(true);
            theSingleOption = createRadio(Status.Single);
            theMarriedOption = createRadio(Status.Married);
            theDivorcedOption = createRadio(Status.Divorced);
        }

        private JRadioButton createRadio(Status status) {
            JRadioButton jrb = new JRadioButton(status.toString());
            jrb.setOpaque(false);
            add(jrb);
            buttonGroup.add(jrb);
            return jrb;
        }

        public Status getStatus() {
            if (theMarriedOption.isSelected()) {
                return Status.Married;
            } else if (theDivorcedOption.isSelected()) {
                return Status.Divorced;
            } else {
                return Status.Single;
            }
        }

        public void setStatus(Status status) {
            if (status == Status.Married) {
                theMarriedOption.setSelected(true);
            } else if (status == Status.Divorced) {
                theDivorcedOption.setSelected(true);
            } else {
                theSingleOption.setSelected(true);
            }
        }
    }