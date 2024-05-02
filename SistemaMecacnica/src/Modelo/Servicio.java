package Modelo;

public class Servicio {

	private int id;
	private String mantenimiento;
	private String kilometraje;
	private String descripcion;
	private String estado;
	private int Vehiculo;
	public Servicio() {
		super();
	}
	public Servicio(int id, String mantenimiento, String kilometraje, String descripcion, String estado, int vehiculo) {
		super();
		this.id = id;
		this.mantenimiento = mantenimiento;
		this.kilometraje = kilometraje;
		this.descripcion = descripcion;
		this.estado = estado;
		Vehiculo = vehiculo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMantenimiento() {
		return mantenimiento;
	}
	public void setMantenimiento(String mantenimiento) {
		this.mantenimiento = mantenimiento;
	}
	public String getKilometraje() {
		return kilometraje;
	}
	public void setKilometraje(String kilometraje) {
		this.kilometraje = kilometraje;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public int getVehiculo() {
		return Vehiculo;
	}
	public void setVehiculo(int vehiculo) {
		Vehiculo = vehiculo;
	}
	
	
	
	
	
	
	
}
