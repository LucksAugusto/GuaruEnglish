package controller;

public class Logado {
	
	private static String usuario;
	
	public Logado(String usuario){
		Logado.setUsuario(usuario);
	}

	public static String getUsuario() {
		return usuario;
	}

	public static void setUsuario(String usuario) {
		Logado.usuario = usuario;
	}

}
