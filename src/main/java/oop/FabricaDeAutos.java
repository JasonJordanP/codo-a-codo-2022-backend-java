package oop;

public class FabricaDeAutos {

	public static void main(String[] args) {
		
		//CREO EL PRIMER OBJETO DE LA CLASE AUTO
		Auto fiatUno = new Auto(220f,"Audi", newMotor("motor",300f));
		
		//Quiero ver la velocidad del objeto (nombreobjeto.atributoDeseado)
		
		//System.out.println("Velocidad actual =" + fiatUno.velocidad);
		
		//fiatUno.encender(); //(Si selecciono "encender" y apreto f3 me lleva a esa parte del c�digo)
		
		fiatUno.encender ();
		
		fiatUno.acelerar();
		//System.out.println("Velocidad actual =" + fiatUno.velocidad);
		fiatUno.acelerar();
		fiatUno.verVelocidad(); //Es igual que la l�nea 19 pero te muestra s�lo la velocidad
		fiatUno.acelerar();
		//System.out.println("Velocidad actual =" + fiatUno.velocidad);
		//fiatUno.acelerar();
		
		System.out.println("Frenando...");
		fiatUno.frenar();
		fiatUno.verVelocidad();
		
		fiatUno.apagar();
		fiatUno.verVelocidad();

		
		System.out.println("FIN");
	}
	

}
