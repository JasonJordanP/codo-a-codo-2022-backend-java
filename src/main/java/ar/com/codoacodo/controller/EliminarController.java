package ar.com.codoacodo.controller;

import java.io.IOException;
import ar.com.codoacodo.daos.ProductoDAO;

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
			
			ProductoDAO dao = new ProductoDAO();
			
			dao.eliminarProducto(Long.parseLong(id));
			
			resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
			
		}
	}

