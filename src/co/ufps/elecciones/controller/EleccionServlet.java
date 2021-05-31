package co.ufps.elecciones.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import co.ufps.elecciones.dao.CandidatoDao;
import co.ufps.elecciones.dao.CandidatoDaoPostgreSQL;
import co.ufps.elecciones.modelo.Candidato;

/**
 * Servlet implementation class EleccionServlet
 */
@WebServlet("/")
public class EleccionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CandidatoDao candidatoDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EleccionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub 
	
		this.candidatoDao= new CandidatoDaoPostgreSQL(); //Inicializar instancia de candidato Postgre
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath(); // capturamos la peticion
		try{
		switch (action){  // validar el tipo de accion
		case "/new":
			showNewForm(request,response ); 
			break;
		case "/insert":
			insertarCandidato(request,response);	
			break;
		case "/delete":
			eliminarCandidato(request,response);
			break;
		case "/edit":
			showEditForm(request,response ); 
			break;
		case "/update":
			actualizarCandidato(request,response);
			break;
			default:
				listCandidatos(request,response);
				break;
		}
		} catch (SQLException e){
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void showNewForm(HttpServletRequest request,HttpServletResponse response ) throws ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request,response);
	}
	
	private void insertarCandidato(HttpServletRequest request,HttpServletResponse response ) 
			throws ServletException, SQLException, IOException{
		String documento =  request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Integer eleccion =Integer.parseInt(request.getParameter("eleccion")); 
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		
		Candidato candidato = new Candidato (documento, nombre, apellido, eleccion, numero);	
		candidatoDao.insert(candidato);
		
		response.sendRedirect("list");
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Candidato candidatoActual = candidatoDao.select(id);
		
		request.setAttribute("candidato",candidatoActual);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidato.jsp");
		dispatcher.forward(request,response);
		
	}
	
	private void actualizarCandidato(HttpServletRequest request,HttpServletResponse response ) 
			throws ServletException, SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id")); 	
		
		String documento =  request.getParameter("documento");
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Integer eleccion =Integer.parseInt(request.getParameter("eleccion")); 
		Integer numero = Integer.parseInt(request.getParameter("numero"));
		
		Candidato candidato = new Candidato (id, documento, nombre, apellido, eleccion, numero);	
		candidatoDao.update(candidato);
		
		response.sendRedirect("list");
	}
	
	private void eliminarCandidato(HttpServletRequest request,HttpServletResponse response ) 
			throws ServletException, SQLException, IOException{
		int id = Integer.parseInt(request.getParameter("id")); 	
			
		candidatoDao.delete(id);
		
		response.sendRedirect("list");
	}
	
	private void listCandidatos (HttpServletRequest request,HttpServletResponse response ) 
			throws ServletException, SQLException, IOException{
		List<Candidato> listCandidatos  = candidatoDao.selectAll();
		request.setAttribute( "listCandidatos", listCandidatos);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("candidatolist.jsp");
		dispatcher.forward(request,response);
	}

	
}
