package ar.com.codoacodo.daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ar.com.codoacodo.connection.AdministradordeConexiones;
import ar.com.codoacodo.dto.Producto;

public class ProductoDAO {

		/*metodos del crud*/
	public Producto obtenerPorId(Long id) {
	
		
		String sql = "SELECT * FROM PRODUCTO WHERE ID= "+id;
		//CONNECTION
		Connection con = AdministradordeConexiones.getConnection();
		
		Producto prodFromDataBase = null;
		//STATEMENT
		
		try {
			
			Statement st = con.createStatement();
			
			//RESULT
			ResultSet rs = st.executeQuery(sql);
			
			//NOS ENVIA UN SOLO REGISTRO!!
			
			if(rs.next()) {  //si existen los datos...
				//DADO EL RS QUE TENGO voy sacando los resultados
				Long idProducto = rs.getLong(1);  //toma la primera columna en base a lo qque está en el heidi
				String nombre = rs.getString(2); //toma la segunda columna
				Float precio = rs.getFloat(3); //toma la tercera columna
				Date fecha = rs.getDate (4); //toma la cuarta columna 
				String imagen = rs.getString(5);
				String codigo = rs.getString(6);
				
				
				//CREO EL OBJETO "PRODUCTO"
				
				prodFromDataBase = new Producto (idProducto, nombre, precio, fecha, imagen, codigo);
			}
		} catch (SQLException e) {
				//si da algún error:
			e.printStackTrace();
		}
			return prodFromDataBase;
	}



/*metodos del crud*/
public List<Producto> listarProductos() {
	String sql = "SELECT * FROM PRODUCTO ";
	
	//Connection
	Connection con = AdministradordeConexiones.getConnection();

	List<Producto> list = new ArrayList<>();
	
	//Statement
	try {
		Statement st = con.createStatement();
		
		//resultset
		ResultSet rs = st.executeQuery(sql);
		
		//VIENE UN SOLO REGISTRO!!!
		
		while(rs.next()) {//
			// rs > sacando los datos
			Long idProducto = rs.getLong(1);//tomar la primer columna
			String nombre = rs.getString(2);
			Float precio = rs.getFloat(3);
			Date fecha = rs.getDate(4);
			String imagen = rs.getString(5);
			String codigo = rs.getString(6);
			
			//campos crear un objeto????
			Producto prodFromDataBase = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
			
			//agrego a la lista el producto
			list.add(prodFromDataBase);
		}			
		
		//cierro la conexion
		con.close();
	} catch (SQLException e) {
		// ERRORES
		e.printStackTrace();
	}
	return list;
}

/*crear un producto en la db*/
public void crearProducto(String nombre, Float precio, String imagen, String codigo) {
	
	Connection con = AdministradordeConexiones.getConnection();
	
	if(con != null) { 
		// insert en la db > SQL: INSERT INTO....
		String sql = "INSERT INTO PRODUCTO (nombre, precio,fecha_creacion,imagen,codigo) ";
		sql += "VALUES('"+nombre+"',"+precio+",	CURRENT_DATE,'"+imagen+"','"+codigo+"')";
		
		//control de errores
		try {
			Statement st = con.createStatement();			
			st.execute(sql);
			
			//cierre de conexion
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public void actualizarProducto(String codigo, String nombre, String precio) {
	Connection con = AdministradordeConexiones.getConnection();
	if(con != null) { 
		String sql = "UPDATE PRODUCTO "
				+ " set nombre='"+nombre+"',"
				+ " precio='"+precio+"'"
				+ " WHERE codigo = '"+codigo+"'"; 			
	
		try {
			Statement st = con.createStatement();			
			st.executeUpdate(sql);
			
			con.close();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*metodos del crud*/
public List<Producto> buscar(String clave) {
	String sql = "SELECT * FROM PRODUCTO WHERE nombre LIKE '%"+clave+"%' ";
	
	//Connection
	Connection con = AdministradordeConexiones.getConnection();

	List<Producto> listado = new ArrayList<Producto>();
	
	//Statement
	try {
		Statement st = con.createStatement();
		
		//resultset
		ResultSet rs = st.executeQuery(sql);
		
		//VIENE UN SOLO REGISTRO!!!
		
		if(rs.next()) {//si existe, hay uno solo
			// rs > sacando los datos
			Long idProducto = rs.getLong(1);//tomar la primer columna
			String nombre = rs.getString(2);
			Float precio = rs.getFloat(3);
			Date fecha = rs.getDate(4);
			String imagen = rs.getString(5);
			String codigo = rs.getString(6);
			
			//campos crear un objeto????
			Producto prodFromDataBase = new Producto(idProducto,nombre,precio,fecha,imagen,codigo);
			
			listado.add(prodFromDataBase);
		}			
	} catch (SQLException e) {
		// ERRORES
		e.printStackTrace();
	}
	
	return listado;
}
}