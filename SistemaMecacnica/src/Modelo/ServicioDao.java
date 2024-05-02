package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ServicioDao {
	
			 Conexion cn = new Conexion();
			    Connection con;
			    PreparedStatement ps;
			    ResultSet rs;
	   public boolean RegistrarServicio(Servicio se){
	        String sql = "INSERT INTO servicio (mantenimiento, kilometraje, descripcion, estado,Vehiculo_idVehiculo) VALUES (?,?,?,?,?)";
	        try {
	            con = cn.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setString(1, se.getMantenimiento());
	            ps.setString(2, se.getKilometraje());
	            ps.setString(3, se.getDescripcion());
	            ps.setString(4, se.getEstado());
	            ps.setInt(5, se.getVehiculo());

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
	 

	   public List<Servicio> ListarServicioPorVehiculo(int vehiculo){
	        List<Servicio> ListaServicio = new ArrayList();
	        String sql = "SELECT * FROM servicio WHERE Vehiculo_idVehiculo = ?";
	        try {
	            con = cn.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setInt(1, vehiculo);
	            rs = ps.executeQuery();
	            while (rs.next()) {               
	     		   Servicio se = new Servicio();
	     		    se.setId(rs.getInt("idServicio"));
	            	se.setMantenimiento(rs.getString("mantenimiento"));
	            	se.setKilometraje(rs.getString("kilometraje"));
	            	se.setDescripcion(rs.getString("descripcion"));
	            	se.setEstado(rs.getString("estado"));
	            	se.setVehiculo(rs.getInt("Vehiculo_idVehiculo"));
	            	ListaServicio.add(se);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	        }
	        return ListaServicio;
	    }
	   
	   public boolean ModificarServicio(Servicio se){
	        String sql = "UPDATE servicio SET mantenimiento=?, kilometraje=?, descripcion=?, estado=? WHERE idServicio=?";
	        try {
	            ps = con.prepareStatement(sql);   
	            ps.setString(1, se.getMantenimiento());
	            ps.setString(2, se.getKilometraje());
	            ps.setString(3, se.getDescripcion());
	            ps.setString(4, se.getEstado());
	            ps.setInt(5, se.getId());
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
	   
	   public boolean EliminarServicio(int id){
	        String sql = "DELETE FROM servicio WHERE idServicio = ?";
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
	   
	   
	   
}
