package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;

public class Pregunta1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cboMarca;
	private JTextField txtCantidad;
	private JTextArea txaResultado;
	private JButton btnProcesar;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pregunta1 frame = new Pregunta1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Pregunta1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboMarca = new JComboBox();
		cboMarca.setModel(new DefaultComboBoxModel(new String[] {"DAKAR 433 NEGRO", "MERIDIAN 360 NEGRO", "FIDLLER LAPTOP 16 NARANJA", "AMERICAN TOURISTER"}));
		cboMarca.setBounds(74, 11, 177, 22);
		contentPane.add(cboMarca);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(74, 44, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txaResultado = new JTextArea();
		txaResultado.setBounds(10, 82, 414, 168);
		contentPane.add(txaResultado);
		
		btnProcesar = new JButton("PROCESAR");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(305, 15, 104, 38);
		contentPane.add(btnProcesar);
		
		lblNewLabel = new JLabel("Marcas");
		lblNewLabel.setBounds(10, 15, 54, 14);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Cantidad");
		lblNewLabel_1.setBounds(10, 47, 54, 14);
		contentPane.add(lblNewLabel_1);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		
		txaResultado.setText("");
		int cantidad ;
		int marca ;
		double precio = 0,descuento = 0,icompra,idescuento,ipagar;
		String obsequio;
		
			marca = cboMarca.getSelectedIndex();
			cantidad = Integer.parseInt(txtCantidad.getText());
			
			switch(marca){
				case 0: precio = 459.5 ;break; 
				case 1: precio = 279.8 ;break; 
				case 2: precio = 69.0 ;break; 
				case 3: precio = 299.8 ;break; 
			}
			
			icompra = precio*cantidad ; 
			
			if (cantidad <=2) {
				descuento = 0.02;
			}else if (cantidad > 2 && cantidad <= 10) {
				descuento = 0.06;
			}else if (cantidad>10 && cantidad <=15) {
				descuento = 0.083;
			}else if (cantidad > 15) {
				descuento = 0.106;
			}
			
			idescuento = icompra * descuento ;
			ipagar = icompra - idescuento;
		
			
			if (cantidad > 5) {
				obsequio = "Cartuchera";
			}else {
				obsequio = "Mousepad";
			}
			
			txaResultado.append("El importe de compra es :"+icompra+"\n");
			txaResultado.append("El importe de descuento es :"+idescuento+"\n");
			txaResultado.append("El importe a pagar es :"+ipagar+"\n");
			txaResultado.append("El obsequio es :"+obsequio+"\n");

	}
}
