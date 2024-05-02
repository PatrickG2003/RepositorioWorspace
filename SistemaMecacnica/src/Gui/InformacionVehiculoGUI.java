package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout.Alignment;

public class InformacionVehiculoGUI extends JDialog  {
    private JLabel lblPlaca, lblModelo, lblMarca, lblChasis, lblMotor, lblVin, lblColor, lblAnio, lblCilindrada, lblCombustible, lblKilometraje, lblCliente;
    private JPanel panel;
    private JPanel panel_1;
    private JLabel lblNewLabel;
    
    public InformacionVehiculoGUI(String placa, String modelo, String marca, String chasis, String motor, String vin, String color, String anio, String cilindrada, String combustible, String kilometraje, String cliente) {
    	getContentPane().setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Información del Vehículo");
        setSize(491, 287);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        panel = new JPanel();
        panel.setBounds(239, 45, 241, 203);
        getContentPane().add(panel);
        panel.setLayout(null);
        
                lblCliente = new JLabel("Cliente:");
                lblCliente.setBounds(20, 136, 89, 12);
                panel.add(lblCliente);
                lblCliente.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                
                        lblKilometraje = new JLabel("Kilometraje:");
                        lblKilometraje.setBounds(20, 114, 89, 12);
                        panel.add(lblKilometraje);
                        lblKilometraje.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                        
                                lblCombustible = new JLabel("Combustible:");
                                lblCombustible.setBounds(20, 92, 89, 12);
                                panel.add(lblCombustible);
                                lblCombustible.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                
                                        lblCilindrada = new JLabel("Cilindrada:");
                                        lblCilindrada.setBounds(20, 70, 89, 12);
                                        panel.add(lblCilindrada);
                                        lblCilindrada.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                        
                                                lblAnio = new JLabel("Año:");
                                                lblAnio.setBounds(20, 48, 89, 12);
                                                panel.add(lblAnio);
                                                lblAnio.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                JLabel label_11 = new JLabel(cliente);
                                                label_11.setBounds(112, 136, 129, 12);
                                                panel.add(label_11);
                                                JLabel label_10 = new JLabel(kilometraje);
                                                label_10.setBounds(112, 114, 129, 12);
                                                panel.add(label_10);
                                                JLabel label_9 = new JLabel(combustible);
                                                label_9.setBounds(112, 92, 129, 12);
                                                panel.add(label_9);
                                                JLabel label_8 = new JLabel(cilindrada);
                                                label_8.setBounds(112, 70, 129, 12);
                                                panel.add(label_8);
                                                JLabel label_7 = new JLabel(anio);
                                                label_7.setBounds(112, 48, 129, 12);
                                                panel.add(label_7);
                                                
                                                        lblColor = new JLabel("Color:");
                                                        lblColor.setBounds(20, 25, 94, 12);
                                                        panel.add(lblColor);
                                                        lblColor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                        JLabel label_6 = new JLabel(color);
                                                        label_6.setBounds(94, 25, 117, 12);
                                                        panel.add(label_6);
                                                
                                                panel_1 = new JPanel();
                                                panel_1.setLayout(null);
                                                panel_1.setBounds(0, 45, 241, 203);
                                                getContentPane().add(panel_1);
                                                
                                                lblPlaca = new JLabel("Placa:");
                                                lblPlaca.setBounds(25, 23, 94, 12);
                                                panel_1.add(lblPlaca);
                                                lblPlaca.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                
                                                        lblModelo = new JLabel("Modelo:");
                                                        lblModelo.setBounds(25, 45, 94, 12);
                                                        panel_1.add(lblModelo);
                                                        lblModelo.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                        
                                                                lblMarca = new JLabel("Marca:");
                                                                lblMarca.setBounds(25, 67, 94, 12);
                                                                panel_1.add(lblMarca);
                                                                lblMarca.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                                
                                                                        lblChasis = new JLabel("Chasis:");
                                                                        lblChasis.setBounds(25, 89, 94, 12);
                                                                        panel_1.add(lblChasis);
                                                                        lblChasis.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                                        
                                                                                lblMotor = new JLabel("Motor:");
                                                                                lblMotor.setBounds(25, 111, 94, 12);
                                                                                panel_1.add(lblMotor);
                                                                                lblMotor.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                                                
                                                                                        lblVin = new JLabel("VIN:");
                                                                                        lblVin.setBounds(25, 133, 94, 12);
                                                                                        panel_1.add(lblVin);
                                                                                        lblVin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
                                                                                                JLabel label_5 = new JLabel(vin);
                                                                                                label_5.setBounds(99, 133, 117, 12);
                                                                                                panel_1.add(label_5);
                                                                                                JLabel label_4 = new JLabel(motor);
                                                                                                label_4.setBounds(99, 111, 117, 12);
                                                                                                panel_1.add(label_4);
                                                                                                JLabel label_3 = new JLabel(chasis);
                                                                                                label_3.setBounds(99, 89, 117, 12);
                                                                                                panel_1.add(label_3);
                                                                                                JLabel label_2 = new JLabel(marca);
                                                                                                label_2.setBounds(99, 67, 117, 12);
                                                                                                panel_1.add(label_2);
                                                                                                JLabel label_1 = new JLabel(modelo);
                                                                                                label_1.setBounds(99, 45, 117, 12);
                                                                                                panel_1.add(label_1);
                                                                                                JLabel label = new JLabel(placa);
                                                                                                label.setBounds(99, 24, 117, 12);
                                                                                                panel_1.add(label);
                                                                                                
                                                                                                lblNewLabel = new JLabel("INFORMACION DEL VEHICULO");
                                                                                                lblNewLabel.setBounds(127, 11, 234, 23);
                                                                                                getContentPane().add(lblNewLabel);

        setVisible(true);
    }
}