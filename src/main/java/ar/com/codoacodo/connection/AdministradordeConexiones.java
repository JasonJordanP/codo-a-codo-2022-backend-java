package ar.com.codoacodo.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class AdministradordeConexiones {

	public static Connection getConnection() {
		String url= "jdbc:mysql://127.0.0.1:3306/codo-a-codo?serverTimeZone=UTC&userSSL=false";
		String username = "root";
		String password = "root";
		
		String driverName = "com.mysql.cj.jdbc.Driver"; //mysql|postgres
		
		
		/*String url = System.getenv("DATASOURCE_URL");
		String username = System.getenv("DATASOURCE_USERNAME");
		String password = System.getenv("DATASOURCE_PASSWORD");
		String driverName = System.getenv("DATASOURCE_DRIVER");*/
		
		//control de errores
		
		Connection con = null;
		try {
			Class.forName(driverName); //carga en memoria el driver
			con = DriverManager.getConnection(url,username,password);
		}catch(Exception e) {
			e.printStackTrace(); //Se que pasó o por qué falló
		}
		return con;
	}

	public static void main(String[] args) {
		Connection con = AdministradordeConexiones.getConnection();
		
		if (con != null) {
			System.out.println("Conexion ok");
		}else {
			System.err.println("Conexion fail");
		}
		}
}
