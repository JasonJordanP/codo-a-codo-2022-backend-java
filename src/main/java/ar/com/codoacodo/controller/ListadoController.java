package ar.com.codoacodo.controller;

import java.sql.Statement;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.sql.ResultSet;

import ar.com.codoacodo.connection.AdministradordeConexiones;
import ar.com.codoacodo.dto.Producto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/ListadoController")
//HERENCIA
public class ListadoController extends HttpServlet{

		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
			
			//ARMO EL SQL
			
			//ACA HAY QUE AGREGAR VALIDACIONES
			
			String sql = "SELECT * FROM PRODUCTO";
			
			//OBTENGO LA CONEXION
			
			Connection con = AdministradordeConexiones.getConnection();
			//STATEMENT
			try {
			Statement st = con.createStatement();
			
			//ESTO NOS DEVULEVE UN RESULT SET:
			ResultSet rs = st.executeQuery(sql);
			
			
			List<Producto> listado = new ArrayList<>();
			
			while(rs.next()) {  //mientras tenga datos
			//DADO EL RS QUE TENGO voy sacando los resultados
			Long idProducto = rs.getLong(1);  //toma la primera columna en base a lo qque est� en el heidi
			String nombre = rs.getString(2); //toma la segunda columna
			Float precio = rs.getFloat(3); //toma la tercera columna
			Date fecha = rs.getDate (4); //toma la cuarta columna 
			String imagen = rs.getString(5);
			String codigo = rs.getString(6);
			
			
			//CREO EL OBJETO "PRODUCTO"
			
			Producto prodFromDataBase = new Producto (idProducto, nombre, precio, fecha, imagen, codigo);
			
			//CARGO EL PRODUCTO EN EL LISTADO
			
			listado.add(prodFromDataBase);
			}
		
			//ME TENGO QUE IR A OTRA P�GINA y pasarle datos a otra p�gina
			
			req.setAttribute("listado", listado);
			
			
			getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
			
			
			//Cierre de conexi�n
			con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		
		
		
	
			
		
			