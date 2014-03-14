package com.fedevela.swing.tabla0;

/*
 * 
 * Descargado de http://hdcm.sytes.net/documentos/programacion/java/temas/java_ejemplos.html
 * @autor:
 * 		fernando rafael filipuzzi
 * 
 * @e-mail:
 * 		fernando6867@gmail.com
 * 
 * @sitio web:
 * 		http://hdcm.sytes.net
 * 		http://hdcm.com.ar
 * */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class App extends JFrame implements ActionListener, ListSelectionListener, TableModelListener {

    private static final long serialVersionUID = 1L;
    private JTextField jtfProductoCodigo = new JTextField(15);
    private JTextField jtfProductoNombre = new JTextField(15);
    private JCheckBox jcbProductoDisponible = new JCheckBox("Disponible");
    private JButton jbNuevo = new JButton("Nuevo");
    private JButton jbAgregar = new JButton("Agregar");
    private JButton jbModificar = new JButton("Modificar");
    private JButton jbEliminar = new JButton("Eliminar");
    private JScrollPane jspTabla = new JScrollPane();
    private JTable jtTabla = new JTable();
    private Producto producto = new Producto();
    private ProductosTableModel tmProductos = new ProductosTableModel();
    private JButton jbCerrar = new JButton("Cerrar");

    public App() {
        this.getContentPane().setLayout(new BorderLayout());
        this.setTitle("Ejemplo 4 - ABM");
        
                 /*  							 	----			--		
		   				|					|		(JPanel)|	[JLabel] [TextInput]   (Codigo)
		   				|					|	Formulario	| 	[JLabel] [TextInput]   (Nombre)
		   				|					|(GridBagLayout)|		
		   				|		(JPanel)	| (posicion0,0)	|--------------------------------------------------------		
		   			   	|			Adm		|				|  jpPanel			|         (barra de botones)
		   			   	|(GridBagLayout)	|				|  (FlowLayout)   	| [Nuevo] [Agregar] [Modificar] [Eliminar]
		  borderLayout 	|		(center)	|	(jPanel)	|	(norte)			|------------------------------------
		   				|					|	Detalle		|					|			| [Codigo]  [Nombre]
		   				|					|	BorderLayout|  					|			|
		   				|				 	|(posicion0,1)	|	jspScrollPane	| jtTabla	|
		   				|					|				|	(BorderLayout)	|			|
		   				|					|				|	(center)		|			|
		   				|					|				|	(viewporview)	|			|
		   				|	jpPanel		    |------------------------------------------------------------------------	
		   				|	(FlowLayout)	|
		   				| 	(sur)			|    							  [Cerrar]
		   				|-------------------|---------------------- -------------------------------------------------
		 **/


        /*adm*/
        JPanel jpAdm = new JPanel();
        jpAdm.setLayout(new GridBagLayout());
        this.add(jpAdm, BorderLayout.CENTER);

        /*formulario*/
        JPanel jpAdmFormulario = new JPanel();
        jpAdmFormulario.setBorder(BorderFactory.createTitledBorder("Datos de Producto"));
        jpAdmFormulario.setLayout(new GridBagLayout());
        jpAdm.add(jpAdmFormulario, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 10, 5), 1, 1));
        jpAdmFormulario.add(new JLabel("Código: ", SwingConstants.RIGHT), new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 10, 5), 1, 1));
        jpAdmFormulario.add(jtfProductoCodigo, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 10, 5), 1, 1));
        jpAdmFormulario.add(jcbProductoDisponible, new GridBagConstraints(2, 0, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 10, 5), 1, 1));
        jpAdmFormulario.add(new JLabel("Nombre: ", SwingConstants.RIGHT), new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 10, 5), 1, 1));
        jpAdmFormulario.add(jtfProductoNombre, new GridBagConstraints(1, 1, 2, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, new Insets(5, 5, 10, 5), 1, 1));

        /*detalle*/
        JPanel jpAdmDetalle = new JPanel();
        jpAdmDetalle.setLayout(new BorderLayout());
        jpAdm.add(jpAdmDetalle, new GridBagConstraints(0, 1, 1, 2, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 5, 10, 5), 1, 1));

        /*detalle/barrabotones*/
        JPanel jpAdmDetalleBarraBotones = new JPanel();
        jpAdmDetalleBarraBotones.setLayout(new FlowLayout());
        jpAdmDetalle.add(jpAdmDetalleBarraBotones, BorderLayout.NORTH);
        jpAdmDetalleBarraBotones.add(jbNuevo);
        jbNuevo.addActionListener(this);
        jpAdmDetalleBarraBotones.add(jbAgregar);
        jbAgregar.addActionListener(this);
        jpAdmDetalleBarraBotones.add(jbModificar);
        jbModificar.addActionListener(this);
        jpAdmDetalleBarraBotones.add(jbEliminar);
        jbEliminar.addActionListener(this);


        /*detalle/tabla*/
        jpAdmDetalle.add(jspTabla);
        jtTabla.setModel(tmProductos);

        jtTabla.setAutoCreateRowSorter(true); //Sorting and Filtering

        /*alternativa al "sorting and filtering"
         TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(table.getModel());
         table.setRowSorter(sorter);
		
         redefinir
         Comparator<String> comparator = new Comparator<String>() {
         public int compare(String s1, String s2) {
         String[] strings1 = s1.split("\\s");
         String[] strings2 = s2.split("\\s");
         return strings1[strings1.length - 1].compareTo(strings2[strings2.length - 1]);
         }
         };	
         */

        jtTabla.getSelectionModel().addListSelectionListener(this);
        jspTabla.setViewportView(jtTabla);
        jtTabla.setPreferredScrollableViewportSize(new Dimension(500, 85));
        jtTabla.setFillsViewportHeight(true);

        /*barra de botones*/
        JPanel jpBarraBotones = new JPanel();
        this.add(jpBarraBotones, BorderLayout.SOUTH);
        jpBarraBotones.setLayout(new FlowLayout());
        jpBarraBotones.add(jbCerrar);

        jbCerrar.setActionCommand("CERRAR");
        jbCerrar.addActionListener(new BarraBotonesActionListener());

        nuevoProducto();
        this.pack();
    }

    public static void main(String[] args) {
        App app = new App();
        app.setVisible(true);
    }

    public void seleccionarProducto() {
        this.producto = tmProductos.productos.get(jtTabla.getSelectedRow());
        if (producto != null) {
            jtfProductoCodigo.setText(producto.getCodigo().toString());
            jtfProductoNombre.setText(producto.getNombre());
        }

        if (this.producto != null) {
            this.jbNuevo.setEnabled(true);
            this.jbAgregar.setEnabled(false);
            this.jbModificar.setEnabled(true);
            this.jbEliminar.setEnabled(true);
        } else {
            nuevoProducto();
        }
    }

    public void nuevoProducto() {
        this.producto = new Producto();
        jtfProductoCodigo.setText("");
        jtfProductoNombre.setText("");

        this.jbNuevo.setEnabled(true);
        this.jbAgregar.setEnabled(true);
        this.jbModificar.setEnabled(false);
        this.jbEliminar.setEnabled(false);
    }

    public void addProducto() {
        this.jspTabla.remove(jtTabla);

        producto = new Producto();
        Integer codigo = null;
        if (jtfProductoCodigo.getText() != null
                && !jtfProductoCodigo.getText().equals("")
                && !jtfProductoCodigo.getText().contains(" ")) {
            codigo = Integer.parseInt(jtfProductoCodigo.getText());
        }
        producto.setCodigo(codigo);
        producto.setNombre(jtfProductoNombre.getText());
        if (producto.getCodigo() != null) {
            tmProductos.productos.add(producto);
        }
        producto.setDisponible(jcbProductoDisponible.isSelected());


        this.jspTabla.setViewportView(jtTabla);

        /*limpia el formulario*/
        this.producto = new Producto();
        jtfProductoCodigo.setText("");
        jtfProductoNombre.setText("");
        this.jbNuevo.setEnabled(true);
        this.jbAgregar.setEnabled(true);
        this.jbModificar.setEnabled(false);
        this.jbEliminar.setEnabled(false);


    }

    public void modificarProducto() {
        this.producto = tmProductos.productos.get(jtTabla.getSelectedRow());

        if (this.producto != null) {
            Integer codigo = null;
            if (jtfProductoCodigo.getText() != null) {
                codigo = Integer.parseInt(jtfProductoCodigo.getText());
            }
            producto.setCodigo(codigo);
            producto.setNombre(jtfProductoNombre.getText());
            producto.setDisponible(jcbProductoDisponible.isSelected());
        }

        this.jtTabla.repaint();
    }

    public void eliminarProducto() {
        this.producto = tmProductos.productos.get(jtTabla.getSelectedRow());
        tmProductos.productos.remove(producto);
        this.jtTabla.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e != null && jbNuevo.equals(e.getSource())) {
            nuevoProducto();
        } else if (e != null && jbAgregar.equals(e.getSource())) {
            addProducto();
            nuevoProducto();
        } else if (e != null && jbModificar.equals(e.getSource())) {
            modificarProducto();
        } else if (e != null && jbEliminar.equals(e.getSource())) {
            eliminarProducto();
            nuevoProducto();
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int viewRow = jtTabla.getSelectedRow();
        if (viewRow < 0) {
            System.out.println("");
        } else {
            int modelRow = jtTabla.convertRowIndexToModel(viewRow);
            System.out.println(String.format("Selected Row in view: %d. " + "Selected Row in model: %d.", viewRow, modelRow));
            seleccionarProducto();
        }
        //http://download.oracle.com/javase/tutorial/uiswing/components/table.html#editor
        //http://inforux.wordpress.com/category/jcheckbox/
        //http://download.oracle.com/javase/tutorial/uiswing/components/border.html
        //http://inforux.wordpress.com/2008/07/21/aprediendo-con-jcheckbox-y-jradiobutton/#more-309
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        ProductosTableModel model = (ProductosTableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Producto data = (Producto) model.getValueAt(row, column);
        System.out.println(data.getId() + "-" + data.getCodigo() + "-" + data.getNombre() + "-" + columnName);

        //http://download.oracle.com/javase/tutorial/uiswing/layout/visual.html
    }
}
