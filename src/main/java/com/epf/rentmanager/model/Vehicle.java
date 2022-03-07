package com.epf.rentmanager.model;

public class Vehicle {
	private long id;
	private String constructeur; 
	private int nb_places;
	
	public Vehicle(long id, String constructeur, int nb_places) {
		super();
		this.id= id;
		this.constructeur= constructeur; 
		this.nb_places= nb_places;
	}
		public Vehicle(String constructeur, int nb_places) {
			super();
			this.constructeur= constructeur; 
			this.nb_places= nb_places;
	}
		
		public Vehicle(String constructeur) {
			super();
			this.constructeur= constructeur; 
		
	}
	
	public long getId() {
		return id;
	}
	public String getConstructeur() {
		return constructeur;
	}
	public int getNb_places() {
		return nb_places;
	}
	public void setConstructeur(String constructeur) {
		this.constructeur = constructeur;
	}

	public void setNb_places(int nb_places) {
		this.nb_places = nb_places;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", constructeur=" + constructeur + ", nb_places=" + nb_places + "]";
	} 

	
}