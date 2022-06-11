package codo.a.codo;

import java.util.Scanner;

public class Switch {

	public static void main(String[] args) {
		Scanner teclado = new Scanner (System.in); //el escaner te permite ingresar datos abajo
		System.out.println("Ingrese nota"); //pones mensaje para el usuario
		
		int nota = teclado.nextInt();// "nota" toma el valor que uno ingrese
		
		//poner "swi" + cntrl + espacio y enter para que se arme todo esto automáticamente
		switch (nota) {
		case 7:
			System.out.println("aprobado");
			break;
		case 10:
			System.out.println("excelente");
		default:
			System.out.println("no sé");
			break;
		}
		//CIERRO EL "TECLADO" (LINEA 11)
		teclado.close();
	}

}
