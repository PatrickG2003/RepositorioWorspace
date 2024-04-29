package Modelo;

public class Vehiculo {
private int idVehiculo;
private String placa;
private String modelo ;
private String marca;
private String numeroChasis;
private String numeroMotor;
private String vin;
private String color;
private int anio ; 
private String cilindrada;
private String combustible ; 
private double kilometraje;
private int cliente;

public Vehiculo() {
	super();
}

public int getCliente() {
	return cliente;
}

public void setCliente(int cliente) {
	this.cliente = cliente;
}

public Vehiculo(int idVehiculo, String placa, String modelo, String marca, String numeroChasis, String numeroMotor,
		String vin, String color, int anio, String cilindrada, String combustible, double kilometraje, int cliente) {
	super();
	this.idVehiculo = idVehiculo;
	this.placa = placa;
	this.modelo = modelo;
	this.marca = marca;
	this.numeroChasis = numeroChasis;
	this.numeroMotor = numeroMotor;
	this.vin = vin;
	this.color = color;
	this.anio = anio;
	this.cilindrada = cilindrada;
	this.combustible = combustible;
	this.kilometraje = kilometraje;
	this.cliente = cliente;
}

public int getIdVehiculo() {
	return idVehiculo;
}
public void setIdVehiculo(int idVehiculo) {
	this.idVehiculo = idVehiculo;
}
public String getPlaca() {
	return placa;
}
public void setPlaca(String placa) {
	this.placa = placa;
}
public String getModelo() {
	return modelo;
}
public void setModelo(String modelo) {
	this.modelo = modelo;
}
public String getMarca() {
	return marca;
}
public void setMarca(String marca) {
	this.marca = marca;
}
public String getNumeroChasis() {
	return numeroChasis;
}
public void setNumeroChasis(String numeroChasis) {
	this.numeroChasis = numeroChasis;
}
public String getNumeroMotor() {
	return numeroMotor;
}
public void setNumeroMotor(String numeroMotor) {
	this.numeroMotor = numeroMotor;
}
public String getVin() {
	return vin;
}
public void setVin(String vin) {
	this.vin = vin;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
public int getAnio() {
	return anio;
}
public void setAnio(int anio) {
	this.anio = anio;
}
public String getCilindrada() {
	return cilindrada;
}
public void setCilindrada(String cilindrada) {
	this.cilindrada = cilindrada;
}
public String getCombustible() {
	return combustible;
}
public void setCombustible(String combustible) {
	this.combustible = combustible;
}
public double getKilometraje() {
	return kilometraje;
}
public void setKilometraje(double kilometraje) {
	this.kilometraje = kilometraje;
}

















}
