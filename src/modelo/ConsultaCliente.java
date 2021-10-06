package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class ConsultaCliente extends Conexion {
	
	  public boolean buscar (Cliente cliente, int id){
	        PreparedStatement ps = null;
	        ResultSet rs = null;
	        Connection con = getConnection();
	        int cedula = id;
	        String sql = "SELECT * FROM clientes WHERE id_cliente='"+cedula+"' ";
	        
	        try{
	           
	           ps = con.prepareStatement(sql);
	           rs = ps.executeQuery();
	           
	           
	           if(rs.next()){
	        	   
	        	   cliente.setIdCliente(rs.getInt("id_cliente"));
	        	   cliente.setNombreCliente(rs.getString("nombre_cliente"));
	        	   cliente.setApellidosCliente(rs.getString("apellidos_cliente"));
	        	   cliente.setDireccionCliente(rs.getString("direccion_cliente"));
	        	   cliente.setTelefonoCliente(rs.getString("telefono_cliente"));
	        	   
	               return true;
	           }else {
	        	   JOptionPane.showMessageDialog(null, "El numero de cliente no existe");
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
	  
	  
		public boolean registrar(Cliente cliente){
			
			int ident = cliente.getIdCliente();
			
				String nombre = cliente.getNombreCliente();
				String apellidos = cliente.getApellidosCliente();
				String tel = cliente.getTelefonoCliente();
				String direccion = cliente.getDireccionCliente();
				;
				
				
				
				Connection con = getConnection();
		        String sql = "INSERT INTO clientes (id_cliente ,nombre_cliente, apellidos_cliente, direccion_cliente, telefono_cliente)"
		        		+ "values ('"+ident+"', '"+nombre+"','"+apellidos+"', '"+direccion+"', '"+tel+"')";
		        
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
	  
	  
	    public boolean modificar(Cliente cliente){
	    	
	    	int ident = cliente.getIdCliente();
			String nombre = cliente.getNombreCliente();
			String apellidos = cliente.getApellidosCliente();
	
			String tel = cliente.getTelefonoCliente();
			String direccion = cliente.getDireccionCliente();
			
			Connection con = getConnection();
				
			String sql = "UPDATE clientes SET nombre_cliente='"+nombre+"', apellidos_cliente='"+apellidos+"', direccion_cliente='"+direccion+"',  telefono_cliente='"+tel+"' WHERE id_cliente='"+ident+"'";
			        	
				
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
	  
	  
	  
	    public boolean confirmarExistenciaCliente(int id){
	        
	    	int idCliente = id;
	        Connection con = getConnection();
	        String sql = "SELECT * FROM clientes WHERE id_cliente='"+idCliente+"' ";
	        
	        try{
	        	Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);
				System.out.println(rs+"este es el resultado de rs");
	           
	           if(rs.next()){
	        	   System.out.println("si existe el cliente");
	               return true;
	           }else {
	        	   System.out.println("no existe el cliente");
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
