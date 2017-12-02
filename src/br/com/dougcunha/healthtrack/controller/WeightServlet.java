package br.com.dougcunha.healthtrack.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dougcunha.healthtrack.dao.implement.DAOFactory;
import br.com.dougcunha.healthtrack.dao.interfaces.PesoDAO;
import br.com.dougcunha.healthtrack.entity.Peso;

/**
 * Servlet implementation class WeightServlet
 */
@WebServlet("/weight")
public class WeightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PesoDAO dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public WeightServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		dao = DAOFactory.getPesoDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Peso> listaPeso = dao.listar(2);
		request.setAttribute("pesagens", listaPeso);
		request.getRequestDispatcher("weight/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
