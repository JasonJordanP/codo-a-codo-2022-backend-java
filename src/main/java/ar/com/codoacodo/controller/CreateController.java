package ar.com.codoacodo.controller;

import java.sql.Statement;
import java.io.IOException;
import java.sql.Connection;

import ar.com.codoacodo.connection.AdministradordeConexiones;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CreateController")
//HERENCIA
public class CreateController extends HttpServlet{

		@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//RECIBE LOS DATOS EN EL FRONT
		
		
		//en req viene los datos que manda el formulario HTML
			//clave = valor
			
		
			
		
			
			
		String nombre = req.getParameter("nombre");
		String precio = req.getParameter("precio");
		String fechaCreacion = "";  //ESTE DATO SE LO DAMOS NOSOTROS
		String imagen = req.getParameter("imagen");
		String codigo = req.getParameter("codigo");
		
		//pedir una conexión: AdministradordeConexion.getConnection();
		
		Connection con = AdministradordeConexiones.getConnection();
		if(con != null) {
			//insert en la database > SQL: INSERT INTO...
			String sql = "INSERT INTO PRODUCTO (nombre, precio, fecha_creacion, imagen, codigo)";
			sql += "VALUES('"+nombre+"',"+precio+", CURDATE(), '"+imagen+"','"+codigo+"')";
			
			
			//ESTO ES UN CONTROL DE ERRORES
			try {
				Statement st = con.createStatement();
					st.execute(sql);
					
					//Cierre de la conexión
					
					con.close();
	
					//ESTO NO getServletContext().getRequestDispatcher("/api/ListadoController.jsp").forward(req, resp);
					
					resp.sendRedirect(req.getContextPath()+"api/ListadoController");
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	}

}
