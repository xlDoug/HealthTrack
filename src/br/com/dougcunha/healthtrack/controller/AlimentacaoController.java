package br.com.dougcunha.healthtrack.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.dougcunha.healthtrack.dao.implement.DAOFactory;
import br.com.dougcunha.healthtrack.dao.interfaces.AlimentoDAO;
import br.com.dougcunha.healthtrack.entity.Alimento;
import br.com.dougcunha.healthtrack.entity.TipoAlimento;

/**
 * Servlet implementation class Alimentacao
 */
@WebServlet(name = "alimentacao", urlPatterns = { "/alimentacao" })
public class AlimentacaoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AlimentoDAO dao;
	private int userId;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AlimentacaoController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */

	public void init() throws ServletException {
		super.init();
		userId = 2;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		dao = DAOFactory.getAlimentoDAO();
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		
		case "listar":
			listar(request, response);
			break;

		case "editar":
			editar(request, response);
			break;
		}
		
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;

		case "atualizar":
			atualizar(request, response);
			break;
		}
		
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Alimento alimento = dao.buscar(id);
		request.setAttribute("alimento", alimento);
		request.getRequestDispatcher("editar-alimentacao.jsp").forward(request, response);
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Alimento al = new Alimento();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
			Calendar dataConsumo = Calendar.getInstance();
			dataConsumo.setTime(sdf.parse(request.getParameter("dtConsumo")));
			System.out.println("==== "+request.getParameter("codigo"));
			System.out.println(request.getParameter("codigo").getClass().getName());
			al.setId(Integer.parseInt(request.getParameter("codigo")));
			al.setData(dataConsumo);
			al.setTipoAlimento(new TipoAlimento(request.getParameter("nmTipo")));
			al.setDescricao(request.getParameter("descp"));
			al.setCaloria(Short.parseShort(request.getParameter("nrCalorias")));
			dao.atualizar(al);
			request.setAttribute("msg", "Atualizado com sucesso!");
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deu erro");
			request.setAttribute("erro", "Erro ao atualizar.");
		}
		request.getRequestDispatcher("editar-alimentacao.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alimento> lista = dao.listar(1);
		request.setAttribute("alimentos", lista);
		request.getRequestDispatcher("listar-alimentacao.jsp").forward(request, response);
	}


	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Alimento al = new Alimento();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
			Calendar dataConsumo = Calendar.getInstance();
			dataConsumo.setTime(sdf.parse(request.getParameter("dtConsumo")));
			al.setData(dataConsumo);
			al.setTipoAlimento(new TipoAlimento(request.getParameter("nmTipo")));
			al.setDescricao(request.getParameter("descp"));
			al.setCaloria(Short.parseShort(request.getParameter("nrCalorias")));
			dao.cadastrar(al, userId);
			request.setAttribute("msg", "Cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deu erro");
			request.setAttribute("erro", "Erro ao cadastrar.");
		}
		request.getRequestDispatcher("cadastrar-alimentacao.jsp").forward(request, response);
	}

}
