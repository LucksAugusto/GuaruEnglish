package persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import model.Modulo;
import model.Professor;

public class SecretariaDAO {

	public void novoAluno(Aluno aluno) throws SQLException {
		String SQL = "INSERT INTO aluno (modulo, nome, senha, rg, pagamento, desconto, dataMatricula, parcelas, requerimento, ativado, ra) VALUES "
				+ "(?,?,?,?,?,?,?,?,0,1,?)";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, Integer.parseInt(aluno.getModulo()));
		stmt.setString(2, aluno.getNome());
		stmt.setString(3, aluno.getSenha());
		stmt.setString(4, aluno.getRg());
		stmt.setFloat(5, aluno.getPagamento());
		stmt.setInt(6, aluno.getDesconto());
		stmt.setDate(7, Date.valueOf(aluno.getDataMatricula()));
		stmt.setInt(8, aluno.getParcelas());
		stmt.setInt(9, aluno.getRa());
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	public void desativaAluno(Integer ID) throws SQLException {
		String SQL = "UPDATE aluno SET ativado = 0 where id = ?";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	public void ativaAluno(Integer ID) throws SQLException {
		String SQL = "UPDATE aluno SET ativado = 1 where id = ?";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	public void novoProf(Professor professor) throws SQLException {
		String SQL = "INSERT INTO professor (modulo, nome, user, senha, cargaHoraria, salario, especialidade, ativado) VALUES "
				+ "(?,?,?,'professorguaru',?,?,?,1)";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, professor.getId_modulo());
		stmt.setString(2, professor.getNome());
		stmt.setString(3, professor.getUser());
		stmt.setInt(4, professor.getCargaHoraria());
		stmt.setInt(5, professor.getSalario());
		stmt.setString(6, professor.getEspecialidade());
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	public void desativaProf(Integer ID) throws SQLException {
		String SQL = "UPDATE professor SET ativado = 0 where id_professor = ?";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	public void fechaRequerimento(Integer ID) throws SQLException {
		String SQL = "UPDATE aluno SET requerimento = 0 where id = ?";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, ID);
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	public void novoModulo(Modulo modulo) throws SQLException {
		String SQL = "INSERT INTO modulo (id_curso, nivel, cargaHoraria, preco, publico, semestre, ano, conteudo) VALUES "
				+ "(?,?,?,?,?,?,?,?)";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setInt(1, modulo.getId_curso());
		stmt.setString(2, modulo.getNivel());
		stmt.setInt(3, modulo.getCargaHoraria());
		stmt.setFloat(4, modulo.getPreco());
		stmt.setString(5, modulo.getPublico());
		stmt.setInt(6, modulo.getSemestre());
		stmt.setInt(7, modulo.getAno());
		stmt.setString(8, modulo.getConteudo());
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
}
