package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class VehiculoDao {
	 Conexion cn = new Conexion();
	    Connection con;
	    PreparedStatement ps;
	    ResultSet rs;
	    public boolean RegistrarVehiculo(Vehiculo ve){
	        String sql = "INSERT INTO vehiculo (placa, modelo, marca, numeroChasis,numeroMotor,vin,color,anio,cilindrada,combustible,kilometraje,Cliente_idCliente) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
	        try {
	            con = cn.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setString(1, ve.getPlaca());
	            ps.setString(2, ve.getModelo());
	            ps.setString(3, ve.getMarca());
	            ps.setString(4, ve.getNumeroChasis());
	            ps.setString(5, ve.getNumeroMotor());
	            ps.setString(6, ve.getVin());
	            ps.setString(7, ve.getColor());
	            ps.setInt(8, ve.getAnio());
	            ps.setString(9, ve.getCilindrada());
	            ps.setString(10, ve.getCombustible());
	            ps.setDouble(11, ve.getKilometraje());
	            ps.setInt(12, ve.getCliente());

	            ps.execute();
	            return true;
	        } catch (SQLException e) {
	            JOptionPane.showMessageDialog(null, e.toString());
	            return false;
	        }finally{
	            try {
	                con.close();
	            } catch (SQLException e) {
	                System.out.println(e.toString());
	            }
	        }
	    }
	    
	    public List<Vehiculo> ListarVehiculo(){
	        List<Vehiculo> ListaV = new ArrayList();
	        String sql = "SELECT * FROM vehiculo";
	        try {
	            con = cn.getConnection();
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            while (rs.next()) {               
	                Vehiculo ve = new Vehiculo();
	                ve.setIdVehiculo(rs.getInt("idVehiculo"));
	                ve.setPlaca(rs.getString("placa"));
	                ve.setModelo(rs.getString("modelo"));
	                ve.setMarca(rs.getString("marca"));
	                ve.setNumeroChasis(rs.getString("numeroChasis"));
	                ve.setNumeroMotor(rs.getString("numeroMotor"));
	                ve.setVin(rs.getString("vin"));
	                ve.setColor(rs.getString("color"));
	                ve.setAnio(rs.getInt("anio"));
	                ve.setCilindrada(rs.getString("cilindrada"));
	                ve.setCombustible(rs.getString("combustible"));
	                ve.setKilometraje(rs.getDouble("kilometraje"));
	                ve.setCliente(rs.getInt("Cliente_idCliente"));

	                ListaV.add(ve);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	        }
	        return ListaV;
	    }
	    
	    public boolean EliminarVehiculo(int id){
	        String sql = "DELETE FROM vehiculo WHERE idVehiculo = ?";
	        try {
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, id);
	            ps.execute();
	            return true;
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	            return false;
	        }finally{
	            try {
	                con.close();
	            } catch (SQLException ex) {
	                System.out.println(ex.toString());
	            }
	        }
	    }
	    
	    public boolean ModificarVehiculo(Vehiculo ve){
	        String sql = "UPDATE vehiculo SET placa=?, modelo=?, marca=?, numeroChasis=?,numeroMotor=?,vin=?,color=?,anio=?,cilindrada=?,combustible=?,kilometraje=?,Cliente_idCliente=? WHERE idVehiculo=? ";
	        try {
	            ps = con.prepareStatement(sql);   
	         
	            ps.setString(1, ve.getPlaca());
	            ps.setString(2, ve.getModelo());
	            ps.setString(3, ve.getMarca());
	            ps.setString(4, ve.getNumeroChasis());
	            ps.setString(5, ve.getNumeroMotor());
	            ps.setString(6, ve.getVin());
	            ps.setString(7, ve.getColor());
	            ps.setInt(8, ve.getAnio());
	            ps.setString(9, ve.getCilindrada());
	            ps.setString(10, ve.getCombustible());
	            ps.setDouble(11, ve.getKilometraje());
	            ps.setInt(12, ve.getCliente());
	            ps.setInt(13, ve.getIdVehiculo());

	            
	            ps.execute();
	            return true;
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	            return false;
	        }finally{
	            try {
	                con.close();
	            } catch (SQLException e) {
	                System.out.println(e.toString());
	            }
	        }
	    }
	    
	    public Cliente Buscarcliente(int dni){
	        Cliente cl = new Cliente();
	        String sql = "SELECT * FROM cliente WHERE dni = ?";
	        try {
	            con = cn.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, dni);
	            rs = ps.executeQuery();
	            if (rs.next()) {
	                cl.setIdCliente(rs.getInt("idCliente"));
	                cl.setNombre(rs.getString("nombre"));
	                cl.setTelefono(rs.getString("telefono"));
	                cl.setDireccion(rs.getString("direccion"));
	            }
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	        }
	        return cl;
	    }
}
