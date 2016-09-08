package controller;

import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import persistance.LoginDAO;

@SessionScoped
@ManagedBean
public class LoginMB {

	private String opc;
	private String user;
	private String password;
	private String msg;
	
		public String validate() {
			switch (opc) {
			case "Secretaria":
				boolean validSec = LoginDAO.validaSecretaria(user, password);
				if (validSec) {
					new Logado(user);
					Logado.setUsuario(user);
					return "secretaria?faces-redirect=true";
				} else {
					return "login?faces-redirect=true";
				}
			case "Professor":
				boolean validProf = LoginDAO.validaProfessor(user, password);
				if (validProf) {
					new Logado(user);
					Logado.setUsuario(user);
					return "professor?faces-redirect=true";
				} else {
					return "login?faces-redirect=true";
				}
			case "Aluno":
				boolean validAluno = LoginDAO.validaAluno(user, password);
				if (validAluno) {
					new Logado(user);
					Logado.setUsuario(user);
					return "aluno?faces-redirect=true";
				} else {
					return "login?faces-redirect=true";
				}
			default:
				return "login?faces-redirect=true";
			}
		}
		
	public String logout(){
		String pagina = "login.xhtml";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pagina;
	}
	
	
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getOpc() {
		return opc;
	}

	public void setOpc(String opc) {
		this.opc = opc;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
