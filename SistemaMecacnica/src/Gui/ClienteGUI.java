package Gui;

import javax.swing.JPanel;
import javax.swing.JTextField;

import Modelo.Cliente;
import Modelo.ClienteDao;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class ClienteGUI extends JPanel implements ActionListener, MouseListener {

	private static final long serialVersionUID = 1L;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtDireccion;
	private JTextField txtTelefono;
	private JButton btnRegistrarCliente;
    private JTextField txtId;
    private JScrollPane scrollPane;
    private JPanel jpanelRegistroCliente;
    private JTable tableListaClientes;
    
    DefaultTableModel modelo = new DefaultTableModel();

    
    
    
    
    
    
    
 Cliente cli = new Cliente ();
    ClienteDao clidao = new ClienteDao ();
    private JButton btnEliminarCliente;
    private JButton btnModificarCliente;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JButton btnLimpiar;
	/**
	 * Create the panel.
	 */
	public ClienteGUI() {
		
		setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(378, 85, 650, 649);
		add(scrollPane);
		
		tableListaClientes = new JTable();
		tableListaClientes.addMouseListener(this);
		tableListaClientes.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Dni", "Nombre", "Direccion", "Telefono"
			}
		));
		scrollPane.setViewportView(tableListaClientes);
		
		jpanelRegistroCliente = new JPanel();
		jpanelRegistroCliente.setBounds(10, 85, 351, 654);
		add(jpanelRegistroCliente);
		jpanelRegistroCliente.setLayout(null);
		
		txtId = new JTextField();
		txtId.setBounds(145, 102, 86, 20);
		jpanelRegistroCliente.add(txtId);
		txtId.setColumns(10);
		txtDni = new JTextField();
		txtDni.setBounds(145, 133, 185, 32);
		jpanelRegistroCliente.add(txtDni);
		txtDni.setColumns(10);
		txtId.setVisible(false);

		txtNombre = new JTextField();
		txtNombre.setBounds(145, 176, 185, 32);
		jpanelRegistroCliente.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(145, 219, 185, 32);
		jpanelRegistroCliente.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(145, 262, 185, 32);
		jpanelRegistroCliente.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnRegistrarCliente = new JButton("Registrar");
		btnRegistrarCliente.setBounds(29, 364, 100, 32);
		jpanelRegistroCliente.add(btnRegistrarCliente);
		
		btnEliminarCliente = new JButton("Eliminar");
		btnEliminarCliente.addActionListener(this);
		btnEliminarCliente.setBounds(204, 364, 100, 32);
		jpanelRegistroCliente.add(btnEliminarCliente);
		
		btnModificarCliente = new JButton("Modificar");
		btnModificarCliente.addActionListener(this);
		btnModificarCliente.setBounds(29, 421, 100, 32);
		jpanelRegistroCliente.add(btnModificarCliente);
		
		lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBounds(29, 142, 46, 14);
		jpanelRegistroCliente.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("NOMBRE");
		lblNewLabel_1.setBounds(29, 185, 86, 14);
		jpanelRegistroCliente.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("DIRECCION");
		lblNewLabel_2.setBounds(29, 228, 71, 14);
		jpanelRegistroCliente.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("TELEFONO");
		lblNewLabel_3.setBounds(29, 271, 71, 14);
		jpanelRegistroCliente.add(lblNewLabel_3);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(203, 421, 101, 32);
		jpanelRegistroCliente.add(btnLimpiar);
		btnRegistrarCliente.addActionListener(this);
		
        ListarCliente();


	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnEliminarCliente) {
			actionPerformedBtnEliminarCliente(e);
		}
		if (e.getSource() == btnModificarCliente) {
			actionPerformedBtnModificarCliente(e);
		}
		if (e.getSource() == btnRegistrarCliente) {
			actionPerformedBtnRegistrarCliente(e);
		}
	}
	protected void actionPerformedBtnRegistrarCliente(ActionEvent e) {
		
		
		  String dni = txtDni.getText();
		    String nombre = txtNombre.getText();
		    String telefono = txtTelefono.getText();
		    String direccion = txtDireccion.getText();

		    // Verificar si algún campo está vacío
		    if ("".equals(dni) || "".equals(nombre) || "".equals(telefono) || "".equals(direccion)) {
		        JOptionPane.showMessageDialog(null, "Todos los campos deben completarse");
		    } else if (dni.length() != 8) { // Verificar longitud del DNI
		        JOptionPane.showMessageDialog(null, "El DNI debe tener 8 dígitos");
		    } else if (telefono.length() != 9) { // Verificar longitud del número de teléfono
		        JOptionPane.showMessageDialog(null, "El número de teléfono debe tener 9 dígitos");
		    } else {
		        // Verificar si el DNI ya está en la lista de clientes
		        boolean dniExistente = false;
		        for (int i = 0; i < tableListaClientes.getRowCount(); i++) {
		            String dniTabla = tableListaClientes.getValueAt(i, 1).toString();
		            if (dni.equals(dniTabla)) {
		                dniExistente = true;
		                break;
		            }
		        }
		        if (dniExistente) {
		            JOptionPane.showMessageDialog(null, "El DNI ya está registrado");
		        } else {
		            // Registrar el cliente si todas las validaciones son exitosas
		            cli.setDni(dni);
		            cli.setNombre(nombre);
		            cli.setTelefono(telefono);
		            cli.setDireccion(direccion);
		            clidao.RegistrarCliente(cli);
		            JOptionPane.showMessageDialog(null, "Cliente Registrado");
		            LimpiarTable();
		            LimpiarCliente();
		            ListarCliente();
		            btnModificarCliente.setEnabled(false);
		            btnEliminarCliente.setEnabled(false);
		            btnRegistrarCliente.setEnabled(true);
		        }
		    }
		
		
		
	}
	
protected void actionPerformedBtnModificarCliente(ActionEvent e) {
	 if ("".equals(txtId.getText())) {
	        JOptionPane.showMessageDialog(null, "Seleccione una fila");
	    } else {
	        if ("".equals(txtDni.getText()) || "".equals(txtNombre.getText()) || "".equals(txtTelefono.getText()) || "".equals(txtDireccion.getText())) {
	            JOptionPane.showMessageDialog(null, "Debe completar todos los campos");
	        } else {
	            cli.setDni(txtDni.getText());
	            cli.setNombre(txtNombre.getText());
	            cli.setTelefono(txtTelefono.getText());
	            cli.setDireccion(txtDireccion.getText());
	            cli.setIdCliente(Integer.parseInt(txtId.getText()));
	            clidao.ModificarCliente(cli);
	            JOptionPane.showMessageDialog(null, "Cliente Modificado");
	            LimpiarTable();
	            LimpiarCliente();
	            ListarCliente();
	        }
	    }
	}
	
	protected void actionPerformedBtnEliminarCliente(ActionEvent e) {
		
		if (!"".equals(txtId.getText())) {
		    int pregunta = JOptionPane.showConfirmDialog(null, "¿Está seguro de eliminar?");
		    if (pregunta == 0) {
		        int confirmacionBorrarRegistros = JOptionPane.showConfirmDialog(null, "Esta acción eliminará todos los vehiculos  relacionados con este cliente. ¿Desea continuar?");
		        if (confirmacionBorrarRegistros == 0) {
		            int id = Integer.parseInt(txtId.getText());
		            clidao.EliminarCliente(id);
		            LimpiarTable();
		            LimpiarCliente();
		            ListarCliente();
		        }
		    }
		}
	}
	
	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		LimpiarCliente();
        btnModificarCliente.setEnabled(false);
        btnEliminarCliente.setEnabled(false);
        btnRegistrarCliente.setEnabled(true);
	}
	
	 private void LimpiarCliente() {
	        txtId.setText("");
	        txtDni.setText("");
	        txtNombre.setText("");
	        txtTelefono.setText("");
	        txtDireccion.setText("");
	    }
	 public void LimpiarTable() {
	        for (int i = 0; i < modelo.getRowCount(); i++) {
	            modelo.removeRow(i);
	            i = i - 1;
	        }
	    }
	  public void ListarCliente() {
	        List<Cliente> ListarCl = clidao.ListarCliente();
	        modelo = (DefaultTableModel) tableListaClientes.getModel();
	        Object[] ob = new Object[6];
	        for (int i = 0; i < ListarCl.size(); i++) {
	            ob[0] = ListarCl.get(i).getIdCliente();
	            ob[1] = ListarCl.get(i).getDni();
	            ob[2] = ListarCl.get(i).getNombre();
	            ob[3] = ListarCl.get(i).getDireccion();
	            ob[4] = ListarCl.get(i).getTelefono();
	            modelo.addRow(ob);
	        }
	        tableListaClientes.setModel(modelo);

	    }

	 
	 
	
	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tableListaClientes) {
			mouseClickedTableListaClientes(e);
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
	protected void mouseClickedTableListaClientes(MouseEvent e) {
		btnModificarCliente.setEnabled(true);
		 btnEliminarCliente.setEnabled(true);
         btnRegistrarCliente.setEnabled(false);
	       
	        int fila = tableListaClientes.rowAtPoint(e.getPoint());
	        txtId.setText(tableListaClientes.getValueAt(fila, 0).toString());
	        txtDni.setText(tableListaClientes.getValueAt(fila, 1).toString());
	        txtNombre.setText(tableListaClientes.getValueAt(fila, 2).toString());
	        txtDireccion.setText(tableListaClientes.getValueAt(fila, 3).toString());
	        txtTelefono.setText(tableListaClientes.getValueAt(fila, 4).toString());
		
	}
	
}
