package br.com.dougcunha.healthtrack.testes;

import java.util.List;

import br.com.dougcunha.healthtrack.dao.implement.DAOFactory;
import br.com.dougcunha.healthtrack.dao.interfaces.AlimentoDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.AtividadeDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.PesoDAO;
import br.com.dougcunha.healthtrack.dao.interfaces.PressaoArterialDAO;
import br.com.dougcunha.healthtrack.entity.Alimento;
import br.com.dougcunha.healthtrack.entity.Atividade;
import br.com.dougcunha.healthtrack.entity.Peso;
import br.com.dougcunha.healthtrack.entity.PressaoArterial;

public class DaoTest {
	
	public static void main(String[] args) {
		
		PesoDAO pesoDao = DAOFactory.getPesoDAO();
		//UsuarioDAO userDAO = DAOFactory.getUsuarioDAO();
		AlimentoDAO alDAO = DAOFactory.getAlimentoDAO();
		AtividadeDAO aDAO = DAOFactory.getAtividadeDAO();
		PressaoArterialDAO pDAO = DAOFactory.getPressaoArterialDAO();
		
		//Usuario u = userDAO.buscar(2);
		//System.out.println(u);

		//PESO ------------------------------
		//Peso p = pesoDao.buscar(2);
		//System.out.println(p);
		for (Peso p : pesoDao.listar(1)) {
				System.out.println(p);
		}
		//Peso p = new Peso(Calendar.getInstance(), userDAO.buscar(1), 99.0F);
		//Peso p = new Peso(3, Calendar.getInstance(), userDAO.buscar(2), 99.0F);
		//pesoDao.cadastrar(p);
		//pesoDao.remover(2);
		//pesoDao.atualizar(p);
		
		// ALIMENTO ---------------------------
		//Alimento a = new Alimento(Calendar.getInstance(), userDAO.buscar(2),(short) 9000, 2, "Banana amassada com aveia", new TipoAlimento("SOLIDO"));
		//aDAO.cadastrar(a);
		//aDAO.atualizar(a);
		//aDAO.remover(2);
		System.out.println(alDAO.buscar(20000));
		for (Alimento alimento : alDAO.listar(2)) {
			System.out.println(alimento);
		}
		
		// ATIVIDADE ---------------------------
		//Atividade t = new Atividade(Calendar.getInstance(), "50 metros", userDAO.buscar(2), new Short("100"), 2,new TipoAtividade("Natacao"));
		//aDAO.cadastrar(t);
		//aDAO.atualizar(t);
		//aDAO.remover(340000);
		//System.out.println(aDAO.buscar(2));
		List<Atividade> listaAtividades = aDAO.listar(2);
		for (Atividade atividade : listaAtividades) {
			System.out.println(atividade);
		}
		//Calendar cal = new GregorianCalendar(1992, 11, 12);
		//PressaoArterial p = new PressaoArterial(2, cal, userDAO.buscar(2), 110F, 80F);
		//pDAO.cadastrar(p);
		//pDAO.atualizar(p,2);
		//pDAO.remover(1);
		//System.out.println(pDAO.buscar(2));
		List<PressaoArterial> listaPressao = pDAO.listar(1);
		for (PressaoArterial pressaoArterial : listaPressao) {
			System.out.println(pressaoArterial);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
