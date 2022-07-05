package ar.com.codoacodo.controller;

import java.sql.Statement;

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


@WebServlet("/api/EditarController")
//HERENCIA
public class EditarController extends HttpServlet{

		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		
			String id = req.getParameter("id");
			
			String sql = "SELECT * FROM PRODUCTO WHERE ID=" +id;
			
			//OBTENGO LA CONEXION
			
			Connection con = AdministradordeConexiones.getConnection();
			//STATEMENT
			try {
			Statement st = con.createStatement();
			
			//ESTO NOS DEVULEVE UN RESULT SET:
			ResultSet rs = st.executeQuery(sql);
			
			
			Producto prodFromDataBase = null;
			
			if(rs.next()) {  //mientras tenga datos
			//DADO EL RS QUE TENGO voy sacando los resultados
			Long idProducto = rs.getLong(1);  //toma la primera columna en base a lo qque está en el heidi
			String nombre = rs.getString(2); //toma la segunda columna
			Float precio = rs.getFloat(3); //toma la tercera columna
			Date fecha = rs.getDate (4); //toma la cuarta columna 
			String imagen = rs.getString(5);
			String codigo = rs.getString(6);
			
			
			//CREO EL OBJETO "PRODUCTO"
			
			prodFromDataBase = new Producto (idProducto, nombre, precio, fecha, imagen, codigo);
			
			//CARGO EL PRODUCTO EN EL LISTADO
			
			}
		
			//ME TENGO QUE IR A OTRA PÁGINA y pasarle datos a otra página
			
			req.setAttribute("producto", prodFromDataBase);
			
			
			getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
			
			
			//Cierre de conexión
			con.close();
			
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		

		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			String nombre = req.getParameter("nombre");//titulo1
			String precio = req.getParameter("precio");//1500
			String imagen = req.getParameter("imagen");
			String codigo = req.getParameter("codigo");//0001
			
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
					
					resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
		
		
		
	
			
		
			