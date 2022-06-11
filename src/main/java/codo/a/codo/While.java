package codo.a.codo;

public class While {

	public static void main(String[] args) {
		
		int contador = 10;
		
		while (contador>= 0) {
			System.out.println("Contador: " + contador);
			
			
			if(contador %2 == 0) {
				System.out.println(contador + "par");
			} else {
				System.out.println(contador + "inpar");

			}
			contador --;
			/* para saber si un número par o impar, hay que poner
			 * contador (o el valor que sea) %2 == 0
			 */
		}

	}

}
