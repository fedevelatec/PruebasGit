package com.fedevela.swing;

/**
 * ConvertidorCelsius2.java es una aplicación 1.4 que demuestra el uso
 * deJButton, JTextFormattedField, y JLabel y requiere el siguiente archivo:
 * images/convert.gif
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.NumberFormatter;
import java.text.ParseException;
import java.text.DecimalFormat;
import java.net.URL;

public class ConvertidorCelsius2 implements ActionListener {

    JFrame marcoConvertidor;
    JPanel panelConvertidor;
    JFormattedTextField tempCelsius;
    JLabel etiquetaCelsius, etiquetaFahrenheit;
    JButton convertTemp;

    public ConvertidorCelsius2() {
        //Crear y configurar la ventana.
        marcoConvertidor = new JFrame("Convertir Celsius a Fahrenheit");
        marcoConvertidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marcoConvertidor.setSize(new Dimension(120, 40));

        //Crear y configurar el panel.
        panelConvertidor = new JPanel(new GridLayout(2, 2));

        //Agregar los widgets.
        agregarWidgets();

        //Establecer el botón predeterminado.
        marcoConvertidor.getRootPane().setDefaultButton(convertTemp);

        //Agregar el panel a la ventana.
        marcoConvertidor.getContentPane().add(panelConvertidor, BorderLayout.CENTER);

        //Desplegar la ventana.
        marcoConvertidor.pack();
        marcoConvertidor.setVisible(true);
    }

    /**
     * Crear y agregar los widgets.
     */
    private void agregarWidgets() {
        //Crear los widgets.
        ImageIcon convertIcon = createImageIcon("images/convert.gif", "Convertir temperatura");

        //Crear el formato para el campo de texto Celsius.
        tempCelsius = new JFormattedTextField(new DecimalFormat("##0.0#"));
        tempCelsius.setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);

        //Establecer y aplicar la temperatura predeterminada.
        try {
            tempCelsius.setText("37.0");
            tempCelsius.commitEdit();
        } catch (ParseException e) {
            //No deberíamos llegar aquí a menos que el valor de setText no concuerde
            //con el formato anterior.
            System.out.println("Error: " + e.getMessage());
        }

        etiquetaCelsius = new JLabel("Celsius", SwingConstants.LEFT);
        convertTemp = new JButton(convertIcon);

        etiquetaFahrenheit = new JLabel("Fahrenheit", SwingConstants.LEFT);

        etiquetaCelsius.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        etiquetaFahrenheit.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        //Escuchar a los eventos desde el botón Convertir
        //y el campo de texto tempCelsius.
        convertTemp.addActionListener(this);
        tempCelsius.addActionListener(this);

        //Agregar los widgets al contenedor.
        panelConvertidor.add(tempCelsius);
        panelConvertidor.add(etiquetaCelsius);
        panelConvertidor.add(convertTemp);
        panelConvertidor.add(etiquetaFahrenheit);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        String eventName = event.getActionCommand();
        //Analizar los grados Celsius como un doble y convertir a Fahrenheit.
        int tempFahr = (int) ((Double.parseDouble(tempCelsius.getText()))
                * 1.8 + 32);

        //Establecer etiquetaFahrenheit al nuevo valor y establecer el color de fuente
        //basándose en la temperatura.
        if (tempFahr <= 32) {
            etiquetaFahrenheit.setText("<html><font Color=blue>"
                    + tempFahr + "&#176 </font> Fahrenheit</html>");
        } else if (tempFahr <= 80) {
            etiquetaFahrenheit.setText("<html><font Color=green>"
                    + tempFahr + "&#176 </font> Fahrenheit</html>");
        } else {
            etiquetaFahrenheit.setText("<html><font Color=red>"
                    + tempFahr + "&#176 </font> Fahrenheit</html>");
        }
    }

    /**
     * Devuelve un ImageIcon, o null si la ruta era inválida.
     */
    protected static ImageIcon createImageIcon(String path,
            String description) {
        java.net.URL imgURL = ConvertidorCelsius2.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL, description);
        } else {
            System.err.println("No pude encontrar el archivo: " + path);
            return null;
        }
    }

    /**
     * Crear la GUI y mostrarla. Para seguridad de hilos, este método debería
     * invocarse desde el hilo de despacho de eventos.
     */
    private static void crearYmostrarGUI() {
        //Asegurarse de que tenemos bonitas decoraciones de ventana.
        JFrame.setDefaultLookAndFeelDecorated(true);

        ConvertidorCelsius2 converter = new ConvertidorCelsius2();
    }

    public static void main(String[] args) {
        //Programar un trabajo para el hilo de despacho de eventos:
        //creando y mostrando la GUI de esta aplicación.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                crearYmostrarGUI();
            }
        });
    }
}