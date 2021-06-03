package com.fedevela.swing.jspinner;


/**
 * Este ejemplo muestra el uso de los tres tipos de Elementos de control
 * de selecciÃ³n de tipo JSpinner
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;


/**
 *
 * @author fvelazquez
 */
public class JSpinnerTest extends JPanel{
    
     JSpinner spinFecha1;
    JSpinner spinFecha2;
    JSpinner spinNumero;
    JSpinner spinLista;

    public JSpinnerTest() {
        // No usamos un layout para colocar los elementos en donde se quiera
        setLayout( null );

        // Creamos un selector que va a permitir ir avanzando dÃ­a a dÃ­a,
        // es el que utiliza el modelo de Fecha por defecto.
        JLabel labFecha1 = new JLabel("Selecciona un día:" );
        labFecha1.setBounds( 5,10,120,24 );
        add( labFecha1 );
        SpinnerDateModel modeloFecha1 = new SpinnerDateModel();
        modeloFecha1.setCalendarField( Calendar.DAY_OF_WEEK );
        spinFecha1 = new JSpinner( modeloFecha1 );
        spinFecha1.setBounds( 160,10,150,24 );
        add( spinFecha1 );

        // Creamos un selector de fecha que va a permitir ir avanzando de
        // semana en semana, ya que en el campo correspondiente se indica
        // que se debe mostrar la semana del mes
        JLabel labFecha2 = new JLabel( "Selecciona una fecha:" );
        labFecha2.setBounds( 5,40,150,24 );
        add( labFecha2 );
        SpinnerDateModel modeloFecha2 = new SpinnerDateModel();
        modeloFecha2.setCalendarField( Calendar.WEEK_OF_MONTH );
        spinFecha2 = new JSpinner( modeloFecha2 );
        // Fijamos el formato con que se va a presentar la fecha en el
        // campo de selecciÃ³n
        JSpinner.DateEditor editor = new JSpinner.DateEditor(
            spinFecha2, "dd MMMMM yyyy");
        spinFecha2.setEditor( editor );
        spinFecha2.setBounds( 160,40,150,24 );
        add( spinFecha2 );

        // Se crea un elemento de selecciÃ³n que permite ir seleccionando
        // de forma ascendente o descendente, nÃºmeros con un intervalo fijado
        // en 0.5
        JLabel labNumero = new JLabel( "Selecciona un número:" );
        labNumero.setBounds( 5,70,150,24 );
        add( labNumero );
        SpinnerNumberModel modeloNumero = 
            new SpinnerNumberModel( 1,0.0,1000.0,0.5 );
        spinNumero = new JSpinner( modeloNumero );
        spinNumero.setBounds( 160,70,150,24 );
        add( spinNumero );

        // Se crea un elemento de selecciÃ³n que permite elegir entre los
        // distintos colores que integran la lista
        String[] colores = { "Amarillo","Marrón","Azul","Rojo","Naranja",
            "Negro","Blanco","Morado" };
        JLabel labLista = new JLabel( "Selecciona un color:" );
        labLista.setBounds( 5,100,150,24 );
        add( labLista );
        SpinnerListModel modeloLista = new SpinnerListModel( colores );
        spinLista = new JSpinner( modeloLista );
        spinLista.setValue( "Azul" );
        spinLista.setBounds( 160,100,150,24 );
        add( spinLista );
    }

    public static void main( String args[] ) {
        JFrame frame = new JFrame( "Tutorial de Java, Swing" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new JSpinnerTest(),BorderLayout.CENTER );
        frame.setSize( 325,170 );
        frame.setVisible( true );
    }
    
}
