package oop;

public class Motor {

	private String nombre;
	private Float horsePower;
	
	//constructor
	
	public Motor (String nombre, Float horsePower) {
		this.setNombre(nombre);
		this.setHorsePower(horsePower);
		}

	
		//alt+shift+s GENERA TODOS LOS SETTERS Y GETTERS
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Float getHorsePower() {
		return horsePower;
	}

	public void setHorsePower(Float horsePower) {
		this.horsePower = horsePower;
	}
	
}
