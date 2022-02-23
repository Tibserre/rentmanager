package com.epf.rentmanager.model;

public class Vehicle {
	private int id;
	private String constructeur; 
	private String modele; 
	private int nb_places;
	public int getId() {
		return id;
	}
	public String getConstructeur() {
		return constructeur;
	}
	public String getModele() {
		return modele;
	}
	public int getNb_places() {
		return nb_places;
	}
	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	} 

	
}