package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Aulas;
import persistance.AulasDAO;

@ManagedBean
public class AlunoMB {

	private ArrayList<Aulas> aulasList = new ArrayList<Aulas>();
	String user = Logado.getUsuario();
	
	public AlunoMB(){
		AulasDAO daoAulas = new AulasDAO();
		try {
			setAulasList(daoAulas.carregaNotas(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String request(){
		AulasDAO daoAulas = new AulasDAO();
		try {
			daoAulas.requerimento(user);
			return "success?faces-redirect=true";
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "aluno?faces-redirect=true";
	}
	
	public String voltar(){
		String pagina = "aluno.xhtml";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pagina;
	}
	
	public ArrayList<Aulas> getAulasList() {
		return aulasList;
	}

	public void setAulasList(ArrayList<Aulas> arrayList) {
		this.aulasList = arrayList;
	}
	
}
