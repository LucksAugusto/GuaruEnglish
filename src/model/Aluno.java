package model;

public class Aluno {

	private Integer id;
	private Integer ra;
	private String modulo;
	private String nome;
	private String senha;
	private String rg;
	private Float pagamento;
	private Integer desconto;
	private String dataMatricula;
	private Integer parcelas;
	private Integer requerimento;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRa() {
		return ra;
	}
	public void setRa(Integer ra) {
		this.ra = ra;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public Float getPagamento() {
		return pagamento;
	}
	public void setPagamento(Float pagamento) {
		this.pagamento = pagamento;
	}
	public Integer getDesconto() {
		return desconto;
	}
	public void setDesconto(Integer desconto) {
		this.desconto = desconto;
	}
	public String getDataMatricula() {
		return dataMatricula;
	}
	public void setDataMatricula(String dataMatricula) {
		this.dataMatricula = dataMatricula;
	}
	public Integer getParcelas() {
		return parcelas;
	}
	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}
	public Integer getRequerimento() {
		return requerimento;
	}
	public void setRequerimento(Integer requerimento) {
		this.requerimento = requerimento;
	}
	
}
