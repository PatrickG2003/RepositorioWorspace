package Gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import Modelo.Vehiculo;
import Modelo.VehiculoDao;
import Modelo.Cliente;
import Modelo.ClienteDao;
import javax.swing.JTable;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Frame;

public class VehiculoGUI extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtPlaca;
	private JTextField txtModelo;
	private JTextField txtMarca;
	private JTextField txtChasis;
	private JTextField txtMotor;
	private JTextField txtVin;
	private JTextField txtColor;
	private JTextField txtAnio;
	private JTextField txtCilindrada;
	private JTextField txtCombustible;
	private JTextField txtKilometraje;
	private JTextField txtIdVehiculo;
	private JLabel PLACA;
	private JLabel lblModelo;
	private JLabel lblMarca;
	private JLabel lblNumeroDeChasis;
	private JLabel lblNumeroDeMotor;
	private JLabel lblVin;
	private JLabel lblColor;
	private JLabel lblAnio;
	private JLabel lblCilindrada;
	private JLabel lblCombustible;
	private JLabel lblKilometrjae;
	private JLabel lblCliente;
	private JComboBox cboCliente;
	private JButton btnRegistrarVehiculo;
	private JButton btnModificarVehiculo;
	private JButton btnEliminarVehiculo;
	private JButton btnLimpiarVehiculo;
	private JScrollPane scrollPane;
    DefaultTableModel modelo = new DefaultTableModel();

	Vehiculo veh = new Vehiculo();
	VehiculoDao vehdao = new VehiculoDao();
	Cliente cli = new Cliente();
	ClienteDao clidao = new ClienteDao();
	private JTable tableListaVehiculo;
	private JButton btnMostrarInformacion;

	/**
	 * Create the panel.
	 */
	public VehiculoGUI() {
		setLayout(null);

		txtPlaca = new JTextField();
		txtPlaca.setBounds(114, 96, 128, 26);
		add(txtPlaca);
		txtPlaca.setColumns(10);

		txtModelo = new JTextField();
		txtModelo.setColumns(10);
		txtModelo.setBounds(114, 133, 128, 26);
		add(txtModelo);

		txtMarca = new JTextField();
		txtMarca.setColumns(10);
		txtMarca.setBounds(114, 170, 128, 26);
		add(txtMarca);

		txtChasis = new JTextField();
		txtChasis.setColumns(10);
		txtChasis.setBounds(114, 207, 128, 26);
		add(txtChasis);

		txtMotor = new JTextField();
		txtMotor.setColumns(10);
		txtMotor.setBounds(114, 244, 128, 26);
		add(txtMotor);

		txtVin = new JTextField();
		txtVin.setColumns(10);
		txtVin.setBounds(114, 281, 128, 26);
		add(txtVin);

		txtColor = new JTextField();
		txtColor.setColumns(10);
		txtColor.setBounds(114, 318, 128, 26);
		add(txtColor);

		txtAnio = new JTextField();
		txtAnio.setColumns(10);
		txtAnio.setBounds(114, 355, 128, 26);
		add(txtAnio);

		txtCilindrada = new JTextField();
		txtCilindrada.setColumns(10);
		txtCilindrada.setBounds(114, 392, 128, 26);
		add(txtCilindrada);

		txtCombustible = new JTextField();
		txtCombustible.setColumns(10);
		txtCombustible.setBounds(333, 94, 128, 26);
		add(txtCombustible);

		txtKilometraje = new JTextField();
		txtKilometraje.setColumns(10);
		txtKilometraje.setBounds(333, 131, 128, 26);
		add(txtKilometraje); 

		txtIdVehiculo = new JTextField();
		txtIdVehiculo.setColumns(10);
		txtIdVehiculo.setBounds(114, 58, 128, 26);
		add(txtIdVehiculo);
		txtIdVehiculo.setVisible(false);
		PLACA = new JLabel("PLACA");
		PLACA.setBounds(31, 96, 46, 14);
		add(PLACA);

		lblModelo = new JLabel("MODELO");
		lblModelo.setBounds(31, 133, 73, 14);
		add(lblModelo);

		lblMarca = new JLabel("MARCA");
		lblMarca.setBounds(31, 170, 46, 14);
		add(lblMarca);

		lblNumeroDeChasis = new JLabel("NUMERO DE CHASIS");
		lblNumeroDeChasis.setBounds(10, 213, 140, 20);
		add(lblNumeroDeChasis);

		lblNumeroDeMotor = new JLabel("NUMERO DE MOTOR");
		lblNumeroDeMotor.setBounds(10, 236, 140, 43);
		add(lblNumeroDeMotor);

		lblVin = new JLabel("VIN");
		lblVin.setBounds(41, 284, 63, 20);
		add(lblVin);

		lblColor = new JLabel("COLOR");
		lblColor.setBounds(31, 324, 46, 14);
		add(lblColor);

		lblAnio = new JLabel("ANIO");
		lblAnio.setBounds(41, 361, 46, 14);
		add(lblAnio);

		lblCilindrada = new JLabel("CILINDRADA");
		lblCilindrada.setBounds(20, 398, 84, 14);
		add(lblCilindrada);

		lblCombustible = new JLabel("COMBUSTIBLE");
		lblCombustible.setBounds(254, 100, 90, 14);
		add(lblCombustible);

		lblKilometrjae = new JLabel("KILOMETRAJE");
		lblKilometrjae.setBounds(255, 137, 89, 14);
		add(lblKilometrjae);

		lblCliente = new JLabel("CLIENTE");
		lblCliente.setBounds(269, 176, 46, 14);
		add(lblCliente);

		cboCliente = new JComboBox();
		cboCliente.setBounds(333, 170, 128, 26);
		add(cboCliente);

		btnRegistrarVehiculo = new JButton("REGISTRAR");
		btnRegistrarVehiculo.addActionListener(this);
		btnRegistrarVehiculo.setBounds(41, 447, 109, 35);
		add(btnRegistrarVehiculo);

		btnModificarVehiculo = new JButton("ACTUALIZAR");
		btnModificarVehiculo.addActionListener(this);
		btnModificarVehiculo.setBounds(190, 447, 109, 35);
		add(btnModificarVehiculo);

		btnEliminarVehiculo = new JButton("ELIMINAR");
		btnEliminarVehiculo.addActionListener(this);
		btnEliminarVehiculo.setBounds(41, 493, 109, 35);
		add(btnEliminarVehiculo);

		btnLimpiarVehiculo = new JButton("LIMPIAR");
		btnLimpiarVehiculo.addActionListener(this);
		btnLimpiarVehiculo.setBounds(190, 493, 109, 35);
		add(btnLimpiarVehiculo);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(471, 63, 573, 710);
		add(scrollPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		tableListaVehiculo = new JTable();
		tableListaVehiculo.addMouseListener(this);
		tableListaVehiculo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "PLACA", "MODELO", "MARCA", "NUMERO CHASIS", "NUMERO MOTOR", "VIN", "COLOR",
						"ANIO", "CILINDRADA", "COMBUSTIBLE", "KILOMETRAJE", "Cliente" }));
		scrollPane.setViewportView(tableListaVehiculo);
		cargarCombo();
		tableListaVehiculo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		ListarVehiculo();
		
		  btnModificarVehiculo.setEnabled(false);
	        btnEliminarVehiculo.setEnabled(false);
	        btnRegistrarVehiculo.setEnabled(true);

	        btnMostrarInformacion = new JButton("MOSTRAR INFO");
	        btnMostrarInformacion.addActionListener(this);
	        btnMostrarInformacion.setBounds(333, 453, 109, 35);
	        add(btnMostrarInformacion);
	        btnMostrarInformacion.setEnabled(false);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnMostrarInformacion) {
			actionPerformedBtnMostrarInformacion(e);
		}
		if (e.getSource() == btnLimpiarVehiculo) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnEliminarVehiculo) {
			actionPerformedBtnEliminarVehiculo(e);
		}
		if (e.getSource() == btnModificarVehiculo) {
			actionPerformedBtnModificarVehiculo(e);
		}
		if (e.getSource() == btnRegistrarVehiculo) {
			actionPerformedBtnRegistrarVehiculo(e);
		}
	}

	protected void actionPerformedBtnRegistrarVehiculo(ActionEvent e) {
	    // Validar que ningún campo esté vacío
	    if (camposVacios()) {
	        JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    // Validar que la matrícula no esté repetida
	    if (matriculaRepetida(txtPlaca.getText())) {
	        JOptionPane.showMessageDialog(null, "La matrícula ingresada ya existe en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
	        return;
	    }
	    
	    // Obtener el cliente seleccionado
	    String selectedItem = (String) cboCliente.getSelectedItem();
	    String[] partes = selectedItem.split(":");
	    int caracteresAntesDelGuion = Integer.parseInt(partes[0]);

	    // Crear el objeto vehículo con los datos ingresados
	    veh.setAnio(Integer.parseInt(txtAnio.getText()));
	    veh.setNumeroChasis(txtChasis.getText());
	    veh.setCilindrada(txtCilindrada.getText());
	    veh.setColor(txtColor.getText());
	    veh.setCombustible(txtCombustible.getText());
	    veh.setKilometraje(Double.parseDouble(txtKilometraje.getText()));
	    veh.setMarca(txtMarca.getText());
	    veh.setModelo(txtModelo.getText());
	    veh.setNumeroMotor(txtMotor.getText());
	    veh.setPlaca(txtPlaca.getText());
	    veh.setVin(txtVin.getText());
	    veh.setCliente(caracteresAntesDelGuion);

	    // Registrar el vehículo en la base de datos
	    if (vehdao.RegistrarVehiculo(veh)) {
	        JOptionPane.showMessageDialog(null, "Vehículo Registrado");
	        LimpiarTable();
	        LimpiarVehiculo();
	        ListarVehiculo();
	        btnModificarVehiculo.setEnabled(false);
	        btnEliminarVehiculo.setEnabled(false);
	        btnRegistrarVehiculo.setEnabled(true);
	    } else {
	        JOptionPane.showMessageDialog(null, "Error al registrar el vehículo.", "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	

	protected void actionPerformedBtnModificarVehiculo(ActionEvent e) {
		 String selectedItem = (String) cboCliente.getSelectedItem();
	        String[] partes = selectedItem.split(":");
	        int caracteresAntesDelGuion = Integer.parseInt(partes[0]);

		if ("".equals(txtIdVehiculo.getText())) {
	          JOptionPane.showMessageDialog(null, "seleccione una fila");
	      } else {

	    	  if (!"".equals(txtAnio.getText()) || !"".equals(txtChasis.getText()) ||
	 				 !"".equals(txtCilindrada.getText()) ||
	 				 !"".equals(txtColor.getText())||
	 				 !"".equals(txtCombustible.getText())||
	 				 !"".equals(txtKilometraje.getText())||
	 				 !"".equals(txtMarca.getText())||
	 				 !"".equals(txtModelo.getText()) ||
	 				 !"".equals(txtMotor.getText()) ||
	 				 !"".equals(txtPlaca.getText())||
	 				 !"".equals(txtVin.getText())  ) {
	    		  
	    		  veh.setIdVehiculo(Integer.parseInt(txtIdVehiculo.getText()));
	    		  veh.setAnio(Integer.parseInt(txtAnio.getText()));
				 	veh.setNumeroChasis(txtChasis.getText());
				 	veh.setCilindrada(txtCilindrada.getText());
				 	veh.setColor(txtColor.getText());
				 	veh.setCombustible(txtCombustible.getText());
				 	veh.setKilometraje(Double.parseDouble(txtKilometraje.getText()));
				 	veh.setMarca(txtMarca.getText());
				 	veh.setModelo(txtModelo.getText());
				 	veh.setNumeroMotor(txtMotor.getText());
				 	veh.setPlaca(txtPlaca.getText());
				 	veh.setVin(txtVin.getText());
				 	veh.setCliente(caracteresAntesDelGuion);
	    	 
	              vehdao.ModificarVehiculo(veh);
	              JOptionPane.showMessageDialog(null, "Vehiculo Modificado");
	              LimpiarTable();
	              LimpiarVehiculo();
	              ListarVehiculo();
	          } else {
	              JOptionPane.showMessageDialog(null, "Los campos estan vacios");
	          }
	      }
		
		
		
		
		
	}

	protected void actionPerformedBtnEliminarVehiculo(ActionEvent e) {
		
		if (!"".equals(txtIdVehiculo.getText())) {
		    int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
		    if (pregunta == 0) {
		        int confirmacionBorrarRegistros = JOptionPane.showConfirmDialog(null, "Esta acción eliminará todos los registros relacionados con este vehículo. ¿Desea continuar?");
		        if (confirmacionBorrarRegistros == 0) {
		            int id = Integer.parseInt(txtIdVehiculo.getText());
		            vehdao.EliminarVehiculo(id);
		            LimpiarTable();
		            LimpiarVehiculo();
		            ListarVehiculo();
		        }
		    }
		}
	}

	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		
		LimpiarVehiculo();
        btnModificarVehiculo.setEnabled(false);
        btnEliminarVehiculo.setEnabled(false);
        btnRegistrarVehiculo.setEnabled(true);
        btnMostrarInformacion.setEnabled(false);

	}
	
	public void mouseEntered(MouseEvent e) {
	}
	public void mouseExited(MouseEvent e) {
	}
	public void mousePressed(MouseEvent e) {
	}
	public void mouseReleased(MouseEvent e) {
	}
	protected void mouseClickedTableListaVehiculo(MouseEvent e) {
		btnModificarVehiculo.setEnabled(true);
		 btnEliminarVehiculo.setEnabled(true);
        btnRegistrarVehiculo.setEnabled(false);
        btnMostrarInformacion.setEnabled(true);

	        int fila = tableListaVehiculo.rowAtPoint(e.getPoint());
	       
	    	txtIdVehiculo.setText(tableListaVehiculo.getValueAt(fila, 0).toString());
			txtAnio.setText(tableListaVehiculo.getValueAt(fila, 8).toString());
			txtChasis.setText(tableListaVehiculo.getValueAt(fila, 4).toString());
			txtCilindrada.setText(tableListaVehiculo.getValueAt(fila, 9).toString());
			txtColor.setText(tableListaVehiculo.getValueAt(fila, 7).toString());
			txtCombustible.setText(tableListaVehiculo.getValueAt(fila, 10).toString());
			txtKilometraje.setText(tableListaVehiculo.getValueAt(fila, 11).toString());
			txtMarca.setText(tableListaVehiculo.getValueAt(fila, 3).toString());
			txtModelo.setText(tableListaVehiculo.getValueAt(fila, 2).toString());
			txtMotor.setText(tableListaVehiculo.getValueAt(fila, 5).toString());
			txtPlaca.setText(tableListaVehiculo.getValueAt(fila, 1).toString());
			txtVin.setText(tableListaVehiculo.getValueAt(fila, 6).toString());
			
			int stri = (int) tableListaVehiculo.getValueAt(fila, 12);
			
			 for (int i = 0; i < cboCliente.getItemCount(); i++) {
		            String item = (String) cboCliente.getItemAt(i);
		            if (item != null && item.contains(":")) {
		                String[] partes = item.split(":");
		                int numeroEnItem = Integer.parseInt(partes[0].trim());
		                if (numeroEnItem == stri ) {
		                    cboCliente.setSelectedIndex(i);
		                    break;
		                }
		            }
			
			
			 }
			 
	}
	
	
	
	
	
	
	
	public void cargarCombo() {
		List<Cliente> listaClientes = clidao.ListarCliente();

		for (int i = 0; i < listaClientes.size(); i++) {
			cboCliente.addItem(listaClientes.get(i).getIdCliente() + ":" + listaClientes.get(i).getNombre());
		}

	}

	public void LimpiarTable() {
		for (int i = 0; i < modelo.getRowCount(); i++) {
			modelo.removeRow(i);
			i = i - 1;
		}
	}
	private void LimpiarVehiculo() {
		txtIdVehiculo.setText("");
		txtAnio.setText("");
		txtChasis.setText("");
		txtCilindrada.setText("");
		txtColor.setText("");
		txtCombustible.setText("");
		txtKilometraje.setText("");
		txtMarca.setText("");
		txtModelo.setText("");
		txtMotor.setText("");
		txtPlaca.setText("");
		txtVin.setText("");

	}
	public void ListarVehiculo() {
		List<Vehiculo> ListarV = vehdao.ListarVehiculo();
		modelo = (DefaultTableModel) tableListaVehiculo.getModel();
		Object[] ob = new Object[13];
		for (int i = 0; i < ListarV.size(); i++) {
			ob[0] = ListarV.get(i).getIdVehiculo();
			ob[1] = ListarV.get(i).getPlaca();
			ob[2] = ListarV.get(i).getModelo();
			ob[3] = ListarV.get(i).getMarca();
			ob[4] = ListarV.get(i).getNumeroChasis();
			ob[5] = ListarV.get(i).getNumeroMotor();
			ob[6] = ListarV.get(i).getVin();
			ob[7] = ListarV.get(i).getColor();
			ob[8] = ListarV.get(i).getAnio();
			ob[9] = ListarV.get(i).getCilindrada();
			ob[10] = ListarV.get(i).getCombustible();
			ob[11] = ListarV.get(i).getKilometraje();
			ob[12] = ListarV.get(i).getCliente();

			modelo.addRow(ob);
		}
		tableListaVehiculo.setModel(modelo);

	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableListaVehiculo) {
			mouseClickedTableListaVehiculo(e);
		}
	}
	protected void actionPerformedBtnMostrarInformacion(ActionEvent e) {
		  int filaSeleccionada = tableListaVehiculo.getSelectedRow();
		    if (filaSeleccionada != -1) {
		        String placa = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 1);
		        String modelo = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 2);
		        String marca = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 3);
		        String chasis = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 4);
		        String motor = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 5);
		        String vin = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 6);
		        String color = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 7);
		        String anio = String.valueOf(tableListaVehiculo.getValueAt(filaSeleccionada, 8));
		        String cilindrada = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 9);
		        String combustible = (String) tableListaVehiculo.getValueAt(filaSeleccionada, 10);
		        String kilometraje = String.valueOf(tableListaVehiculo.getValueAt(filaSeleccionada, 11));
		        String cliente = String.valueOf(tableListaVehiculo.getValueAt(filaSeleccionada, 12));

		        InformacionVehiculoGUI ventanaInformacion = new InformacionVehiculoGUI(placa, modelo, marca, chasis, motor, vin, color, anio, cilindrada, combustible, kilometraje, cliente);
		        ventanaInformacion.setModal(true);
		        ventanaInformacion.setVisible(true);
		    } else {
		        JOptionPane.showMessageDialog(null, "Por favor, seleccione una fila primero.");
		    }
		  }
	
	// Método para verificar si algún campo está vacío
	private boolean camposVacios() {
	    return txtAnio.getText().isEmpty() || txtChasis.getText().isEmpty() ||
	            txtCilindrada.getText().isEmpty() || txtColor.getText().isEmpty() ||
	            txtCombustible.getText().isEmpty() || txtKilometraje.getText().isEmpty() ||
	            txtMarca.getText().isEmpty() || txtModelo.getText().isEmpty() ||
	            txtMotor.getText().isEmpty() || txtPlaca.getText().isEmpty() ||
	            txtVin.getText().isEmpty();
	}

	// Método para verificar si la matrícula ya está registrada en la base de datos
	private boolean matriculaRepetida(String placa) {
	    List<Vehiculo> listaVehiculos = vehdao.ListarVehiculo();
	    for (Vehiculo v : listaVehiculos) {
	        if (v.getPlaca().equals(placa)) {
	            return true;
	        }
	    }
	    return false;
	}
		
	}

