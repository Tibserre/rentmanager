package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Reservation {
	private long id; 
	private LocalDate start_resa;
	private LocalDate end_resa;
	private long client_id; 
	private long vehicle_id;
	public Reservation(long id, LocalDate start_resa, LocalDate end_resa, long client_id, long vehicle_id) {
		super();
		this.id = id;
		this.start_resa = start_resa;
		this.end_resa = end_resa;
		this.client_id = client_id;
		this.vehicle_id = vehicle_id;
	}
	
	public Reservation( LocalDate start_resa, LocalDate end_resa, long client_id, long vehicle_id) {
		super();
		this.start_resa = start_resa;
		this.end_resa = end_resa;
		this.client_id = client_id;
		this.vehicle_id = vehicle_id;
	}
	public long getId() {
		return id;
	}
	public LocalDate getStart_resa() {
		return start_resa;
	}
	public LocalDate getEnd_resa() {
		return end_resa;
	}
	public long getClient_id() {
		return client_id;
	}
	public long getVehicle_id() {
		return vehicle_id;
	}
	public void setStart_resa(LocalDate start_resa) {
		this.start_resa = start_resa;
	}
	public void setEnd_resa(LocalDate end_resa) {
		this.end_resa = end_resa;
	}
	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}
	public void setVehicle_id(int vehicle_id) {
		this.vehicle_id = vehicle_id;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", start_resa=" + start_resa + ", end_resa=" + end_resa + ", client_id="
				+ client_id + ", vehicle_id=" + vehicle_id + "]";
	}
	
	
}
