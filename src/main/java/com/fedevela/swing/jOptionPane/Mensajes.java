package com.fedevela.swing.jOptionPane;

import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author fvelazquez
 */
public class Mensajes {

    public static void main(String[] args) {
////        String mensaje = JOptionPane.showInputDialog("Enter first integer");
////        JOptionPane.showConfirmDialog(null, "Holaaaaaa");

////        JTextArea textArea = new JTextArea();
////        textArea.setText(mensaje); // A string of ~100 words "Lorem ipsum...\nFin."
////        textArea.setColumns(50);
////        textArea.setOpaque(false);
////        textArea.setEditable(false);
////        textArea.setLineWrap(true);
////        textArea.setWrapStyleWord(true);
////        JOptionPane.showMessageDialog(null, textArea, "Truncated!", JOptionPane.WARNING_MESSAGE);

////        String text = "one two three four five six seven eight nine ten ";
////        JTextArea textArea2 = new JTextArea(text);
////        textArea2.setColumns(30);
////        textArea2.setRows(10);
////        textArea2.setLineWrap(true);
////        textArea2.setWrapStyleWord(true);
////        textArea2.append(text);
////        textArea2.append(text);
////        textArea2.append(text);
////        textArea2.append(text);
////        textArea2.append(text);
////        textArea2.setSize(textArea2.getPreferredScrollableViewportSize().width, 1);
////        JOptionPane.showMessageDialog(
////                null, textArea2, "Not Truncated!", JOptionPane.WARNING_MESSAGE);
////
////        JTextArea textArea3 = new JTextArea("Insert your Text here");
////        JScrollPane scrollPane = new JScrollPane(textArea3);
////        textArea3.setLineWrap(true);
////        textArea3.setWrapStyleWord(true);
////        scrollPane.setPreferredSize(new Dimension(500, 500));
////        JOptionPane.showMessageDialog(null, scrollPane, "dialog test with textarea", JOptionPane.YES_NO_OPTION);
////        
////        JOptionPane.showConfirmDialog(null, scrollPane + "\n\n¿ DESEAS ACTUALIZAR LOS DATOS ?", text, JOptionPane.YES_NO_OPTION);
        
        IngresarMensaje dialog = new IngresarMensaje(new javax.swing.JFrame(), true);
        //dialog.setVisible(true);
        
        JOptionPane.showMessageDialog(null, dialog, "dialog test with textarea", JOptionPane.YES_NO_OPTION);
        
        System.out.println("Comentarios:\n" + dialog.getComentarios() );
        System.out.println("Aceptar:\n" + dialog.getAceptar() );
        dialog.dispose();
        
    }
}
