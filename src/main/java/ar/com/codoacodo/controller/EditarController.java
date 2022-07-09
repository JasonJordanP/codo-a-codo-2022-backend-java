package ar.com.codoacodo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.daos.ProductoDAO;
import ar.com.codoacodo.dto.Producto;

@WebServlet("/api/EditarController")
public class EditarController extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		//Crear ProductoDAO
		ProductoDAO dao = new ProductoDAO();
		
		//invocar el metodo obtenerPorId(id)
		Producto prodFromDataBase = dao.obtenerPorId(Long.parseLong(id));
		
		//guardar en el request el producto
		req.setAttribute("producto", prodFromDataBase);
		
		//ir a la siguiente pagina
		getServletContext().getRequestDispatcher("/editar.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String nombre = req.getParameter("nombre");
		String precio = req.getParameter("precio");
		String imagen = req.getParameter("imagen");
		String codigo = req.getParameter("codigo");
		
		//Crear ProductoDAO
		ProductoDAO dao = new ProductoDAO();
		
		//invocar actualizarProducto(params)
		dao.actualizarProducto(codigo, nombre, precio);

		//ir a la siguiente pagina
		resp.sendRedirect(req.getContextPath()+"/api/ListadoController");
	}
}
	
			
		
			