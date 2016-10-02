package controller;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MenuMB {

	public String novoAlunoRedirect() {
		return "cadAluno?faces-redirect=true";
	}
	public String desativaAlunoRedirect() {
		return "offAluno?faces-redirect=true";
	}
	public String ativaAlunoRedirect() {
		return "onAluno?faces-redirect=true";
	}
	public String fechaRequerimentoRedirect() {
		return "reqAluno?faces-redirect=true";
	}
	public String novoProfessorRedirect() {
		return "cadProfessor?faces-redirect=true";
	}
	public String desativaProfRedirect() {
		return "offProfessor?faces-redirect=true";
	}
	public String novoModuloRedirect() {
		return "cadModulo?faces-redirect=true";
	}
}
