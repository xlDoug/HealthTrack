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
import br.com.dougcunha.healthtrack.dao.interfaces.PesoDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.UsuarioDAO;
import br.com.dougcunha.healthtrack.entity.Peso;
import br.com.dougcunha.healthtrack.entity.Usuario;

/**
 * Servlet implementation class PesoController
 */
@WebServlet("/peso")
public class PesoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PesoDAO dao;
	private UsuarioDAO uDao ;
	private int userId;
	private Usuario usuario;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		userId = 2;
		uDao = DAOFactory.getUsuarioDAO();
		usuario = uDao.buscar(userId);
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PesoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
dao = DAOFactory.getPesoDAO();
		
		String acao = request.getParameter("acao");
		
		switch (acao) {
		
		case "listar":
			listar(request, response);
			break;

		case "editar":
			editar(request, response);
			break;

		case "remover":
			int id = Integer.parseInt(request.getParameter("id"));
			try {
				dao.remover(id);
				request.setAttribute("msg", "Removido com sucesso!");

			} catch (Exception e) {
				request.setAttribute("erro", "Erro ao remover");
			}
			request.getRequestDispatcher("listar-peso.jsp").forward(request, response);

			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
	
	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Peso p = new Peso();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
			Calendar dataPesagem = Calendar.getInstance();
			dataPesagem.setTime(sdf.parse(request.getParameter("dtPesagem")));
			p.setId(Integer.parseInt(request.getParameter("codigo")));
			p.setData(dataPesagem);
			p.setPeso(Short.valueOf(request.getParameter("peso")));
			p.setUsuario(uDao.buscar(userId));
			dao.atualizar(p);
			request.setAttribute("msg", "Atualizado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deu erro");
			request.setAttribute("erro", "Erro ao atualizar.");
		}
		request.getRequestDispatcher("editar-peso.jsp").forward(request, response);
	}

	private void cadastrar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Peso p = new Peso();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-dd-MM");
			Calendar dataConsumo = Calendar.getInstance();
			dataConsumo.setTime(sdf.parse(request.getParameter("dtConsumo")));
			p.setData(dataConsumo);
			p.setPeso(Short.valueOf(request.getParameter("peso")));
			p.setUsuario(usuario);
			dao.cadastrar(p, userId);
			request.setAttribute("msg", "Cadastrado com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("deu erro");
			request.setAttribute("erro", "Erro ao cadastrar.");
		}
		request.getRequestDispatcher("cadastrar-peso.jsp").forward(request, response);
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			int id = Integer.parseInt(request.getParameter("id"));
			Peso peso = dao.buscar(id);
			request.setAttribute("peso", peso);
			request.getRequestDispatcher("editar-peso.jsp").forward(request, response);
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Peso> lista = dao.listar(1);
		request.setAttribute("pesos", lista);
		request.getRequestDispatcher("listar-peso.jsp").forward(request, response);
	}

	

}
