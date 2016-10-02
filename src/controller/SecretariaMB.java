package controller;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import model.Aluno;
import model.Modulo;
import model.Professor;
import persistance.AlunoDAO;
import persistance.SecretariaDAO;

@ManagedBean
public class SecretariaMB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Aluno> alunoList = new ArrayList<Aluno>();
	private SecretariaDAO secretariaDao = new SecretariaDAO();
	private Aluno aluno = new Aluno();
	private Professor professor = new Professor();
	private Modulo modulo = new Modulo();
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Modulo getModulo() {
		return modulo;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
	}

	private Integer idAluno;
	private Integer idProf;
	
	public Integer getIdProf() {
		return idProf;
	}

	public void setIdProf(Integer idProf) {
		this.idProf = idProf;
	}

	public Integer getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(Integer idAluno) {
		this.idAluno = idAluno;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public SecretariaMB() {
		AlunoDAO daoAluno = new AlunoDAO();
		try {
			setAlunoList(daoAluno.carregaRequerimentos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String novoAluno() throws SQLException{
		secretariaDao.novoAluno(aluno);
		return "success3?faces-redirect=true";
	}
	
	public String novoProfessor() throws SQLException{
		secretariaDao.novoProf(professor);
		return "success3?faces-redirect=true";
	}
	
	public String novoModulo() throws SQLException{
		secretariaDao.novoModulo(modulo);
		return "success3?faces-redirect=true";
	}
	
	public String desativaAluno() throws SQLException{
		secretariaDao.desativaAluno(idAluno);
		return "success4?faces-redirect=true";
	}
	
	public String ativaAluno() throws SQLException{
		secretariaDao.ativaAluno(idAluno);
		return "success6?faces-redirect=true";
	}
	
	public String desativaProf() throws SQLException{
		secretariaDao.desativaProf(idProf);
		return "success4?faces-redirect=true";
	}
	
	public String fechaRequerimento() throws SQLException{
		secretariaDao.fechaRequerimento(idAluno);
		return "success5?faces-redirect=true";
	}
	
	public String voltar() {
		String pagina = "secretaria.xhtml";
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return pagina;
	}

	public ArrayList<Aluno> getAlunoList() {
		return alunoList;
	}

	public void setAlunoList(ArrayList<Aluno> alunoList) {
		this.alunoList = alunoList;
	}
	
	
}
