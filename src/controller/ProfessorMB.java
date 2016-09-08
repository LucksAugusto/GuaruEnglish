package controller;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Aulas;
import persistance.AulasDAO;

@ManagedBean
public class ProfessorMB implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Aulas aulas = new Aulas();
	private AulasDAO dao = new AulasDAO();
	
	public ProfessorMB() {
		setAulas(new Aulas());
	}
	
	public String atribuir() throws SQLException{
		dao.atribuirNota(aulas);
		return "success2?faces-redirect=true";
	}
	
	public String voltar() {
		String pagina = "professor.xhtml";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pagina;
	}

	public Aulas getAulas() {
		return aulas;
	}

	public void setAulas(Aulas aulas) {
		this.aulas = aulas;
	}
}
