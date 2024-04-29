package Modelo;

public class Usuario {
private int idUsuario;
private String nombre;
private String correo;
private String pass;
private String rol;



public Usuario() {
	super();
}



public Usuario(int idUsuario, String nombre, String correo, String pass, String rol) {
	super();
	this.idUsuario = idUsuario;
	this.nombre = nombre;
	this.correo = correo;
	this.pass = pass;
	this.rol = rol;
}



public int getIdUsuario() {
	return idUsuario;
}



public void setIdUsuario(int idUsuario) {
	this.idUsuario = idUsuario;
}



public String getNombre() {
	return nombre;
}



public void setNombre(String nombre) {
	this.nombre = nombre;
}



public String getCorreo() {
	return correo;
}



public void setCorreo(String correo) {
	this.correo = correo;
}



public String getPass() {
	return pass;
}



public void setPass(String pass) {
	this.pass = pass;
}



public String getRol() {
	return rol;
}



public void setRol(String rol) {
	this.rol = rol;
}





}
