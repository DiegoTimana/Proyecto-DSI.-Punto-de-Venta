package modelo;

import java.sql.Date;

public class Venta {
	
	int idVenta;
	double totalEnvios;
	double totalSeguros;
	double totalImpuestos;
	int idVendedor;
	int idCliente;
	int idSede;
	Date fecha;
	double totalVenta;
	
	public int getIdVenta() {
		return idVenta;
	}
	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}
	public double getTotalEnvios() {
		return totalEnvios;
	}
	public void setTotalEnvios(double totalEnvios) {
		this.totalEnvios = totalEnvios;
	}
	public double getTotalSeguros() {
		return totalSeguros;
	}
	public void setTotalSeguros(double totalSeguros) {
		this.totalSeguros = totalSeguros;
	}
	public double getTotalImpuestos() {
		return totalImpuestos;
	}
	public void setTotalImpuestos(double totalImpuestos) {
		this.totalImpuestos = totalImpuestos;
	}
	public int getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getTotalVenta() {
		return totalVenta;
	}
	public void setTotalVenta(double totalVenta) {
		this.totalVenta = totalVenta;
	}
	
	
	
	

	


}
