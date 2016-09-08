package persistance;
				
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GenericDAO {

	public static GenericDAO instance;
	public Connection con;
	
	private GenericDAO() { 	
	try { 
		Class.forName("org.mariadb.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mariadb://127.0.0.1:3306/guarubd","root","");
		System.out.println("Conexao ok");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			} catch (SQLException e) {
			e.printStackTrace();
			} catch (Exception e) { 
			e.printStackTrace();
		}
	}
	
	public static GenericDAO getInstance() {
		if(instance == null) 
			instance = new GenericDAO();
			return instance;
	}
	
	public Connection getConnection() {
		return con;
	}
	
	public void fechaConexao(){
		try {
			if(con!=null) con.close();
			con =null;
			} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		GenericDAO dao = new GenericDAO();
		dao.getConnection();
	}
}