package Gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Modelo.Usuario;
import Modelo.UsuarioDao;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginGUI extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JButton btnLogin;
	private JPasswordField txtPass;

	Usuario u = new Usuario();
	UsuarioDao udao=new UsuarioDao();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
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
	public LoginGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 410, 464);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(116, 37, 86, 20);
		contentPane.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		btnLogin = new JButton("New button");
		btnLogin.addActionListener(this);
		btnLogin.setBounds(116, 120, 89, 23);
		contentPane.add(btnLogin);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(116, 74, 86, 20);
		contentPane.add(txtPass);
	
		  this.setLocationRelativeTo(null);
	        txtCorreo.setText("steve@gmail.com");
	        txtPass.setText("steve");
	}
	 
	 
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnLogin) {
			actionPerformedBtnLogin(e);
		}
	}
	protected void actionPerformedBtnLogin(ActionEvent e) {
		
		validar();
		
	}
	
	 public void validar(){
	        String correo = txtCorreo.getText();
	        String pass = String.valueOf(txtPass.getPassword());
	        if (!"".equals(correo) || !"".equals(pass)) {
	            
	            u = udao.log(correo, pass);
	            if (u.getCorreo()!= null && u.getPass() != null) {
	                SistemaGUI sis = new SistemaGUI();
	                sis.setVisible(true);
	                dispose();
	            }else{
	                JOptionPane.showMessageDialog(null, "Correo o la Contraseña incorrecta");
	            }
	        }
	    }
}
