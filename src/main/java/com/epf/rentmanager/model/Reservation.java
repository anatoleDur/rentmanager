package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Reservation {

	private int id;
	private int idVehicle;
	private int idClient;
	private LocalDate debut;
	private LocalDate fin;
	
	public Reservation(int idVehicle, int idClient, LocalDate debut, LocalDate fin) {
		super();
		this.idVehicle = idVehicle;
		this.idClient = idClient;
		this.debut = debut;
		this.fin = fin;
	}
	
	public Reservation(int id, int idVehicle, int idClient, LocalDate debut, LocalDate fin) {
		super();
		this.id = id;
		this.idVehicle = idVehicle;
		this.idClient = idClient;
		this.debut = debut;
		this.fin = fin;
	}
	

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", idVehicle=" + idVehicle + ", idClient=" + idClient + ", debut=" + debut
				+ ", fin=" + fin + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdVehicle() {
		return idVehicle;
	}
	public void setIdVehicle(int idVehicle) {
		this.idVehicle = idVehicle;
	}
	public int getIdClient() {
		return idClient;
	}
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
	public LocalDate getDebut() {
		return debut;
	}
	public void setDebut(LocalDate debut) {
		this.debut = debut;
	}
	public LocalDate getFin() {
		return fin;
	}
	public void setFin(LocalDate fin) {
		this.fin = fin;
	}
	
	
	
	
}
