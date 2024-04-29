package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDao {
	  Connection con;
	    PreparedStatement ps;
	    ResultSet rs;
	    Conexion cn = new Conexion();
	    
	    
	    
	    public Usuario log(String correo, String pass){
	    	Usuario l = new Usuario();
	        String sql = "SELECT * FROM usuario WHERE correo = ? AND pass = ?";
	        try {
	            con = cn.getConnection( );
	            ps = con.prepareStatement(sql);
	            ps.setString(1, correo);
	            ps.setString(2, pass);
	            rs= ps.executeQuery();
	            if (rs.next()) {
	                l.setIdUsuario(rs.getInt("idUsuario"));
	                l.setNombre(rs.getString("nombre"));
	                l.setCorreo(rs.getString("correo"));
	                l.setPass(rs.getString("pass"));
	                l.setRol(rs.getString("rol"));
	                
	            }
	        } catch (SQLException e) {
	            System.out.println(e.toString());
	        }
	        return l;
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
