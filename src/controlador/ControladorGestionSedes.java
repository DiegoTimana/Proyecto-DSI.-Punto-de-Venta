package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import modelo.ConsultaSede;
import modelo.Sede;
import vista.VentanaGerente;
import vista.VentanaGestionSedes;

public class ControladorGestionSedes implements ActionListener{
	
	VentanaGestionSedes ventanaGestionSedes;
	VentanaGerente ventanaGerente;
	ConsultaSede consultaSede = new ConsultaSede();
	Sede sede = new Sede();
	
	public ControladorGestionSedes(VentanaGestionSedes ventanaGestionSedes, VentanaGerente ventanaGerente) {
		this.ventanaGestionSedes=ventanaGestionSedes;
		this.ventanaGestionSedes.btnBuscarSede.addActionListener(this);
		this.ventanaGestionSedes.btnGuardarSede.addActionListener(this);
		this.ventanaGestionSedes.btnModificarSede.addActionListener(this);
		this.ventanaGestionSedes.btnEliminarSede.addActionListener(this);
		this.ventanaGestionSedes.btnLimpiarSede.addActionListener(this);
		this.ventanaGestionSedes.btnRegresar.addActionListener(this);
		this.ventanaGestionSedes.btnActualizar.addActionListener(this);
		this.ventanaGestionSedes.btnRegistrar.addActionListener(this);
		this.ventanaGestionSedes.btnVolver.addActionListener(this);
		this.ventanaGestionSedes.btnRegistrar.setVisible(false);
		this.ventanaGestionSedes.btnActualizar.setVisible(false);
		this.ventanaGestionSedes.btnVolver.setVisible(false);
		this.ventanaGerente = ventanaGerente;
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaGestionSedes.btnBuscarSede) {
			
			limpiarCamposSedes();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de sede: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
			
			if (m.find()) {
				
		     JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
		     input = JOptionPane.showInputDialog("Ingresar numero de sede: ");
		     
			}else {
				
				int id = Integer.parseInt(input);
				boolean consulta = consultaSede.buscar(sede, id);
				
				if(consulta) {
					ponerValoresEnTextfieldsSedes();
				}
			
			}
		}
		
		
		if(e.getSource() == ventanaGestionSedes.btnGuardarSede) {
			
			limpiarCamposSedes();
			editabilidadCamposSedes(true);
					
			ventanaGestionSedes.btnRegistrar.setVisible(true);
			ventanaGestionSedes.btnVolver.setVisible(true);
			ventanaGestionSedes.btnBuscarSede.setVisible(false);
			ventanaGestionSedes.btnActualizar.setVisible(false);
			ventanaGestionSedes.btnEliminarSede.setVisible(false);
			ventanaGestionSedes.btnLimpiarSede.setVisible(false);
			ventanaGestionSedes.btnGuardarSede.setVisible(false);
			ventanaGestionSedes.btnRegresar.setVisible(false);
			ventanaGestionSedes.btnModificarSede.setVisible(false);

		}
		
		if(e.getSource() == ventanaGestionSedes.btnModificarSede) {
			
			limpiarCamposSedes();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de sede: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
				
			if (m.find()) {
					
			    JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
			    input = JOptionPane.showInputDialog("Ingresar numero de sede: ");
			     
			}else {
					
				int id = Integer.parseInt(input);
				if(consultaSede.confirmarExistenciaSede(id)) {
					
					consultaSede.buscar(sede, id);
					ponerValoresEnTextfieldsSedes();
					
					editabilidadCamposSedes(true);
					ventanaGestionSedes.btnRegistrar.setVisible(false);
					ventanaGestionSedes.btnVolver.setVisible(true);
					ventanaGestionSedes.btnActualizar.setVisible(true);
					ventanaGestionSedes.btnBuscarSede.setVisible(false);
					ventanaGestionSedes.btnEliminarSede.setVisible(false);
					ventanaGestionSedes.btnLimpiarSede.setVisible(false);
					ventanaGestionSedes.btnGuardarSede.setVisible(false);
					ventanaGestionSedes.btnRegresar.setVisible(false);
					ventanaGestionSedes.btnModificarSede.setVisible(false);
					
					
				}else {
					
		    		JOptionPane.showMessageDialog(null, "el numero de sede no existe");
		    		limpiarCamposSedes();

				}
			}
			
			/*
			ponerValoresCampoEnModelo();
			int id = Integer.parseInt(ventanaGestionSedes.textFieldCasillaBusqueda.getText());
			consultaSede.modificar(sede, id);
			limpiarCamposSede();
			*/
			
		}
		
		if(e.getSource() == ventanaGestionSedes.btnEliminarSede) {
			
			limpiarCamposSedes();
			String input;
			input = JOptionPane.showInputDialog("Ingresar numero de sede: ");
			Pattern p = Pattern.compile("[A-Z,a-z,&%$#@!()*^]");
			Matcher m = p.matcher(input);
			
			if (m.find()) {
				
		     JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
		     input = JOptionPane.showInputDialog("Ingresar numero de sede: ");
		     
			}else {
				
				int id = Integer.parseInt(input);
				boolean consulta = consultaSede.buscar(sede, id);
				
				if(consulta) {
					consultaSede.eliminar(sede, id);
					limpiarCamposSedes();
				}
			}
		}
		
		if(e.getSource() == ventanaGestionSedes.btnLimpiarSede) {
			
			limpiarCamposSedes();
		}
		
		
		if(e.getSource() == ventanaGestionSedes.btnRegresar) {
			
			ventanaGestionSedes.dispose();
			ventanaGerente.setVisible(true);
			
		}
		
		if(e.getSource() == ventanaGestionSedes.btnVolver) {
			
			limpiarCamposSedes();
			editabilidadCamposSedes(false);
			ventanaGestionSedes.btnRegistrar.setVisible(false);
			ventanaGestionSedes.btnVolver.setVisible(false);
			ventanaGestionSedes.btnActualizar.setVisible(false);
			ventanaGestionSedes.btnBuscarSede.setVisible(true);
			ventanaGestionSedes.btnEliminarSede.setVisible(true);
			ventanaGestionSedes.btnLimpiarSede.setVisible(true);
			ventanaGestionSedes.btnGuardarSede.setVisible(true);
			ventanaGestionSedes.btnRegresar.setVisible(true);
			ventanaGestionSedes.btnModificarSede.setVisible(true);
			
		}
		
		if(e.getSource() == ventanaGestionSedes.btnRegistrar) {
			
			ponerValoresCampoEnModeloSedes();
			boolean resultado = consultaSede.registrar(sede);
			if(resultado) {
				
				limpiarCamposSedes();
				editabilidadCamposSedes(false);
				ventanaGestionSedes.btnRegistrar.setVisible(false);
				ventanaGestionSedes.btnVolver.setVisible(false);
				ventanaGestionSedes.btnActualizar.setVisible(false);
				ventanaGestionSedes.btnBuscarSede.setVisible(true);
				ventanaGestionSedes.btnEliminarSede.setVisible(true);
				ventanaGestionSedes.btnLimpiarSede.setVisible(true);
				ventanaGestionSedes.btnGuardarSede.setVisible(true);
				ventanaGestionSedes.btnRegresar.setVisible(true);
				ventanaGestionSedes.btnModificarSede.setVisible(true);
			}
			
		}
		
		if(e.getSource() == ventanaGestionSedes.btnActualizar) {
			ponerValoresCampoEnModeloSedes();
			boolean resultado = consultaSede.modificar(sede);
			if(resultado) {
				limpiarCamposSedes();
				editabilidadCamposSedes(false);
				ventanaGestionSedes.btnRegistrar.setVisible(false);
				ventanaGestionSedes.btnVolver.setVisible(false);
				ventanaGestionSedes.btnActualizar.setVisible(false);
				ventanaGestionSedes.btnBuscarSede.setVisible(true);
				ventanaGestionSedes.btnEliminarSede.setVisible(true);
				ventanaGestionSedes.btnLimpiarSede.setVisible(true);
				ventanaGestionSedes.btnGuardarSede.setVisible(true);
				ventanaGestionSedes.btnRegresar.setVisible(true);
				ventanaGestionSedes.btnModificarSede.setVisible(true);
			}
		}
		
	}
	
	
	public void limpiarCamposSedes() {
		
		ventanaGestionSedes.textFieldIdSede.setText(null);
		ventanaGestionSedes.textFieldNombreSede.setText(null);
		ventanaGestionSedes.textFieldDireccionSede.setText(null);
		ventanaGestionSedes.textFieldTelefonoSede.setText(null);
		ventanaGestionSedes.estado.setSelectedIndex(0);
	}
	
	public void ponerValoresCampoEnModeloSedes() {
		
		sede.setNombreSede(ventanaGestionSedes.textFieldNombreSede.getText());
		sede.setDireccionSede(ventanaGestionSedes.textFieldDireccionSede.getText());
		sede.setEstadoSede((String)ventanaGestionSedes.estado.getSelectedItem());
		sede.setTelefonoSede(ventanaGestionSedes.textFieldTelefonoSede.getText());
	
	}
	
	public void ponerValoresEnTextfieldsSedes() {
		ventanaGestionSedes.textFieldIdSede.setText(Integer.toString(sede.getIdSede()));
		ventanaGestionSedes.textFieldNombreSede.setText(sede.getNombreSede());
		ventanaGestionSedes.textFieldDireccionSede.setText(sede.getDireccionSede());
		ventanaGestionSedes.textFieldTelefonoSede.setText(sede.getTelefonoSede());
		ventanaGestionSedes.estado.setSelectedIndex(indexDeEstado(sede.getEstadoSede()));
		
	}
	
	public void editabilidadCamposSedes(boolean editabilidad) {
		
		ventanaGestionSedes.textFieldNombreSede.setEditable(editabilidad);
		ventanaGestionSedes.textFieldDireccionSede.setEditable(editabilidad);
		ventanaGestionSedes.textFieldTelefonoSede.setEditable(editabilidad);
		ventanaGestionSedes.estado.setEditable(editabilidad);
		
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
	

}
