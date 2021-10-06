package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import modelo.Cliente;
import modelo.ConsultaCliente;
import modelo.Usuario;
import vista.VentanaGerente;
import vista.VentanaPaquetes;
import vista.VentanaPos;

public class ControladorPOS implements ActionListener {
	
	VentanaGerente ventanaGerente;
	VentanaPos ventanaPos;
	VentanaPaquetes ventanaPaquetes;
	ControladorPaquetes controladorPaquetes;
	Usuario usuario;
	Cliente cliente = new Cliente();
	ConsultaCliente consultaCliente = new ConsultaCliente();
	
	
	public ControladorPOS(VentanaPos ventanaPos, VentanaGerente ventanaGerente, Usuario usuario) {
		this.usuario=usuario;
		this.ventanaGerente=ventanaGerente;
		this.ventanaPos=ventanaPos;
		this.ventanaPos.btnActualizarCliente.addActionListener(this);
		this.ventanaPos.btnAdicionarCliente.addActionListener(this);
		this.ventanaPos.btnBuscarCliente.addActionListener(this);
		this.ventanaPos.btnLimpiarCasillasCliente.addActionListener(this);
		this.ventanaPos.btnGuardarUsuarioParaVenta.setEnabled(true);
		this.ventanaPos.btnGuardarUsuarioParaVenta.addActionListener(this);
		this.ventanaPos.btnRegresar.addActionListener(this);
		this.ventanaPos.btnGuardarCliente.addActionListener(this);
		this.ventanaPos.btnCancelar.addActionListener(this);
		this.ventanaPos.btnGuardarCliente.setVisible(false);
		this.ventanaPos.btnCancelar.setVisible(false);
		this.ventanaPos.textFieldiDUsuario.setText(Integer.toString(usuario.getId()));
		this.ventanaPos.textFieldFechaSistema.setText((java.time.LocalDate.now()).toString());
		this.ventanaPos.textFieldSedeUsuario.setText(Integer.toString(usuario.getId_sede()));
		this.ventanaPos.btnAdicionarPaquete.addActionListener(this);
		
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaPos.btnActualizarCliente) {
			
			limpiarCamposCliente();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de cliente: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
				
			if (m.find()) {
					
			    JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
			    input = JOptionPane.showInputDialog("Ingresar numero de cliente: ");
			     
			}else {
					
				int id = Integer.parseInt(input);
				if(consultaCliente.confirmarExistenciaCliente(id)) {
					
					consultaCliente.buscar(cliente, id);
					ponerValoresEnTextfieldsCliente();
					
					ventanaPos.textFieldIdCliente.setEditable(false);
					editabilidadCamposCliente(true);
					
					ventanaPos.btnGuardarCliente.setVisible(true);
					ventanaPos.btnCancelar.setVisible(true);
					ventanaPos.btnActualizarCliente.setVisible(false);
					ventanaPos.btnAdicionarCliente.setVisible(false);
					ventanaPos.btnBuscarCliente.setVisible(false);
					ventanaPos.btnLimpiarCasillasCliente.setVisible(false);
					ventanaPos.btnRegresar.setVisible(false);

				
				}else {
					
		    		JOptionPane.showMessageDialog(null, "el numero de cliente no existe");
		    		limpiarCamposCliente();

				}
			}
			
		}
		
		
		if(e.getSource() == ventanaPos.btnAdicionarCliente) {
			
			limpiarCamposCliente();
			
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de cliente: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
				
			if (m.find()) {
					
			    JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
			    input = JOptionPane.showInputDialog("Ingresar numero de cliente: ");
			     
			}else {
					
				int id = Integer.parseInt(input);
				if(consultaCliente.confirmarExistenciaCliente(id)) {
					JOptionPane.showMessageDialog(null, "El numero de cliente ya existe");
		    		
				}else {
					
					ventanaPos.textFieldIdCliente.setText(String.valueOf(id));
					editabilidadCamposCliente(true);

					
					ventanaPos.btnGuardarCliente.setVisible(true);
					ventanaPos.btnCancelar.setVisible(true);
					ventanaPos.btnActualizarCliente.setVisible(false);
					ventanaPos.btnAdicionarCliente.setVisible(false);
					ventanaPos.btnBuscarCliente.setVisible(false);
					ventanaPos.btnLimpiarCasillasCliente.setVisible(false);
					ventanaPos.btnRegresar.setVisible(false);

					
					
				}	
			}
			
		}
		
		
		if(e.getSource() == ventanaPos.btnBuscarCliente) {
			
			limpiarCamposCliente();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de cliente: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
			
			if (m.find()) {
				
		     JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
		     input = JOptionPane.showInputDialog("Ingresar numero de cliente: ");
		     
			}else {
				
				int id = Integer.parseInt(input);
				boolean consulta = consultaCliente.buscar(cliente, id);
				
				if(consulta) {
					ponerValoresEnTextfieldsCliente();
				}
			}
		}
		
		
		if(e.getSource() == ventanaPos.btnLimpiarCasillasCliente) {
			limpiarCamposCliente();
		}
		
		
		
		if(e.getSource() == ventanaPos.btnRegresar) {
			ventanaPos.dispose();
			ventanaGerente.setVisible(true);
		}
		
		
		if(e.getSource() == ventanaPos.btnCancelar) {
			limpiarCamposCliente();
			editabilidadCamposCliente(false);
			
			
			ventanaPos.btnGuardarCliente.setVisible(false);
			ventanaPos.btnCancelar.setVisible(false);
			ventanaPos.btnActualizarCliente.setVisible(true);
			ventanaPos.btnAdicionarCliente.setVisible(true);
			ventanaPos.btnBuscarCliente.setVisible(true);
			ventanaPos.btnLimpiarCasillasCliente.setVisible(true);
			ventanaPos.btnRegresar.setVisible(true);
			
		}
		
		
		if(e.getSource() == ventanaPos.btnGuardarCliente) {
			
			ponerValoresCampoEnModeloCliente();
			boolean resultado = consultaCliente.registrar(cliente);
			if(resultado) {
				limpiarCamposCliente();
				editabilidadCamposCliente(false);
				
				ventanaPos.btnGuardarCliente.setVisible(false);
				ventanaPos.btnCancelar.setVisible(false);
				ventanaPos.btnActualizarCliente.setVisible(true);
				ventanaPos.btnAdicionarCliente.setVisible(true);
				ventanaPos.btnBuscarCliente.setVisible(true);
				ventanaPos.btnLimpiarCasillasCliente.setVisible(true);
				ventanaPos.btnRegresar.setVisible(true);
	
			}
		}
		

		
		//abre la ventana para agregar los paquetes
		if(e.getSource() == ventanaPos.btnAdicionarPaquete) {
			ventanaPos.setVisible(false);
			iniciarVentanaPaquetes();
			controladorPaquetes = new ControladorPaquetes(ventanaPos, ventanaPaquetes, usuario, cliente, this);
			
		}
		
		if(e.getSource() == ventanaPos.btnGuardarUsuarioParaVenta) {
			ponerValoresCampoEnModeloCliente();
		}
		
	}
	
	public void limpiarCamposCliente() {
		
		ventanaPos.textFieldIdCliente.setText(null);
		ventanaPos.textFieldNombreCliente.setText(null);
		ventanaPos.textFieldApellidosCliente.setText(null);
		ventanaPos.textFieldDireccionCliente.setText(null);
		ventanaPos.textFieldTelefonoCliente.setText(null);
		
	}
	
	public void ponerValoresEnTextfieldsCliente() {
		
		ventanaPos.textFieldIdCliente.setText(Integer.toString(cliente.getIdCliente()));
		ventanaPos.textFieldNombreCliente.setText(cliente.getNombreCliente());
		ventanaPos.textFieldApellidosCliente.setText(cliente.getApellidosCliente());
		ventanaPos.textFieldDireccionCliente.setText(cliente.getDireccionCliente());
		ventanaPos.textFieldTelefonoCliente.setText(cliente.getTelefonoCliente());
	}
	
	public void ponerValoresCampoEnModeloCliente() {
		
		cliente.setIdCliente(Integer.valueOf(ventanaPos.textFieldIdCliente.getText()));
		cliente.setNombreCliente(ventanaPos.textFieldNombreCliente.getText());
		cliente.setApellidosCliente(ventanaPos.textFieldApellidosCliente.getText());
		cliente.setDireccionCliente(ventanaPos.textFieldDireccionCliente.getText());
		cliente.setTelefonoCliente(ventanaPos.textFieldTelefonoCliente.getText());
		
	}
	

	
	public void editabilidadCamposCliente(boolean opcion) {
		ventanaPos.textFieldNombreCliente.setEditable(opcion);
		ventanaPos.textFieldApellidosCliente.setEditable(opcion);
		ventanaPos.textFieldDireccionCliente.setEditable(opcion);
		ventanaPos.textFieldTelefonoCliente.setEditable(opcion);
	}
	
	
	public void iniciarVentanaPaquetes() {
		ventanaPaquetes = new VentanaPaquetes();
		ventanaPaquetes.setTitle("Paquetes");
		ventanaPaquetes.setLocationRelativeTo(null);
		ventanaPaquetes.setVisible(true);
	}


}
