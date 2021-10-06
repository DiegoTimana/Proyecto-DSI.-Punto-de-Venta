package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Conexion;
import modelo.ConsultaUsuario;
import modelo.Usuario;
import vista.VentanaGerente;
import vista.VentanaLogin;

public class ControladorLogin implements ActionListener{
	
	VentanaLogin ventanaLogin;
	Conexion conexion;
	Connection con;
	ConsultaUsuario consultaUsuario = new ConsultaUsuario();
	ControladorMenuOpciones controladorMenuOpciones;
	Usuario persona = new Usuario();
	
	
	 public ControladorLogin (VentanaLogin ventanaLogin){
	        
	        this.ventanaLogin = ventanaLogin;
	        this.ventanaLogin.btnIngresar.addActionListener(this);    
	    }
	 
	 //metodo para iniciar la vista
	 public void iniciar(){
		 
		 ventanaLogin.setTitle("Login");
		 ventanaLogin.setLocationRelativeTo(null);
		 ventanaLogin.setVisible(true);
		 
	    }

	 
	//metodos para escuchar los click de los botones
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == ventanaLogin.btnIngresar) {
			
			validarUsuario();
	
		}
		
	}
	
	//para validar si el usuario esta en la base de datos
	public void validarUsuario() {
		
		
		
		if(ventanaLogin.passwordField.getPassword().length == 0 || ventanaLogin.textFieldUsuario.getText().length() == 0) {
			
			JOptionPane.showMessageDialog(null, "Ingrese su Usuario y Password");
			
		}else {
			
			conexion = new Conexion();
			con = conexion.getConnection();

			String estado = "activo";
			String password = String.valueOf(ventanaLogin.passwordField.getPassword()); 
			int usuario = Integer.parseInt(ventanaLogin.textFieldUsuario.getText());
			String sql = "select * from usuarios where id_usuario='"+usuario+"' and contraseña='"+password+"' and estado_usuario='"+estado+"' ";
		
			try {
				
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				
				
				if(rs.next()) {
					
					//guardo la informacion del usuario que se encuentra en la base de datos en el objeto persona
					consultaUsuario.buscar(persona, usuario);
					
					String cargo = persona.getCargo();
					
					if(cargo.equals("gerente") || cargo.equals("secretaria") || cargo.equals("contador") || cargo.equals("administrador")) {
						
						JOptionPane.showMessageDialog(null, "Login exitoso");
						ventanaLogin.dispose();
						
						VentanaGerente ventanaGerente = new VentanaGerente();
						ventanaGerente.setTitle("Menu");
						ventanaGerente.setVisible(true);
						controladorMenuOpciones = new ControladorMenuOpciones(ventanaGerente, persona);
						
						try{
			                con.close();
			            }catch (SQLException e){
			                System.err.println(e);
			            }
						
						
					}
					
					if(cargo.equals("operador de oficina")) {
						
						JOptionPane.showMessageDialog(null, "Login exitoso");
						ventanaLogin.dispose();
						
						VentanaGerente ventanaGerente = new VentanaGerente();
						ventanaGerente.setTitle("Menu");
						ventanaGerente.setVisible(true);
						ventanaGerente.btnGestionSedes.setEnabled(false);
						ventanaGerente.btnGestionUsuarios.setEnabled(false);
						ventanaGerente.btnInformes.setEnabled(false);
						controladorMenuOpciones = new ControladorMenuOpciones(ventanaGerente, persona);
						
						
						try{
			                con.close();
			            }catch (SQLException e){
			                System.err.println(e);
			            }
					}
						
				} else {
					
					JOptionPane.showMessageDialog(null, "Error de Acceso");
					
				}
				
					
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, "Error" + e.getMessage());
			}
			
		}
	
	}
	

}