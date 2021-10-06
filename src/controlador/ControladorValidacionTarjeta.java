package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import modelo.Cliente;
import vista.VentanaPaquetes;
import vista.VentanaValidacionTarjeta;

public class ControladorValidacionTarjeta implements ActionListener{
	
	
	VentanaPaquetes ventanaPaquetes;
	VentanaValidacionTarjeta ventanaValidacionTarjeta;
	ControladorPaquetes controladorPaquetes;
	Cliente cliente;
	
	ControladorValidacionTarjeta(VentanaValidacionTarjeta ventanaValidacionTarjeta, VentanaPaquetes ventanaPaquetes, ControladorPaquetes controladorPaquetes, Cliente cliente){
		this.ventanaPaquetes=ventanaPaquetes;
		this.ventanaValidacionTarjeta=ventanaValidacionTarjeta;
		this.controladorPaquetes=controladorPaquetes;
		this.cliente=cliente;
		this.ventanaValidacionTarjeta.btnRegresar.addActionListener(this);
		this.ventanaValidacionTarjeta.btnValidarPagoTarjeta.addActionListener(this);
		this.ventanaValidacionTarjeta.textFieldNombre.setText(cliente.getNombreCliente() + cliente.getApellidosCliente());
		this.ventanaValidacionTarjeta.textFieldMontoPagar.setText(ventanaPaquetes.textFieldTotalVenta.getText());
	
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == ventanaValidacionTarjeta.btnRegresar) {
			ventanaPaquetes.setVisible(true);
			ventanaValidacionTarjeta.dispose();
		}
		
		if(e.getSource() == ventanaValidacionTarjeta.btnValidarPagoTarjeta) {
			String ent = retornarEntidadTarjeta() ;
			String tipoTarjeta = retornarTipoTarjeta();
			String nombre = ventanaValidacionTarjeta.textFieldNombre.getText(); 
			String numero = ventanaValidacionTarjeta.textFieldNumeroTarjeta.getText();
			String digitosV = ventanaValidacionTarjeta.textFieldDigitosVerificacion.getText();
			String fechaV = ventanaValidacionTarjeta.textFieldFechaVencimiento.getText();
			double cantidadPagar = Double.parseDouble(ventanaValidacionTarjeta.textFieldMontoPagar.getText());
			
			boolean resultadoValidacion = validarTarjeta(ent, tipoTarjeta,nombre,numero, digitosV, fechaV, cantidadPagar );
			
			if(resultadoValidacion) {
				JOptionPane.showMessageDialog(null, "Transacción aprobada");
				controladorPaquetes.verificacionTarjeta = true;
				ventanaPaquetes.setVisible(true);
				ventanaValidacionTarjeta.dispose();
			}
			
			
			
		}
	}
	
	
	public boolean validarTarjeta(String entidad, String tipo, String nombre, String numero, String digitosVerificacion, String fechaVencimiento, double cantidadPagar) {
		boolean validar=true;
		
		return validar;
	}
	
	
	public String retornarEntidadTarjeta() {
		String entidad="";
		
		if(ventanaValidacionTarjeta.rdbtnAmericanExpress.isSelected()) {
			entidad="americanExpress";
		}else {
			if(ventanaValidacionTarjeta.rdbtnMasterCard.isSelected()) {
				entidad="masterCard";
			}else {
				if(ventanaValidacionTarjeta.rdbtnVisa.isSelected()) {
					entidad="visa";
				}
			}
			
		}
		
		return entidad;
	}
	
	
	public String retornarTipoTarjeta() {
		String tipo="";
		
		if(ventanaValidacionTarjeta.rdbtnDebito.isSelected()) {
			tipo="debito";
		}else {
			if(ventanaValidacionTarjeta.rdbtnCredito.isSelected()) {
				tipo="credito";
			}
		}
		
		return tipo;
	}

}
