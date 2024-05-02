package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class ClienteDao {
	 Conexion cn = new Conexion();
	    Connection con;
	    PreparedStatement ps;
	    ResultSet rs;
	    public boolean RegistrarCliente(Cliente cl){
	        String sql = "INSERT INTO cliente (dni, nombre, telefono, direccion) VALUES (?,?,?,?)";
	        try {
	            con = cn.getConnection();
	            ps = con.prepareStatement(sql);
	            ps.setString(1, cl.getDni());
	            ps.setString(2, cl.getNombre());
	            ps.setString(3, cl.getTelefono());
	            ps.setString(4, cl.getDireccion());
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
	    
	    public List<Cliente> ListarCliente(){
	        List<Cliente> ListaCl = new ArrayList();
	        String sql = "SELECT * FROM cliente";
	        try {
	            con = cn.getConnection();
	            ps = con.prepareStatement(sql);
	            rs = ps.executeQuery();
	            while (rs.next()) {               
	                Cliente cl = new Cliente();
	                cl.setIdCliente(rs.getInt("idCliente"));
	                cl.setDni(rs.getString("dni"));
	                cl.setNombre(rs.getString("nombre"));
	                cl.setTelefono(rs.getString("telefono"));
	                cl.setDireccion(rs.getString("direccion"));
	                ListaCl.add(cl);
	            }
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	        }
	        return ListaCl;
	    }
	    
	    public boolean EliminarCliente(int id){
	        String sql = "DELETE FROM cliente WHERE idCliente = ?";
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
	    
	    public boolean ModificarCliente(Cliente cl){
	        String sql = "UPDATE clientes SET dni=?, nombre=?, telefono=?, direccion=? WHERE idCliente=?";
	        try {
	            ps = con.prepareStatement(sql);   
	            ps.setString(1, cl.getDni());
	            ps.setString(2, cl.getNombre());
	            ps.setString(3, cl.getTelefono());
	            ps.setString(4, cl.getDireccion());
	            ps.setInt(5, cl.getIdCliente());
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
