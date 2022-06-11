package codo.a.codo;

public class Operadores {

	public static void main(String[] args) {
		// ARITMÉTICOS (+,-,*,/)
		//RELACIONALES (>,<,>=,<=,!=)
		//LOGICOS (&&, ||, !=    and, or,not)
		
		String usuario = "root";
		String contrasenia = "root";
		
		if("root".equals(usuario) && "root".equals(contrasenia)) {
			System.out.println("OK");
		} else {
			System.out.println("ERROR");
		}

	}

}
