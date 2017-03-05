package com.example.listatareas;

public class Tareas {
      
	private String titulo;
	private String nota;
	private String fecha;

	
	
	public Tareas(String titulo, String nota, String fecha) {
		this.titulo = titulo;
		this.nota = nota;
		this.fecha = fecha;
	}


	public String getTitulo() {
		return titulo;
	}


	public String getNota() {
		return nota;
	}


	public String getFecha() {
		return fecha;
	}


	
}
