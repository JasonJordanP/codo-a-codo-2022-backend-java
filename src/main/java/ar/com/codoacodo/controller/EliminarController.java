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


@WebServlet("/api/EliminarController")
//HERENCIA
public class EliminarController extends HttpServlet{

		@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			
		String id = req.getParameter("id");
	
		
		//pedir una conexión: AdministradordeConexiones.getConnection();
		
		Connection con = AdministradordeConexiones.getConnection();
		if(con != null) {
			//delete en la database
			String sql = "DELETE FROM PRODUCTO WHERE id="+id;
			
			
			//ESTO ES UN CONTROL DE ERRORES
			try {
				Statement st = con.createStatement();
					st.executeUpdate(sql);
					
					//Cierre de la conexión
					
					con.close();
	
					//ESTO NO getServletContext().getRequestDispatcher("/api/ListadoController.jsp").forward(req, resp);
					
					resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
			} catch (Exception e) {
				e.printStackTrace();
			}
			}
	}

}
