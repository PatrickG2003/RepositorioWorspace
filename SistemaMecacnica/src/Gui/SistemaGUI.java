package Gui;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Color;

public class SistemaGUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private final JPanel panel_1 = new JPanel();
	private JButton btnVehiculos;
	private JButton btnClientes;
	private JButton btnMantenimiento;
	private JButton btnPreventivo;
	private JTabbedPane principal;
	public String p1 = "0";
	public String p2 = "0";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SistemaGUI frame = new SistemaGUI();
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
	public SistemaGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1240, 898);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 1224, 81);
		contentPane.add(panel);
		panel_1.setBounds(0, 80, 171, 779);
		contentPane.add(panel_1);
		
		btnVehiculos = new JButton("VEHICULOS");
		btnVehiculos.addActionListener(this);
		btnVehiculos.setBounds(0, 0, 171, 50);
		panel_1.setLayout(null);
		panel_1.add(btnVehiculos);
		
		btnClientes = new JButton("CLIENTES");
		btnClientes.addActionListener(this);
		btnClientes.setBounds(0, 49, 171, 50);
		panel_1.add(btnClientes);
		
		btnMantenimiento = new JButton("Mantenimiento");
		btnMantenimiento.setBounds(0, 97, 171, 50);
		panel_1.add(btnMantenimiento);
		
		btnPreventivo = new JButton("PREVENTIVO");
		btnPreventivo.setBounds(0, 146, 171, 50);
		panel_1.add(btnPreventivo);
		
		principal = new JTabbedPane(JTabbedPane.TOP);
		principal.setBounds(170, 0, 1054, 859);
		contentPane.add(principal);
	}
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClientes) {
			actionPerformedBtnClientes(e);
		}
		if (e.getSource() == btnVehiculos) {
			actionPerformedBtnVehiculos(e);
		}
	}
	protected void actionPerformedBtnVehiculos(ActionEvent e) {
		p1="0";
		VehiculoGUI v=new VehiculoGUI();
		if(p1.equals( "0")) {
		principal.addTab("Vehiculo ", v);
		principal.setSelectedComponent(v);
		}else {
			principal.setSelectedComponent(v);
		}
		p1 = "1";

		
	}
	
	
	
	protected void actionPerformedBtnClientes(ActionEvent e) {
		p2="0";

		ClienteGUI c=new ClienteGUI();
		if(p2.equals( "0")) {
		principal.addTab("Vehiculo ", c);
		principal.setSelectedComponent(c);
		}else {
			principal.setSelectedComponent(c);

		}
		p2 = "1";
		
	}
}
