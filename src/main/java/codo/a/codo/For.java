package codo.a.codo;

import java.util.Scanner;

public class For {

	public static void main(String[] args) {
		//Mostarar los primeros N n�meros, donde N es le�d opor teclado
		
		Scanner teclado = new Scanner(System.in);
		System.out.println("Ingrese N");
		
		int n = teclado.nextInt();
		
		for(int i=0; i<=n; i++) {
			System.out.println(i);
		}
		teclado.close();

	} 
}
