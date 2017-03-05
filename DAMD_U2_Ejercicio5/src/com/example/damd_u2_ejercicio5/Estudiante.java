package com.example.damd_u2_ejercicio5;

public class Estudiante {
	
	private String nombre;
	private int edad;
	private int carrera;

	public Estudiante(String nombre, int edad, int carrera) {
		this.nombre = nombre;
		this.edad = edad;
		this.carrera = carrera;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getCarrera() {
		return carrera;
	}

	public void setCarrera(int carrera) {
		this.carrera = carrera;
	}
	
	
	
	

}
