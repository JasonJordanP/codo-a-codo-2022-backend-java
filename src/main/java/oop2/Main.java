package oop2;

import oop.Auto;
import oop.Motor;
import oop.Estereo;

public class Main {

	public static void main(String[] args) {
		
		//COMPOSICIÓN
		Motor motorDesdeAfuera = new Motor("A4", 150f);
		
		Auto auto = new Auto(220f, "Audi", motorDesdeAfuera); //ESTOS DATOS SON FIJOS DESDE QUE SE CREA EL OBJETO, SE PONEN EN EL CONTRCUTOR (EN EL OTRO ARCHIVO)
		
		//ASOCIACIÓN
		
		Estereo e = new Estereo();
		auto.setEstereo(e);
		
		//Defino las caracteristicas de mi auto
		//auto.setMarca("Renault");	
		
		//ESTOS VAN COMENTADOS PORQUE NO SON MODIFICABLES, SE DECLARAN UNA VEZ CREADO EL AUTO
		//auto.setVelocidad(-100); 
		//auto.setAnio(2025);
		//auto.setSerie(1258);             
		auto.getVelocidad();
		auto.getColor();
		auto.getMarca();
		auto.getVelocidadMaxima();
	}
}
