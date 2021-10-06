package modelo;

import java.sql.Date;

public class Paquete {
	
	int idPaquete;
	Date fecha;
	double valorDeclarado;
	String direccionOrigen;
	String direccionEntrega;
	String codigoPostal;
	double peso;
	String contenido;
	double distancia;
	double valorEnvio;
	double Seguro;
	double impuestos;
	double valorTotalEnvio;
	int idVenta;
	int idCliente;
	int idSede;
	
	public int getIdPaquete() {
		return idPaquete;
	}
	public void setIdPaquete(int idPaquete) {
		this.idPaquete = idPaquete;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getValorDeclarado() {
		return valorDeclarado;
	}
	public void setValorDeclarado(double valorDeclarado) {
		this.valorDeclarado = valorDeclarado;
	}
	public String getDireccionOrigen() {
		return direccionOrigen;
	}
	public void setDireccionOrigen(String direccionOrigen) {
		this.direccionOrigen = direccionOrigen;
	}
	public String getDireccionEntrega() {
		return direccionEntrega;
	}
	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}
	public String getCodigoPostal() {
		return codigoPostal;
	}
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getContenido() {
		return contenido;
	}
	public void setContenido(String contenido) {
		this.contenido = contenido;
	}
	public double getDistancia() {
		return distancia;
	}
	public void setDistancia(double distancia) {
		this.distancia = distancia;
	}
	public double getValorEnvio() {
		return valorEnvio;
	}
	public void setValorEnvio(double valorEnvio) {
		this.valorEnvio = valorEnvio;
	}
	public double getSeguro() {
		return Seguro;
	}
	public void setSeguro(double seguro) {
		Seguro = seguro;
	}
	public double getImpuestos() {
		return impuestos;
	}
	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	public double getValorTotalEnvio() {
		return valorTotalEnvio;
	}
	public void setValorTotalEnvio(double valorTotalEnvio) {
		this.valorTotalEnvio = valorTotalEnvio;
	}
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdSede() {
		return idSede;
	}
	public void setIdSede(int idSede) {
		this.idSede = idSede;
	}
	
	

	
}
