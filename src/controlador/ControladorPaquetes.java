package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import modelo.Cliente;
import modelo.ConsultaVenta;
import modelo.Paquete;
import modelo.Reporte;
import modelo.Usuario;
import modelo.Venta;
import vista.VentanaPaquetes;
import vista.VentanaPos;
import vista.VentanaValidacionTarjeta;

public class ControladorPaquetes implements ActionListener, MouseListener {
	
	VentanaPos ventanaPos;
	VentanaPaquetes ventanaPaquetes;
	Cliente cliente;
	Usuario usuario;
	Venta venta;
	Reporte reporte;
	Paquete paquete= new Paquete();
	ControladorPOS controladorPos;
	VentanaValidacionTarjeta ventanaValidacionTarjeta;
	ControladorValidacionTarjeta controladorValidacionTarjeta;
	ConsultaVenta consultaVenta;
	boolean verificacionTarjeta = false;
	boolean verificacionEfectivo=false;
	
	public ControladorPaquetes(VentanaPos ventanaPos, VentanaPaquetes ventanaPaquetes, Usuario usuario, Cliente cliente, ControladorPOS controladorPos) {
		this.ventanaPos=ventanaPos;
		this.ventanaPaquetes=ventanaPaquetes;
		this.usuario=usuario;
		this.cliente=cliente;
		this.controladorPos=controladorPos;
		this.ventanaPaquetes.table.addMouseListener(this);
		this.ventanaPaquetes.textFieldFecha.setText((java.time.LocalDate.now()).toString());
		this.ventanaPaquetes.btnActualizarPaquete.addActionListener(this);
		this.ventanaPaquetes.btnAdicionarPaquete.addActionListener(this);
		this.ventanaPaquetes.btnEliminar.addActionListener(this);
		this.ventanaPaquetes.btnRegresar.addActionListener(this);
		this.ventanaPaquetes.btnCalcularEnvio.addActionListener(this);
		this.ventanaPaquetes.btnCalcularImpuestos.addActionListener(this);
		this.ventanaPaquetes.btnCalcularSeguro.addActionListener(this);
		this.ventanaPaquetes.btnCalcularTotal.addActionListener(this);
		this.ventanaPaquetes.btnObtenerTotales.addActionListener(this);
		this.ventanaPaquetes.btnLimpiar.addActionListener(this);
		this.ventanaPaquetes.btnGenerarRecibo.addActionListener(this);
		this.ventanaPaquetes.btnRegistrarVenta.addActionListener(this);
		this.ventanaPaquetes.btnValidarPagoTarjeta.addActionListener(this);
		this.ventanaPaquetes.btnValidarPagoEfectivo.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaPaquetes.btnAdicionarPaquete) {
			
			int numCols = ventanaPaquetes.table.getModel().getColumnCount();

			Object [] valores = new Object[numCols]; 
			        
			 //poner valores de los textfields en arreglo
			ponerValoresEnArreglo(valores);
			
			 ((DefaultTableModel) ventanaPaquetes.table.getModel()).addRow(valores);
			
			 limpiarCasillasPaquete();
		}
		
		
		if(e.getSource() == ventanaPaquetes.btnActualizarPaquete) {
			
			int fila = ventanaPaquetes.table.getSelectedRow();
			
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldValorDeclarado.getText(), fila, 1);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldDireccionOrigen.getText(), fila, 2);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldDireccionEntrega.getText(), fila, 3);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldDireccionCodigoPostal.getText(), fila, 4);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldPeso.getText(), fila, 5);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldContenido.getText(), fila, 6);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldDistancia.getText(), fila, 7);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldValorEnvio.getText(), fila, 8);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldSeguro.getText(), fila, 9);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldImpuestoEnvio.getText(), fila, 10);
			ventanaPaquetes.table.getModel().setValueAt(ventanaPaquetes.textFieldTotalEnvio.getText(), fila, 11);
			
		}
		
		
		if(e.getSource() == ventanaPaquetes.btnEliminar) {
			
			((DefaultTableModel) ventanaPaquetes.table.getModel()).removeRow(ventanaPaquetes.table.getSelectedRow());
			
		}
		
		
		if(e.getSource() == ventanaPaquetes.btnRegresar) {
			ventanaPos.setVisible(true);
			ventanaPaquetes.dispose();
			controladorPos.limpiarCamposCliente();
			
		}
		
		
		if(e.getSource() == ventanaPaquetes.btnCalcularEnvio) {
			
			double peso = Double.parseDouble(ventanaPaquetes.textFieldPeso.getText());
			double distancia = Double.parseDouble(ventanaPaquetes.textFieldDistancia.getText());
			double valor = calcularValorEnvio(distancia, peso); //reemplazar valor con el metodo para calcular la distancia
			ventanaPaquetes.textFieldValorEnvio.setText(Double.toString(valor));
		}
		
		if(e.getSource() == ventanaPaquetes.btnCalcularImpuestos) {
			double valor = calcularImpuestos(Double.parseDouble(ventanaPaquetes.textFieldValorEnvio.getText()));
			ventanaPaquetes.textFieldImpuestoEnvio.setText(Double.toString(valor));
		}
		
		if(e.getSource() == ventanaPaquetes.btnCalcularSeguro) {
			double valor = calcularSeguro(Double.parseDouble(ventanaPaquetes.textFieldValorDeclarado.getText()));
			ventanaPaquetes.textFieldSeguro.setText(Double.toString(valor));
		}
		
		if(e.getSource() == ventanaPaquetes.btnCalcularTotal) {
			
			double total=0;
			double envio= Double.parseDouble(ventanaPaquetes.textFieldValorEnvio.getText());
			double impuestos=Double.parseDouble(ventanaPaquetes.textFieldImpuestoEnvio.getText());
			double seguro=Double.parseDouble(ventanaPaquetes.textFieldSeguro.getText());
			
			total = envio+impuestos+seguro;
			
			ventanaPaquetes.textFieldTotalEnvio.setText(Double.toString(total));
			
		}
		// debo poner valores en modelos venta y paquetes
		if(e.getSource() == ventanaPaquetes.btnObtenerTotales) {
			calcularTotales();
			
		}
		
		if(e.getSource() == ventanaPaquetes.btnLimpiar) {
			limpiarCasillasPaquete();
		}
		

		
		if(e.getSource() == ventanaPaquetes.btnValidarPagoTarjeta) {
			
			ventanaPaquetes.setVisible(false);
			iniciarVentanaValidacionTarjeta();
			
			controladorValidacionTarjeta = new ControladorValidacionTarjeta(ventanaValidacionTarjeta,ventanaPaquetes, this, cliente);
			
			ventanaPaquetes.btnRegistrarVenta.setEnabled(true);
		}
		
		if(e.getSource() == ventanaPaquetes.btnValidarPagoEfectivo) {
			verificacionEfectivo=true;
		}
		
		
		if(e.getSource() == ventanaPaquetes.btnRegistrarVenta) {
			
			if(verificacionTarjeta || verificacionEfectivo) {
				
				consultaVenta = new ConsultaVenta();
				consultaVenta.registrarVenta(ventanaPaquetes, usuario, cliente);
				consultaVenta.registrarPaquetes(usuario, cliente, paquete,ventanaPaquetes,this);
				verificacionTarjeta=false;
				verificacionEfectivo=false;
			}
			
		}
		
		if(e.getSource() == ventanaPaquetes.btnGenerarRecibo) {
			reporte = new Reporte();
			reporte.factura(cliente.getIdCliente(), consultaVenta.consecutivoVentas(cliente, usuario, ventanaPaquetes));		
		}
		
	}
	
	public void limpiarCasillasPaquete() {
		
		ventanaPaquetes.textFieldValorDeclarado.setText(null);
		ventanaPaquetes.textFieldDireccionOrigen.setText(null);
		ventanaPaquetes.textFieldDireccionEntrega.setText(null);
		ventanaPaquetes.textFieldDireccionCodigoPostal.setText(null); 
		ventanaPaquetes.textFieldPeso.setText(null);
		ventanaPaquetes.textFieldContenido.setText(null);
		ventanaPaquetes.textFieldDistancia.setText(null);
		ventanaPaquetes.textFieldValorEnvio.setText(null);
		ventanaPaquetes.textFieldSeguro.setText(null);
		ventanaPaquetes.textFieldImpuestoEnvio.setText(null);
		ventanaPaquetes.textFieldTotalEnvio.setText(null);
	}
	
	
	
	public double calcularSeguro(double cantidadDeclarada) {
		double valorSeguro=0;
		double porcentaje=0.10;
		
		valorSeguro=cantidadDeclarada*porcentaje;
		
		return valorSeguro;
	}
	
	
	public double calcularImpuestos(double valorEnvio) {
		
		double valorImpuestos = 0;
		double porcentaje = 0.05;
		
		valorImpuestos = valorEnvio*porcentaje;
		
		return valorImpuestos;
		
	}
	
	
	public double calcularValorEnvio(double distancia, double peso) {
		
		double valorEnvio=0;
		double valorPorKilometroRecorrido = 1500;
		double valorPorKilogramo = 15000;
		
		///usar tambien el peso del paquete en el calculo del valor del envio
		valorEnvio = (valorPorKilometroRecorrido * distancia) + (peso*valorPorKilogramo);
		

		return valorEnvio;
		
	}
	
	public int sedeMasCercana(int codigoPostal) {
		
		int sedeMasCercana=1;
		
		/// como determinar la sede mas cercana apartir del codigo postal?
		
		return sedeMasCercana;
	}
	
	public double calcularDistancia() {
		double distancia=0;
		
		//como calcular la distancia?
		
		return distancia;
	}
	
	public void ponerValoresEnArreglo(Object[] arreglo) {
		
		arreglo[0]= ventanaPaquetes.textFieldFecha.getText();
		arreglo[1]= ventanaPaquetes.textFieldValorDeclarado.getText();
		arreglo[2]= ventanaPaquetes.textFieldDireccionOrigen.getText();
		arreglo[3]= ventanaPaquetes.textFieldDireccionEntrega.getText();
		arreglo[4]= ventanaPaquetes.textFieldDireccionCodigoPostal.getText(); 
		arreglo[5]= ventanaPaquetes.textFieldPeso.getText();
		arreglo[6]= ventanaPaquetes.textFieldContenido.getText();
		arreglo[7]= ventanaPaquetes.textFieldDistancia.getText();
		arreglo[8]= ventanaPaquetes.textFieldValorEnvio.getText();
		arreglo[9]= ventanaPaquetes.textFieldSeguro.getText();
		arreglo[10]= ventanaPaquetes.textFieldImpuestoEnvio.getText();
		arreglo[11]=ventanaPaquetes.textFieldTotalEnvio.getText();
			
	}
	
	public void calcularTotales() {
		
		double totalEnvios=0;
		double totalSeguros=0;
		double totalImpuestos=0;
		double totalVenta=0;
		
		int numeroFilas = ventanaPaquetes.table.getModel().getRowCount();
		
		for(int i = 0; i<numeroFilas; i++) {
			
			totalEnvios = totalEnvios + Double.parseDouble(ventanaPaquetes.table.getValueAt(i, 8).toString());
			totalSeguros = totalSeguros +  Double.parseDouble(ventanaPaquetes.table.getValueAt(i, 9).toString());
			totalImpuestos = totalImpuestos +  Double.parseDouble(ventanaPaquetes.table.getValueAt(i, 10).toString());
		}
		
		totalVenta = totalEnvios + totalSeguros + totalImpuestos;
		
		ventanaPaquetes.textFieldValorTotalEnvios.setText(String.valueOf(totalEnvios));
		ventanaPaquetes.textFieldTotaIImpuestos.setText(String.valueOf(totalImpuestos));
		ventanaPaquetes.textFieldTotalSeguros.setText(String.valueOf(totalSeguros));
		ventanaPaquetes.textFieldTotalVenta.setText(String.valueOf(totalVenta));
	}
	
	public void ponerValoresFilaSeleccionadaEnTextFields(int fila) {
		ventanaPaquetes.textFieldValorDeclarado.setText((String) ventanaPaquetes.table.getValueAt(fila, 1));
		ventanaPaquetes.textFieldDireccionOrigen.setText((String) ventanaPaquetes.table.getValueAt(fila, 2));
		ventanaPaquetes.textFieldDireccionEntrega.setText((String) ventanaPaquetes.table.getValueAt(fila, 3));
		ventanaPaquetes.textFieldDireccionCodigoPostal.setText((String) ventanaPaquetes.table.getValueAt(fila, 4));
		ventanaPaquetes.textFieldPeso.setText((String) ventanaPaquetes.table.getValueAt(fila, 5));
		ventanaPaquetes.textFieldContenido.setText((String) ventanaPaquetes.table.getValueAt(fila, 6));
		ventanaPaquetes.textFieldDistancia.setText((String) ventanaPaquetes.table.getValueAt(fila, 7));
		ventanaPaquetes.textFieldValorEnvio.setText((String) ventanaPaquetes.table.getValueAt(fila, 8));
		ventanaPaquetes.textFieldSeguro.setText((String) ventanaPaquetes.table.getValueAt(fila, 9));
		ventanaPaquetes.textFieldImpuestoEnvio.setText((String) ventanaPaquetes.table.getValueAt(fila, 10));
		ventanaPaquetes.textFieldTotalEnvio.setText((String) ventanaPaquetes.table.getValueAt(fila, 11));
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int fila = ventanaPaquetes.table.getSelectedRow();
		System.out.println(fila);
		ponerValoresFilaSeleccionadaEnTextFields(fila);
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void iniciarVentanaValidacionTarjeta() {
		ventanaValidacionTarjeta = new VentanaValidacionTarjeta();
		ventanaValidacionTarjeta.setTitle("Validación Tarjeta");
		ventanaValidacionTarjeta.setLocationRelativeTo(null);
		ventanaValidacionTarjeta.setVisible(true);
	}
	

	
	public void ponerTotalesEnModeloVentas() {
		
		venta.setFecha(java.sql.Date.valueOf(java.time.LocalDate.now()));
		venta.setIdCliente(cliente.getIdCliente());
		venta.setIdSede(usuario.getId_sede());
		venta.setIdVendedor(usuario.getId());
		venta.setTotalEnvios(Double.parseDouble(ventanaPaquetes.textFieldValorTotalEnvios.getText()));
		venta.setTotalImpuestos(Double.parseDouble(ventanaPaquetes.textFieldTotaIImpuestos.getText()));
		venta.setTotalSeguros(Double.parseDouble(ventanaPaquetes.textFieldTotalSeguros.getText()));
		venta.setTotalVenta(Double.parseDouble(ventanaPaquetes.textFieldTotalVenta.getText()));

	}
	
	public void ponerValoresEnModeloPaquetes(int filas) {

		paquete.setFecha(Date.valueOf(java.time.LocalDate.now()));
		paquete.setValorDeclarado(Double.valueOf((String) ventanaPaquetes.table.getModel().getValueAt(filas, 1)));
		paquete.setDireccionOrigen((String) ventanaPaquetes.table.getModel().getValueAt(filas, 2));
		paquete.setDireccionEntrega((String) ventanaPaquetes.table.getModel().getValueAt(filas, 3));
		paquete.setCodigoPostal((String) ventanaPaquetes.table.getModel().getValueAt(filas, 4));
		paquete.setPeso(Double.valueOf((String) ventanaPaquetes.table.getModel().getValueAt(filas, 5)));
		paquete.setContenido((String) ventanaPaquetes.table.getModel().getValueAt(filas, 6));
		paquete.setDistancia(Double.valueOf((String) ventanaPaquetes.table.getModel().getValueAt(filas, 7)));
		paquete.setValorEnvio(Double.valueOf((String) ventanaPaquetes.table.getModel().getValueAt(filas, 8)));
		paquete.setSeguro(Double.valueOf((String) ventanaPaquetes.table.getModel().getValueAt(filas, 9)));
		paquete.setImpuestos(Double.valueOf((String) ventanaPaquetes.table.getModel().getValueAt(filas, 10)));
		paquete.setValorTotalEnvio(Double.valueOf((String) ventanaPaquetes.table.getModel().getValueAt(filas, 11)));
		paquete.setIdCliente(cliente.getIdCliente());
		paquete.setIdSede(usuario.getId_sede());

	}
	
}
