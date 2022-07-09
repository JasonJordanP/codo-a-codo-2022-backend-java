package ar.com.codoacodo.controller;


import java.util.List;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ar.com.codoacodo.daos.ProductoDAO;
import ar.com.codoacodo.dto.Producto;

@WebServlet("/api/ListadoController")
public class ListadoController extends HttpServlet {
				
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					
	//crear la instancia DE ProductoDAO
				ProductoDAO dao = new ProductoDAO();
					
	//invocar al metodo listarProductos()   QUE ESTÁ EN EL PAQUETE DAOS en "ProductoDAOS"
				List<Producto> listado = dao.listarProductos();
					
	//grabar el listado en el request para que lo vea la siguiente pagina
				req.setAttribute("listado", listado);
					
	//ir a la siguiente pagina
				getServletContext().getRequestDispatcher("/listado.jsp").forward(req, resp);
				}
			}
	
			
		
			