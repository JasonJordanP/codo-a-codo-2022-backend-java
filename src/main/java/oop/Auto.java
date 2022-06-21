package oop;

public class Auto {

		//Atributos de la clase (TIPO PRIMERO Y NOMBRE DESPUÉS, SIEMPRE PRIVATE)
	private String color;
	private int anio;
	private long serie;
	private String marca;
	private String modelo;
	private float velocidad;
	private float velocidadMaxima;
	private boolean encendido;
	
	private Motor motor;
	    //Cuando se crea una clase hay que crear el método CONSTRUCTOR (Se le da valores a sus variables)
	private Estereo estereo;
	
	public Auto(float velocidadMaxima, String marca, Motor motor){
		
		this.setVelocidadMaxima(velocidadMaxima);
		this.setVelocidad(0); //ES IGUAL A ESTO: velocidad = 0;
		this.setAnio(2022); //ES IGAL A ESTO: anio = 2022;
		this.setEncendido(false); //ES IGUAL A ESTO: encendido = false;
		this.setMarca(marca);
		this.setMotor(motor);
		
		//velocidadMaxima = 3;
		//marca = "Fiat";
		//modelo = "Uno";
	}
	
	
		//Métodos de la clase (LAS ACCIONES DEL OBJETO)
	public void setMotor(Motor motor) {
		if(motor == null) {
			Motor motorInterno = new Motor ("default", 100f);
			this.motor = motorInterno;
		} else {
		this.motor = motor; 
		}
	}
	
	public Motor getMotor() {
		return this.motor;
	}
	
	public void setEstereo(Estereo nuevoEstereo) {
		if(nuevoEstereo != null ) {
			this.estereo = nuevoEstereo;
		}
	}
	
	public void encender() {	
		
		if (!this.isEncendido()) {
			this.setEncendido(true);
			System.out.println("Encendiendo el auto");
		} else { 
			System.out.println("El auto no se puede encender dos veces");
		}
	}
	
	public void apagar() {
		if(this.isEncendido()) {
			
			while (this.getVelocidad() > 0) {
				frenar();
				System.out.println("Frenando el automóvil...");
			}
			
			encendido = false;
			System.out.println("Se apagó correctamente");
		} else { 
			System.out.println("No se puede apagar dos veces");
		}
	}
	
	public void acelerar() {
		if(this.isEncendido()) {
			if(this.getVelocidad() < this.getVelocidadMaxima()) {
				
			this.setVelocidad(this.getVelocidad() + 1); //(es igual a velocidad + 1)
			
			}else {
				System.out.println("Error: Debe encender el auto");
			}
		}
	}
	
	public void frenar() {
		if(this.isEncendido()) {
			if (this.getVelocidad() > 0) {
				
				this.setVelocidad(this.getVelocidad() - 1);
			}
		} else {
			System.out.println("Error: Auto apagado");
		}
	}
	
	public void verVelocidad() {
		System.out.println(velocidad);
	}

	public String getMarca() {
		return marca == null ? "" : marca;
	}
	
	
	public void setMarca(String marca) {
		if(marca != null) {
		this.marca = marca;  //el "this" aclara que se refiere al atributo
		} else { 
			this.marca = "";//porque ambos se llaman igual "marca", así no nos confundimos
		}
	}
	
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getAnio() {
		return anio;
	}
	private void setAnio(int anio) {
		this.anio = anio;
	}
	public long getSerie() {
		return serie;
	}
	private void setSerie (long serie) {
		this.serie = serie;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public float getVelocidad() {
		return velocidad;
	}
	private void setVelocidad(float velocidad) {
		if(velocidad < 0) {
			this.velocidad = 0;
		} else {
		this.velocidad = velocidad;
	   }
	}
	public float getVelocidadMaxima() {
		return velocidadMaxima;
	}
	private void setVelocidadMaxima(float velocidadMaxima) {
		if(velocidadMaxima < 0 || velocidadMaxima > 220) {
			if(velocidadMaxima < 0)
				this.velocidadMaxima = 0;
			if(velocidadMaxima > 220)
				this.velocidadMaxima = 220;
		}else {
			this.velocidadMaxima = velocidadMaxima;
		}
	}
	
	public boolean isEncendido() {
		return encendido;
	}
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
}
	
