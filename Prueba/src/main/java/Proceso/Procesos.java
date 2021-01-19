package Proceso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.entidades.Proveedor;

public class Procesos {

	public static void listado() throws SQLException{
			List<Proveedor> listadoProveedores = new ArrayList<Proveedor>();
			
	    	final String DRIVER = "org.hibernate.dialect.MySQLDialect";
	    	final String URL_CONEXION = "jdbc:mysql://localhost/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	    
	  
	        final String usuario = "root";
	        final String password = "root";
	        Connection dbConnection = null;
	        Statement statement = null;
	        
	        try {
	            Class.forName(DRIVER);
	            Connection conn = DriverManager.getConnection(URL_CONEXION, usuario, password);
	            String selectTableSQL = "SELECT * FROM proveedores";
	            statement = conn.createStatement();
	            ResultSet rs = statement.executeQuery(selectTableSQL);
	            while (rs.next()) {
	                int id = rs.getInt("ID");
	                String nombre = rs.getString("NOMBRE");
	                Date fechaAlta = rs.getDate("FECHA_DE_ALTA");
	                int idCliente = rs.getInt("ID_CLIENTE");
	                System.out.println("userid : " + id);
	                System.out.println("userid : " + nombre);
	                System.out.println("userid : " + fechaAlta);
	                System.out.println("userid : " + idCliente);
	 
	                Proveedor  proveedor = new Proveedor(id,nombre,fechaAlta,idCliente);
	                listadoProveedores.add(proveedor);        
	            }
	        } catch (SQLException e) {
	            System.out.println(e.getMessage());
	        } catch (ClassNotFoundException e) {
	            System.out.println(e.getMessage());
	        } finally {
	            if (statement != null) {
	                statement.close();
	            }
	            if (dbConnection != null) {
	                dbConnection.close();
	            }
	        }
	      
	         try(FileWriter fw = new FileWriter("myfile.txt", true);
             	    BufferedWriter bw = new BufferedWriter(fw);
             	    PrintWriter out = new PrintWriter(bw))
             	{
	        	 out.println("ID" + ", " + "NOMBRE" + ", " + "FECHA DE ALTA" + ", " + "ID CLIENTE");	
	        	 listadoProveedores.forEach((it)-> {
	        		 out.println(it.getId() + ", " + it.getNombre() + ", " + it.getFechaAlta() + ", " + it.getIdCliente());
	        		 });
          
             	} catch (IOException e) {
             	  
             	}
	}

	public Procesos() {
		// TODO Auto-generated constructor stub
	}

}
