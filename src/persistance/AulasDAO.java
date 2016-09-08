package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Aulas;

public class AulasDAO {

	public ArrayList<Aulas> carregaNotas(String user) throws Exception {
		ArrayList<Aulas> notasList = new ArrayList<Aulas>();
		String SQL = "SELECT al.nome, p.nome, c.idioma, a.nota1, a.nota2, a.notaFinal, a.quantidadeAulas, a.faltas, a.frequencia"
				+ " FROM aulas a"
				+ " INNER JOIN modulo m ON m.id_modulo = a.id_modulo"
				+ " INNER JOIN curso c ON m.id_curso = c.id_curso"
				+ " INNER JOIN aluno al ON al.ra = a.id_aluno AND al.ra LIKE ?"
				+ " INNER JOIN professor p ON p.id_professor = a.id_professor";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setString(1, user);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Aulas aula = new Aulas();
			aula.setId_aluno(rs.getString(1));
			aula.setId_professor(rs.getString(2));
			aula.setId_modulo(rs.getString(3));
			aula.setNota1(rs.getString(4));
			aula.setNota2(rs.getString(5));
			aula.setNotaFinal(rs.getString(6));
			aula.setQuantidadeAulas(rs.getInt(7));
			aula.setFaltas(rs.getInt(8));
			aula.setFrequencia(rs.getDouble(9));
			notasList.add(aula);
		}
		stmt.close();
		rs.close();
		return notasList;
	}
	
	public void requerimento(String user) throws SQLException{
		String SQL = "UPDATE aluno SET requerimento=1 WHERE ra = ?";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setString(1, user);
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	public void atribuirNota(Aulas aula) throws SQLException{
		String SQL = "UPDATE aulas SET "
				+ "nota1=?,"
				+ "nota2=?,"
				+ "notaFinal=?,"
				+ "quantidadeAulas=?,"
				+ "faltas=?,"
				+ "frequencia=? "
				+ "WHERE id_aluno=?";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		stmt.setString(1, aula.getNota1());
		stmt.setString(2, aula.getNota2());
		stmt.setString(3, aula.getNotaFinal());
		stmt.setInt(4, aula.getQuantidadeAulas());
		stmt.setInt(5, aula.getFaltas());
		stmt.setDouble(6, aula.getFrequencia());
		stmt.setInt(7, Integer.parseInt(aula.getId_aluno()));
		ResultSet rs = stmt.executeQuery();
		stmt.close();
		rs.close();
	}
	
	/*public static void main(String[] args) {
		AulasDAO dao = new AulasDAO();
		ArrayList<Aulas> list;
		try {
			list = dao.carregaNotas("1");
			for(Aulas a : list) {
				System.out.println(a.getId_aluno());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}*/
	
		
}
