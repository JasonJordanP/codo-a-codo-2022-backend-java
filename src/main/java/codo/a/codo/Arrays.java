package codo.a.codo;

public class Arrays {

	public static void main(String[] args) {
		
		int[] array = new int [4]; //toma tres números en tres posiciones desde el 0 = 0, 1 y 2.
		array[0] = 10;
		array[1] = 11;
		array[2] = 12;
		array[3] = 13; //error porque arriba solo indiqué 3 espacios
		
		System.out.println("FIN");
		
		// para mostrar los valores que hay en el array:
		for(int i=0; i<array.length; i++) {
			System.out.println(array[i]);
		//ESO ES IGUAL A ESTO DE ABAJO, SOLO QU EL "3" ES UNA CIFRA QUE PUEDE GENERAR PROBLEMAS
		/*for(int i=0; i<3; i++) {
			System.out.println(array[i]);*/
		}
		
		System.out.println("Mostrando el valor del índice 3: " + array[3]);
		
		for (int aux : array) {
			System.out.println(aux); //esto recorre todo el array (el aux)
		}
	}

}
