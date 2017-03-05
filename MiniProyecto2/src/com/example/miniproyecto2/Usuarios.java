package com.example.miniproyecto2;

public class Usuarios {
	
	private String nom,correo;
	private int edad,tel,codP;
	
	
	public Usuarios(String nom, String correo, int edad, int tel, int codP) {
		super();
		this.nom = nom;
		this.correo = correo;
		this.edad = edad;
		this.tel = tel;
		this.codP = codP;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getTel() {
		return tel;
	}


	public void setTel(int tel) {
		this.tel = tel;
	}


	public int getCodP() {
		return codP;
	}


	public void setCodP(int codP) {
		this.codP = codP;
	}
	
	

}
