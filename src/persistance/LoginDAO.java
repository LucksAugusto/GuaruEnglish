package persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	
	public static boolean validaSecretaria(String user, String password) {
		try {
			String SQL = "SELECT user, senha FROM usuario WHERE user = ? and senha = ?";
			Connection con = GenericDAO.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL);
			stmt.setString(1, user);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	public static boolean validaProfessor(String user, String password) {
		try {
			String SQL = "SELECT user, senha FROM professor WHERE user = ? and senha = ?";
			Connection con = GenericDAO.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL);
			stmt.setString(1, user);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	
	public static boolean validaAluno(String user, String password) {
		try {
			String SQL = "SELECT ra, senha FROM aluno WHERE ra = ? and senha = ?";
			Connection con = GenericDAO.getInstance().getConnection();
			PreparedStatement stmt = con.prepareStatement(SQL);
			stmt.setString(1, user);
			stmt.setString(2, password);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
}
