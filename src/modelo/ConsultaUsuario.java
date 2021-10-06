package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConsultaUsuario extends Conexion{
	
	
	
	public boolean registrar(Usuario usuario){
		
		int ident = usuario.getId();
		
		if(confirmarExistenciaUsuario(ident) == false) {
		
			String nombre = usuario.getNombre();
			String apellidos = usuario.getApellidos();
			Date fechaNac = usuario.getFechaNacimiento();
			String tel = usuario.getTelefono();
			String direccion = usuario.getDireccion();
			String email = usuario.getEmail();
			String genero = usuario.getGenero();
			Date fechaVin = usuario.getFechaVinculacion();
			String cargo = usuario.getCargo();
			String estado = usuario.getEstado();
			int sede = usuario.getId_sede();
			String contraseña = usuario.getPassword();
			
			
			
			Connection con = getConnection();
	        String sql = "INSERT INTO usuarios (id_usuario ,nombre_usuario, apellidos_usuario, fechadenacimiento_usuario, telefono_usuario, direccion_usuario, email_usuario, genero_usuario, fechadevinculacion_usuario, cargo_usuario, estado_usuario, sede, contraseña) "
	        		+ "values ('"+ident+"', '"+nombre+"','"+apellidos+"','"+fechaNac+"','"+tel+"','"+direccion+"','"+email+"','"+genero+"','"+fechaVin+"','"+cargo+"','"+estado+"','"+sede+"','"+contraseña+"')";
	        
	        try{
	           
	        	 Statement st = con.createStatement();
	             int ejecucion = st.executeUpdate(sql);
	             
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro exitoso");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Registro fallido");
	         	   return false;
	            }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
        
		}else {
			 JOptionPane.showMessageDialog(null, "Registro fallido, el usuario ya existe");
			 return false;
		}
        
    }
	
	
	
	  public boolean buscar (Usuario usuario, int id){
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	        int cedula = id;
	        String sql = "SELECT * FROM usuarios WHERE id_usuario='"+cedula+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           
	           if(rs.next()){
	        	   
	        	   usuario.setId(rs.getInt("id_usuario"));
	        	   usuario.setNombre(rs.getString("nombre_usuario"));
	        	   usuario.setApellidos(rs.getString("apellidos_usuario"));
	        	   usuario.setFechaNacimiento(rs.getDate("fechaDeNacimiento_usuario"));
	        	   usuario.setTelefono(rs.getString("telefono_usuario"));
	        	   usuario.setDireccion(rs.getString("direccion_usuario"));
	        	   usuario.setEmail(rs.getString("email_usuario"));
	        	   usuario.setGenero(rs.getString("genero_usuario"));
	        	   usuario.setFechaVinculacion(rs.getDate("fechaDeVinculacion_usuario"));
	        	   usuario.setCargo(rs.getString("cargo_usuario"));
	        	   usuario.setEstado(rs.getString("estado_usuario"));
	        	   usuario.setId_sede(rs.getInt("sede"));
	        	   usuario.setPassword(rs.getString("contraseña"));
	               return true;
	           }else {
	        	   JOptionPane.showMessageDialog(null, "El numero de usuario no existe");
	        	   return false;
	           }
	           
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	            
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    }
	  
	  
	  public boolean modificarContraseña(String nuevaContraseña, int id ){
		  
		  	String contraseña = nuevaContraseña;
	        int idUsuario = id;
		  	Connection con = getConnection();
	        
	        String sql = "UPDATE usuarios SET contraseña='"+contraseña+"' WHERE id_usuario='"+idUsuario+"'";
	        
	        try{
	        	
	        	Statement st = con.createStatement();
	        	boolean ejecucion = st.execute(sql);
	        	
	           if(ejecucion == false) {
	        	   JOptionPane.showMessageDialog(null, "Cambio exitoso");
	        	   return true;
	           }else {
	        	   JOptionPane.showMessageDialog(null, "Cambio fallido");
	        	   return false;
	           }
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
 
	  }
	  
	  
	    public boolean eliminar(int id){
	        
	        Connection con = getConnection();
	        int idUsu = id;
	        String opcion ="inactivo";
	        String sql = "UPDATE usuarios SET estado_usuario='"+opcion+"' WHERE id_usuario='"+idUsu+"'";
	        
	        try{
	        	Statement st = con.createStatement();
	            int ejecucion = st.executeUpdate(sql);
	            if(ejecucion != 0) {
	         	   JOptionPane.showMessageDialog(null, "Registro eliminado");
	         	   return true;
	            }else {
	         	   JOptionPane.showMessageDialog(null, "Error, no se elimino el registro");
	         	   return false;
	            }
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    }
	    
	    
	    public boolean modificar(Usuario usuario){
	    	
	    	int ident = usuario.getId();
			String nombre = usuario.getNombre();
			String apellidos = usuario.getApellidos();
			Date fechaNac = usuario.getFechaNacimiento();
			String tel = usuario.getTelefono();
			String direccion = usuario.getDireccion();
			String email = usuario.getEmail();
			String genero = usuario.getGenero();
			Date fechaVin = usuario.getFechaVinculacion();
			String cargo = usuario.getCargo();
			String estado = usuario.getEstado();
			int sede = usuario.getId_sede();
			String contraseña = usuario.getPassword();
			Connection con = getConnection();
				
			String sql = "UPDATE usuarios SET nombre_usuario='"+nombre+"', apellidos_usuario='"+apellidos+"', fechadenacimiento_usuario='"+fechaNac+"', telefono_usuario='"+tel+"', direccion_usuario='"+direccion+"', email_usuario='"+email+"', genero_usuario='"+genero+"', fechadevinculacion_usuario='"+fechaVin+"', cargo_usuario='"+cargo+"', estado_usuario='"+estado+"', sede='"+sede+"', contraseña='"+contraseña+"' WHERE id_usuario='"+ident+"'";
			        	
				
		        try{
		        	
		        	Statement st = con.createStatement();
		            int ejecucion = st.executeUpdate(sql);
		            
		            if(ejecucion != 0) {
		         	   JOptionPane.showMessageDialog(null, "Registro exitoso");
		         	   return true;
		            }else {
		         	   JOptionPane.showMessageDialog(null, "Registro fallido");
		         	   return false;
		            }
		           
		           
		        }catch(SQLException e) {
		            System.err.println(e);
		            return false;
		        } finally{
		            try{
		                con.close();
		            }catch (SQLException e){
		                System.err.println(e);
		            }
		        }
	        
	    	
	    }
	    
	    public boolean confirmarExistenciaUsuario(int id){
	        
	    	int idUsu = id;
	        Connection con = getConnection();
	        String sql = "SELECT * FROM usuarios WHERE id_usuario='"+idUsu+"' ";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(rs+"este es el resultado de rs");
	           
	           if(rs.next()){
	        	   System.out.println("si existe el usuario");
	               return true;
	           }else {
	        	   System.out.println("no existe el usuario");
	               return false;
	           }
	           
	        }catch(SQLException e) {
	            System.err.println(e);
	            return false;
	        } finally{
	            try{
	                con.close();
	            }catch (SQLException e){
	                System.err.println(e);
	            }
	        }
	    }
	
}
