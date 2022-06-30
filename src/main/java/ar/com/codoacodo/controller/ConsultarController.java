package ar.com.codoacodo.controller;

import java.beans.Statement;

import java.io.IOException;
import java.sql.Connection;
import java.util.Date;
import java.sql.ResultSet;

import ar.com.codoacodo.connection.AdministradordeConexiones;
import ar.com.codoacodo.dto.Producto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/ConsultarController")
//HERENCIA
public class ConsultarController extends HttpServlet{

		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			String id = req.getParameter("id");
			
			//ARMO EL SQL
			
			//ACA HAY QUE AGREGAR VALIDACIONES
			
			String sql = "SELECT * FROM PRODUCTO WHERE ID = " + id;
			
			//OBTENGO LA CONEXION
			
			Connection con = AdministradordeConexiones.getConnection();
			//STATENMENT
			try {
			java.sql.Statement st = con.createStatement();
			
			//ESTO NOS DEVULEVE UN RESULT SET:
			ResultSet rs = st.executeQuery(sql);
			
			if(rs.next()) {
			//DADO EL RS QUE TENGO voy sacando los resultados
			Long idProducto = rs.getLong(1);  //toma la primera columna en base a lo qque está en el heidi
			String nombre = rs.getString(2); //toma la segunda columna
			Float precio = rs.getFloat(3); //toma la tercera columna
			Date fecha = rs.getDate (4); //toma la cuarta columna 
			String imagen = rs.getString(5);
			String codigo = rs.getString(6);
			
			
			//CREO EL OBJETO "PRODUCTO"
			
			Producto prodFromDataBase = new Producto (idProducto, nombre, precio, fecha, imagen, codigo);
		
			//ME TENGO QUE IR A OTRA PÁGINA y pasarle datos a otra página
			
			req.setAttribute("producto", prodFromDataBase);
			
			}
			
			getServletContext().getRequestDispatcher("/detalle.jsp").forward(req, resp);
			
			
			//Cierre de conexión
			con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}
		
		
		
	
			
		
			