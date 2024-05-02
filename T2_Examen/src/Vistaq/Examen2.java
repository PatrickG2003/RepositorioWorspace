package Vistaq;


import java.awt.BorderLayout;
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

public class Examen2 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox cboMarca;
	private JTextField txtCantidad;
	private JTextArea txaResultado;
	private JButton btnProcesar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen2 frame = new Examen2();
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
	public Examen2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cboMarca = new JComboBox();
		cboMarca.setBounds(33, 27, 127, 22);
		contentPane.add(cboMarca);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(33, 60, 86, 20);
		contentPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		txaResultado = new JTextArea();
		txaResultado.setBounds(10, 93, 414, 157);
		contentPane.add(txaResultado);
		
		btnProcesar = new JButton("PROCESAR");
		btnProcesar.addActionListener(this);
		btnProcesar.setBounds(315, 41, 89, 23);
		contentPane.add(btnProcesar);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnProcesar) {
			actionPerformedBtnProcesar(e);
		}
	}
	protected void actionPerformedBtnProcesar(ActionEvent e) {
		
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
			txaResultado.append("El importe de compra es :"+idescuento+"\n");
			txaResultado.append("El importe de compra es :"+ipagar+"\n");
			txaResultado.append("El importe de compra es :"+obsequio+"\n");

		
	}
}
