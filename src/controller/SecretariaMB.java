package controller;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import model.Aluno;
import persistance.AlunoDAO;

@ManagedBean
public class SecretariaMB {

	private ArrayList<Aluno> alunoList = new ArrayList<Aluno>();
	
	public SecretariaMB() {
		AlunoDAO daoAluno = new AlunoDAO();
		try {
			setAlunoList(daoAluno.carregaRequerimentos());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Aluno> getAlunoList() {
		return alunoList;
	}

	public void setAlunoList(ArrayList<Aluno> alunoList) {
		this.alunoList = alunoList;
	}
	
	
}
