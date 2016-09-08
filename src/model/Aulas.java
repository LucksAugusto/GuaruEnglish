package model;

public class Aulas {

	private String id_aluno;
	private String id_professor;
	private String id_modulo;
	private String nota1;
	private String nota2;
	private String notaFinal;
	private Integer quantidadeAulas;
	private Integer faltas;
    private Double frequencia;
    
	public String getId_aluno() {
		return id_aluno;
	}
	public void setId_aluno(String id_aluno) {
		this.id_aluno = id_aluno;
	}
	public String getId_professor() {
		return id_professor;
	}
	public void setId_professor(String id_professor) {
		this.id_professor = id_professor;
	}
	public String getId_modulo() {
		return id_modulo;
	}
	public void setId_modulo(String id_modulo) {
		this.id_modulo = id_modulo;
	}
	public String getNota1() {
		return nota1;
	}
	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}
	public String getNota2() {
		return nota2;
	}
	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}
	public String getNotaFinal() {
		return notaFinal;
	}
	public void setNotaFinal(String notaFinal) {
		this.notaFinal = notaFinal;
	}
	public Integer getQuantidadeAulas() {
		return quantidadeAulas;
	}
	public void setQuantidadeAulas(Integer quantidadeAulas) {
		this.quantidadeAulas = quantidadeAulas;
	}
	public Integer getFaltas() {
		return faltas;
	}
	public void setFaltas(Integer faltas) {
		this.faltas = faltas;
	}
	public Double getFrequencia() {
		return frequencia;
	}
	public void setFrequencia(Double frequencia) {
		this.frequencia = frequencia;
	}
    
    
}
