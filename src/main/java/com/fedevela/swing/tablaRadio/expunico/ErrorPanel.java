package com.fedevela.swing.tablaRadio.expunico;

import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author fvelazquez
 */
public class ErrorPanel extends JPanel {

    private JRadioButton capturistaOpcion;
    private JRadioButton calidadOpcion;
    private JRadioButton diferenciaOpcion;
    private ButtonGroup buttonGroup = new ButtonGroup();

    public ErrorPanel() {
        super(new GridLayout(0, 1));
        setOpaque(true);
        capturistaOpcion = createRadio(ErrorDe.Capturista);
        calidadOpcion = createRadio(ErrorDe.Calidad);
        diferenciaOpcion = createRadio(ErrorDe.Diferencia);
    }

    private JRadioButton createRadio(ErrorDe status) {
        JRadioButton jrb = new JRadioButton(status.toString());
        jrb.setOpaque(false);
        add(jrb);
        buttonGroup.add(jrb);
        return jrb;
    }
    
    public ErrorDe getStatus() {
        if( capturistaOpcion.isSelected() ){
            return ErrorDe.Capturista;
        }else if( calidadOpcion.isSelected() ){
            return ErrorDe.Calidad;
        }else {
            return ErrorDe.Diferencia;
        }
    }
    
    public void setStatus(ErrorDe status) {
        if( status == ErrorDe.Capturista ){
            capturistaOpcion.setSelected(true);
        }else if( status == ErrorDe.Calidad ){
            calidadOpcion.setSelected(true);
        }else{
            diferenciaOpcion.setSelected(true);
        }
    }
}
