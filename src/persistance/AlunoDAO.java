package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Aluno;

public class AlunoDAO {
	public ArrayList<Aluno> carregaRequerimentos() throws Exception {
		ArrayList<Aluno> alunoReq = new ArrayList<Aluno>();
		String SQL = "SELECT a.ra, c.idioma, a.nome, a.rg, a.requerimento FROM aluno a"
				+ " INNER JOIN modulo m ON m.id_modulo = a.modulo"
				+ " INNER JOIN curso c ON m.id_curso = c.id_curso"
				+ " WHERE a.requerimento = 1";
		Connection con = GenericDAO.getInstance().getConnection();
		PreparedStatement stmt = con.prepareStatement(SQL);
		ResultSet rs = stmt.executeQuery();
		while (rs.next()) {
			Aluno aluno = new Aluno();
			aluno.setRa(rs.getInt(1));
			aluno.setModulo(rs.getString(2));
			aluno.setNome(rs.getString(3));
			aluno.setRg(rs.getString(4));
			alunoReq.add(aluno);
		}
		stmt.close();
		rs.close();
		return alunoReq;
	}
	/*
	public static void main(String[] args) {
		AlunoDAO dao =new AlunoDAO();
		ArrayList<Aluno> aluno;
		try {
			aluno = dao.carregaRequerimentos();
			for(Aluno a : aluno) {
				System.out.println(a.getModulo());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}*/
}
