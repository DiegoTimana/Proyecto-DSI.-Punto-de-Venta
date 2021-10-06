package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.regex.*;
import javax.swing.JOptionPane;
import modelo.ConsultaUsuario;
import modelo.Usuario;
import vista.VentanaGerente;
import vista.VentanaGestionUsuarios;


public class ControladorGestionUsuarios implements ActionListener {

	
	VentanaGestionUsuarios ventanaGestionUsuarios;
	VentanaGerente ventanaGerente;
	Usuario usuario = new Usuario();
	ConsultaUsuario consultaUsuario = new ConsultaUsuario();
	
	public ControladorGestionUsuarios (VentanaGestionUsuarios ventanaGestionUsuarios, VentanaGerente ventanaGerente) {
		
		this.ventanaGestionUsuarios=ventanaGestionUsuarios;
		this.ventanaGestionUsuarios.btnBuscarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnGuardarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnEliminarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnLimpiarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnModificarUsuario.addActionListener(this);
		this.ventanaGestionUsuarios.btnRegresar.addActionListener(this);
		this.ventanaGestionUsuarios.btnVolver.addActionListener(this);
		this.ventanaGestionUsuarios.btnRegistrar.addActionListener(this);
		this.ventanaGestionUsuarios.btnGuardarCambios.addActionListener(this);
		this.ventanaGerente=ventanaGerente;
		this.ventanaGestionUsuarios.btnVolver.setVisible(false);
		this.ventanaGestionUsuarios.btnRegistrar.setVisible(false);
		this.ventanaGestionUsuarios.btnGuardarCambios.setVisible(false);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		//Esta funcionando
		if(e.getSource() == ventanaGestionUsuarios.btnBuscarUsuario) {
			limpiarCamposUsuarios();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
			
			if (m.find()) {
				
		     JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
		     input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
		     
			}else {
				
				int id = Integer.parseInt(input);
				boolean consulta = consultaUsuario.buscar(usuario, id);
				
				if(consulta) {
					ponerValoresEnTextfieldsUsuarios();
				}
			}
		}
		
		if(e.getSource() == ventanaGestionUsuarios.btnGuardarUsuario) {
			limpiarCamposUsuarios();
			
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
				
			if (m.find()) {
					
			    JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
			    input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
			     
			}else {
					
				int id = Integer.parseInt(input);
				if(consultaUsuario.confirmarExistenciaUsuario(id)) {
					JOptionPane.showMessageDialog(null, "El numero de usuario ya existe");
		    		
				}else {
					
					ventanaGestionUsuarios.textFieldIdUsuario.setText(String.valueOf(id));
					
					editabilidadCampos(true);
					ventanaGestionUsuarios.btnBuscarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnEliminarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnModificarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnRegresar.setVisible(false);
					ventanaGestionUsuarios.btnLimpiarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnGuardarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnRegistrar.setVisible(true);
					ventanaGestionUsuarios.btnVolver.setVisible(true);
					
				}	
			}
		}
		
		//esta funcionando
		if(e.getSource() == ventanaGestionUsuarios.btnEliminarUsuario) {
			
			
			limpiarCamposUsuarios();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
				
			if (m.find()) {
					
			    JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
			    input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
			     
			}else {
					
				int id = Integer.parseInt(input);
				consultaUsuario.eliminar(id);
	
			}
			
		}
		
		if(e.getSource() == ventanaGestionUsuarios.btnModificarUsuario) {
			
			limpiarCamposUsuarios();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
				
			if (m.find()) {
					
			    JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
			    input = JOptionPane.showInputDialog("Ingresar numero de usuario: ");
			     
			}else {
					
				int id = Integer.parseInt(input);
				if(consultaUsuario.confirmarExistenciaUsuario(id)) {
					
					consultaUsuario.buscar(usuario, id);
					ponerValoresEnTextfieldsUsuarios();
					
					editabilidadCampos(true);
					ventanaGestionUsuarios.btnBuscarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnEliminarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnModificarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnRegresar.setVisible(false);
					ventanaGestionUsuarios.btnLimpiarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnGuardarUsuario.setVisible(false);
					ventanaGestionUsuarios.btnRegistrar.setVisible(false);
					ventanaGestionUsuarios.btnGuardarCambios.setVisible(true);
					ventanaGestionUsuarios.btnVolver.setVisible(true);
					
				}else {
					
		    		JOptionPane.showMessageDialog(null, "el numero de usuario no existe");
		    		limpiarCamposUsuarios();

				}
			}
		}
		
		//esta funcionando
		if(e.getSource() == ventanaGestionUsuarios.btnLimpiarUsuario) {
			limpiarCamposUsuarios();
		}
		
		
		//esta funcionando
		if(e.getSource() == ventanaGestionUsuarios.btnRegresar) {
			ventanaGestionUsuarios.dispose();
			ventanaGerente.setVisible(true);
		}
		
		
		if(e.getSource() == ventanaGestionUsuarios.btnVolver) {
			limpiarCamposUsuarios();
			editabilidadCampos(false);
			ventanaGestionUsuarios.btnBuscarUsuario.setVisible(true);
			ventanaGestionUsuarios.btnEliminarUsuario.setVisible(true);
			ventanaGestionUsuarios.btnModificarUsuario.setVisible(true);
			ventanaGestionUsuarios.btnRegresar.setVisible(true);
			ventanaGestionUsuarios.btnLimpiarUsuario.setVisible(true);
			ventanaGestionUsuarios.btnGuardarUsuario.setVisible(true);
			ventanaGestionUsuarios.btnRegistrar.setVisible(false);
			ventanaGestionUsuarios.btnVolver.setVisible(false);
			ventanaGestionUsuarios.btnGuardarCambios.setVisible(false);
		}
		
		if(e.getSource() == ventanaGestionUsuarios.btnRegistrar) {
			ponerValoresCampoEnModeloUsuarios();
			boolean resultado = consultaUsuario.registrar(usuario);
			if(resultado) {
				limpiarCamposUsuarios();
				editabilidadCampos(false);
				ventanaGestionUsuarios.btnBuscarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnEliminarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnModificarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnRegresar.setVisible(true);
				ventanaGestionUsuarios.btnLimpiarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnGuardarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnRegistrar.setVisible(false);
				ventanaGestionUsuarios.btnVolver.setVisible(false);
				ventanaGestionUsuarios.btnGuardarCambios.setVisible(false);
			}
		}
		
		if(e.getSource() == ventanaGestionUsuarios.btnGuardarCambios) {
			
			ponerValoresCampoEnModeloUsuarios();
			boolean resultado = consultaUsuario.modificar(usuario);
			if(resultado) {
				limpiarCamposUsuarios();
				editabilidadCampos(false);
				ventanaGestionUsuarios.btnBuscarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnEliminarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnModificarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnRegresar.setVisible(true);
				ventanaGestionUsuarios.btnLimpiarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnGuardarUsuario.setVisible(true);
				ventanaGestionUsuarios.btnRegistrar.setVisible(false);
				ventanaGestionUsuarios.btnVolver.setVisible(false);
				ventanaGestionUsuarios.btnGuardarCambios.setVisible(false);
			}
		}
		
	}
	
	
	public void limpiarCamposUsuarios() {
	
		ventanaGestionUsuarios.textFieldIdUsuario.setText(null);
		ventanaGestionUsuarios.textFieldNombreUsuario.setText(null);
		ventanaGestionUsuarios.textFieldApellidosUsuario.setText(null);
		ventanaGestionUsuarios.textFieldFechaNacimientoUsuario.setText(null);
		ventanaGestionUsuarios.textFieldTelefonoUsuario.setText(null);
		ventanaGestionUsuarios.textFieldDireccionUsuario.setText(null);
		ventanaGestionUsuarios.textFieldEmailUsuario.setText(null);
		ventanaGestionUsuarios.comboBoxGeneroUsuario.setSelectedIndex(0);
		ventanaGestionUsuarios.textFieldFechaVinculacionUsuario.setText(null);
		ventanaGestionUsuarios.comboBoxCargoUsuario.setSelectedIndex(0);
		ventanaGestionUsuarios.comboBoxEstadoUsuario.setSelectedIndex(0);
		ventanaGestionUsuarios.textFieldSedeUsuario.setText(null);
		ventanaGestionUsuarios.textFieldPasswordUsuario.setText(null);
	
	}
	
	void ponerValoresEnTextfieldsUsuarios() {
		
		ventanaGestionUsuarios.textFieldIdUsuario.setText(Integer.toString(usuario.getId()));
		ventanaGestionUsuarios.textFieldNombreUsuario.setText(usuario.getNombre());
		ventanaGestionUsuarios.textFieldApellidosUsuario.setText(usuario.getApellidos());
		ventanaGestionUsuarios.textFieldFechaNacimientoUsuario.setText((usuario.getFechaNacimiento().toString()));
		ventanaGestionUsuarios.textFieldTelefonoUsuario.setText(usuario.getTelefono());
		ventanaGestionUsuarios.textFieldDireccionUsuario.setText(usuario.getDireccion());
		ventanaGestionUsuarios.textFieldEmailUsuario.setText(usuario.getEmail());
		ventanaGestionUsuarios.comboBoxGeneroUsuario.setSelectedIndex(indexGenero(usuario.getGenero()));
		ventanaGestionUsuarios.textFieldFechaVinculacionUsuario.setText(usuario.getFechaVinculacion().toString());
		ventanaGestionUsuarios.comboBoxCargoUsuario.setSelectedIndex(indexCargo(usuario.getCargo()));
		ventanaGestionUsuarios.comboBoxEstadoUsuario.setSelectedIndex(indexDeEstado(usuario.getEstado()));
		ventanaGestionUsuarios.textFieldSedeUsuario.setText(Integer.toString(usuario.getId_sede()));
		ventanaGestionUsuarios.textFieldPasswordUsuario.setText(usuario.getPassword());
		
	}
	
	public void ponerValoresCampoEnModeloUsuarios() {
		usuario.setId(Integer.valueOf(ventanaGestionUsuarios.textFieldIdUsuario.getText()));
		usuario.setNombre(ventanaGestionUsuarios.textFieldNombreUsuario.getText());
		usuario.setApellidos(ventanaGestionUsuarios.textFieldApellidosUsuario.getText());
		usuario.setFechaNacimiento(Date.valueOf(ventanaGestionUsuarios.textFieldFechaNacimientoUsuario.getText()));
		usuario.setTelefono(ventanaGestionUsuarios.textFieldTelefonoUsuario.getText());
		usuario.setDireccion(ventanaGestionUsuarios.textFieldDireccionUsuario.getText());
		usuario.setEmail(ventanaGestionUsuarios.textFieldEmailUsuario.getText());
		usuario.setGenero((String)ventanaGestionUsuarios.comboBoxGeneroUsuario.getSelectedItem());
		usuario.setFechaVinculacion(Date.valueOf(ventanaGestionUsuarios.textFieldFechaVinculacionUsuario.getText()));
		usuario.setCargo((String)ventanaGestionUsuarios.comboBoxCargoUsuario.getSelectedItem());
		usuario.setEstado((String)ventanaGestionUsuarios.comboBoxEstadoUsuario.getSelectedItem());
		usuario.setId_sede(Integer.parseInt(ventanaGestionUsuarios.textFieldSedeUsuario.getText()));
		usuario.setPassword(ventanaGestionUsuarios.textFieldPasswordUsuario.getText());
	}
	
	public void editabilidadCampos(boolean editabilidad) {
		//ventanaGestionUsuarios.textFieldIdUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldNombreUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldApellidosUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldFechaNacimientoUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldTelefonoUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldDireccionUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldEmailUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.comboBoxGeneroUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldFechaVinculacionUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.comboBoxCargoUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.comboBoxEstadoUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldSedeUsuario.setEditable(editabilidad);
		ventanaGestionUsuarios.textFieldPasswordUsuario.setEditable(editabilidad);
	}
	
	
	public int indexDeEstado(String estado) {
		int index=0;
		
		if(estado.equals("activo")) {
			index=1;
		}else {
			index=2;
		}
		return index;
	}
	
	public int indexGenero(String genero) {
		int index=0;
		
		if(genero.equals("masculino")) {
			index=1;
		}else {
			index=2;
		}
		return index;
	}
	
	public int indexCargo(String cargo) {
		
		int index=0;
		
				
		switch(cargo) {
		
		case "secretaria":
			index=1;
			break;
			
		case "operador de oficina":
			index=2;
			break;
			
		case "contador":
			index=3;
			break;	
			
		case "gerente":
			index=4;
			break;

		case "auxiliar de operacion":
			index=5;
			break;

		}
		return index;
		
	}
	
	

}
