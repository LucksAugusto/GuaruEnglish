package model;

import java.util.Date;

public class Usuario {

	private Integer id;
	private String nome;
	private String user;
	private String senha;
	private String cargo;
	private String acesso;
	private Date dataSenha;
	private Integer primeiroAcesso;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	public String getAcesso() {
		return acesso;
	}
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	public Date getDataSenha() {
		return dataSenha;
	}
	public void setDataSenha(Date dataSenha) {
		this.dataSenha = dataSenha;
	}
	public Integer getPrimeiroAcesso() {
		return primeiroAcesso;
	}
	public void setPrimeiroAcesso(Integer primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}
	
}
