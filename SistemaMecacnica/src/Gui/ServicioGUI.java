package Gui;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Modelo.Cliente;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import Modelo.Vehiculo;
import Modelo.ServicioDao;
import Modelo.Servicio;

import Modelo.VehiculoDao;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ServicioGUI extends JPanel implements ActionListener, ItemListener, MouseListener {
	VehiculoDao vehdao=new VehiculoDao();
	ServicioDao serdao=new ServicioDao();

	private static final long serialVersionUID = 1L;
	private JTextField txtKilometraje;
	private JComboBox cboDescripcion;
	private JComboBox cboServicio;
	private JComboBox cboVehiculoC;
	private JScrollPane scrollPane;
	private JComboBox cboEstado;
	private JLabel lblNewLabel;
	private JButton btnRegistroServicio;
	private JTable tablelistaServicio;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JButton btnActualizarServicio;
	private JButton btnLimpiar;
	private JButton btnEliminarServicio;
	private JTextField txtId;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	/**
	 * Create the panel.
	 */
	public ServicioGUI() {
		
		Servicio ser=new Servicio();
		ServicioDao serdao=new ServicioDao();

		setLayout(null);
		txtKilometraje = new JTextField();
		txtKilometraje.setBounds(148, 230, 86, 20);
		add(txtKilometraje);
		txtKilometraje.setColumns(10);
		
		cboDescripcion = new JComboBox();
		cboDescripcion.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Preventivo", "Correctivo"}));
		cboDescripcion.setBounds(148, 265, 132, 22);
		add(cboDescripcion);
		
		cboServicio = new JComboBox();
		cboServicio.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "Aceite del Motor", "Aceite de transmision"}));
		cboServicio.setBounds(148, 186, 178, 22);
		add(cboServicio);
		
		cboVehiculoC = new JComboBox();
		cboVehiculoC.addItemListener(this);
		cboVehiculoC.setBounds(41, 92, 269, 27);
		add(cboVehiculoC);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(348, 60, 696, 637);
		add(scrollPane);
		
		tablelistaServicio = new JTable();
		tablelistaServicio.addMouseListener(this);
		scrollPane.setViewportView(tablelistaServicio);
		
		cboEstado = new JComboBox();
		cboEstado.setModel(new DefaultComboBoxModel(new String[] {"Seleccione", "J", "S", "I", "R\t"}));
		cboEstado.setBounds(148, 298, 132, 22);
		add(cboEstado);
		
		lblNewLabel = new JLabel("Escoja un vehiculo");
		lblNewLabel.setBounds(45, 70, 106, 14);
		add(lblNewLabel);
		
		btnRegistroServicio = new JButton("Generar");
		btnRegistroServicio.addActionListener(this);
		btnRegistroServicio.setBounds(28, 347, 89, 23);
		add(btnRegistroServicio);
		
		lblNewLabel_1 = new JLabel("(J) Ajustar de ser necesario");
		lblNewLabel_1.setBounds(11, 445, 161, 14);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("(S) Sustituir de ser necesario");
		lblNewLabel_2.setBounds(11, 495, 177, 14);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("(I) Inspeccionar");
		lblNewLabel_3.setBounds(10, 470, 142, 14);
		add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("(R) Realizar cambio");
		lblNewLabel_4.setBounds(11, 520, 161, 14);
		add(lblNewLabel_4);
		txtId = new JTextField();
		txtId.setBounds(148, 154, 86, 20);
		add(txtId);
		txtId.setColumns(10);
		txtId.setVisible(false);
		
		btnActualizarServicio = new JButton("Actualizar");
		btnActualizarServicio.addActionListener(this);
		btnActualizarServicio.setBounds(145, 347, 89, 23);
		add(btnActualizarServicio);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(148, 381, 89, 23);
		add(btnLimpiar);
		
		btnEliminarServicio = new JButton("Eliminar");
		btnEliminarServicio.addActionListener(this);
		btnEliminarServicio.setBounds(28, 377, 89, 23);
		add(btnEliminarServicio);
		
		lblNewLabel_5 = new JLabel("SERVICIO");
		lblNewLabel_5.setBounds(28, 190, 67, 14);
		add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("KILOMETRAJE");
		lblNewLabel_6.setBounds(28, 233, 86, 14);
		add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("MANTENIMIENTO");
		lblNewLabel_7.setBounds(28, 269, 110, 14);
		add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("ESTADO");
		lblNewLabel_8.setBounds(28, 302, 99, 14);
		add(lblNewLabel_8);
		
		
		cargarComboVehiculo();

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminarServicio) {
			actionPerformedBtnEliminarServicio(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnActualizarServicio) {
			actionPerformedBtnActualizarServicio(e);
		}
		if (e.getSource() == btnRegistroServicio) {
			actionPerformedBtnRegistroServicio(e);
		}
	}
	protected void actionPerformedBtnRegistroServicio(ActionEvent e) {
		
		String mantenimiento = cboServicio.getSelectedItem().toString();
		String kilometraje = txtKilometraje.getText();
		String descripcion = cboDescripcion.getSelectedItem().toString();
		String estado = cboEstado.getSelectedItem().toString();

		if (kilometraje.isEmpty()) {
		    JOptionPane.showMessageDialog(null, "Debe ingresar un valor para el kilómetraje.");
		    return; 
		}

		String selectedItem = cboVehiculoC.getSelectedItem().toString();
		int idVehiculo = Integer.parseInt(selectedItem.split(":")[0]); 
		Servicio servicio = new Servicio();
		servicio.setMantenimiento(mantenimiento);
		servicio.setKilometraje(kilometraje);
		servicio.setDescripcion(descripcion);
		servicio.setEstado(estado);
		servicio.setVehiculo(idVehiculo);

		if (mantenimiento.equals("Seleccione")) {
		    JOptionPane.showMessageDialog(null, "Falta seleccionar un servicio.");
		    return;
		} else if (descripcion.equals("Seleccione")) {
		    JOptionPane.showMessageDialog(null, "Falta seleccionar un tipo de servicio.");
		    return;
		} else if (estado.equals("Seleccione")) {
		    JOptionPane.showMessageDialog(null, "Falta seleccionar un estado.");
		    return; 
		}

		boolean registrado = serdao.RegistrarServicio(servicio);

		if (registrado) {
		    JOptionPane.showMessageDialog(null, "Servicio registrado exitosamente.");
		} else {
		    JOptionPane.showMessageDialog(null, "Error al registrar el servicio.");
		}

		

		cargarTabla();
	    LimpiarServicio();  
	}
	
	
	
	
	
	
	
	
	
	public void cargarComboVehiculo() {
		List<Vehiculo> listaVehiculo = vehdao.ListarVehiculo();

		for (int i = 0; i < listaVehiculo.size(); i++) {
			cboVehiculoC.addItem(listaVehiculo.get(i).getIdVehiculo() + ":" + listaVehiculo.get(i).getPlaca());
		}

	}

	
	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboVehiculoC) {
			itemStateChangedCboVehiculo(e);
		}
	}
	protected void itemStateChangedCboVehiculo(ItemEvent e) {
		if (e.getStateChange() == ItemEvent.SELECTED) { // Verifica si se seleccionó un nuevo elemento
	     
	        cargarTabla();
	      
	    }
		
		
	}
	public void cargarTabla() {
		String selectedIteme = cboVehiculoC.getSelectedItem().toString();
		int idVehiculowe = Integer.parseInt(selectedIteme.split(":")[0]); // Obtiene el ID del vehículo seleccionado

		List<Servicio> listaServicios = serdao.ListarServicioPorVehiculo(idVehiculowe);
		  DefaultTableModel model = new DefaultTableModel();
	        model.addColumn("ID");
	        model.addColumn("Mantenimiento");
	        model.addColumn("Kilometraje");
	        model.addColumn("Descripción");
	        model.addColumn("Estado");

	        for (Servicio servicio : listaServicios) {
	            model.addRow(new Object[]{
	                servicio.getId(),
	                servicio.getMantenimiento(),
	                servicio.getKilometraje()+" Mil",
	                servicio.getDescripcion(),
	                servicio.getEstado()
	            });
	        }
	        tablelistaServicio.setModel(model); 
	}
	
	
	protected void actionPerformedBtnActualizarServicio(ActionEvent e) {
	    
		String id = txtId.getText();
		String mantenimiento = cboServicio.getSelectedItem().toString();
		String kilometraje = txtKilometraje.getText();
		String descripcion = cboDescripcion.getSelectedItem().toString();
		String estado = cboEstado.getSelectedItem().toString();

		// Verificar que no haya campos vacíos y que los ComboBoxes no estén en "Seleccione"
		if (id.isEmpty() || mantenimiento.equals("Seleccione") || kilometraje.isEmpty() || descripcion.equals("Seleccione") || estado.equals("Seleccione")) {
		    JOptionPane.showMessageDialog(null, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
		    return; // Salir del método sin realizar la modificación
		}

		// Confirmar la modificación con una alerta
		int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de actualizar el servicio?", "Confirmar actualización", JOptionPane.YES_NO_OPTION);
		if (confirmacion == JOptionPane.YES_OPTION) {
		    Servicio servicio = new Servicio();
		    servicio.setMantenimiento(mantenimiento);
		    servicio.setKilometraje(kilometraje);
		    servicio.setDescripcion(descripcion);
		    servicio.setEstado(estado);
		    servicio.setId(Integer.parseInt(id));
		    serdao.ModificarServicio(servicio);
		    cargarTabla(); // Supongo que esta función carga los datos en la tabla nuevamente
		    JOptionPane.showMessageDialog(null, "El servicio se ha actualizado correctamente.", "Actualización exitosa", JOptionPane.INFORMATION_MESSAGE);
		} else {
		    // El usuario ha cancelado la modificación
		    JOptionPane.showMessageDialog(null, "La actualización ha sido cancelada.", "Actualización cancelada", JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tablelistaServicio) {
			mouseClickedTablelistaServicio(e);
		}
	}
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTablelistaServicio(MouseEvent e) {
		 btnActualizarServicio.setEnabled(true);
		    btnRegistroServicio.setEnabled(false);
		    btnEliminarServicio.setEnabled(true);
		    int fila = tablelistaServicio.rowAtPoint(e.getPoint());

		    // Obtener los valores del registro seleccionado en la tabla
		    String id = tablelistaServicio.getValueAt(fila, 0).toString();
		    String mantenimiento = tablelistaServicio.getValueAt(fila, 1).toString();
		    String kilometraje = tablelistaServicio.getValueAt(fila, 2).toString().replace(" Mil", ""); // Eliminar " Mil" del valor
		    String descripcion = tablelistaServicio.getValueAt(fila, 3).toString();
		    String estado = tablelistaServicio.getValueAt(fila, 4).toString();

		    // Establecer los valores en los campos correspondientes
		    txtKilometraje.setText(kilometraje);
		    cboDescripcion.setSelectedItem(descripcion);
		    cboEstado.setSelectedItem(estado);
		    cboServicio.setSelectedItem(mantenimiento);
		    txtId.setText(id);

	}
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		
		
		btnRegistroServicio.setEnabled(true);
		btnActualizarServicio.setEnabled(false);
		btnEliminarServicio.setEnabled(false);

		LimpiarServicio();
	}
	
	
	 private void LimpiarServicio() {
		 	txtId.setText("");
	        txtKilometraje.setText("");
	        cboServicio.setSelectedIndex(0);
	        cboEstado.setSelectedIndex(0);
	        cboDescripcion.setSelectedIndex(0);

	    }
	protected void actionPerformedBtnEliminarServicio(ActionEvent e) {
		
		if (!"".equals(txtId.getText())) {
		    int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
		    if (pregunta == 0) {
		            int id = Integer.parseInt(txtId.getText());
		            serdao.EliminarServicio(id);
		            LimpiarServicio();
		            
		            cargarTabla();
		        
		    }
		}
		
	}
}
