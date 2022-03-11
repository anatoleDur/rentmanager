package com.epf.rentmanager.model;

import java.time.LocalDate;

public class ReservationInfos{
	private int id;
	private Vehicle vehicle;
	private Client client;
	private LocalDate debut;
	private LocalDate fin;
	
	public ReservationInfos(int id, Vehicle vehicle, Client client, LocalDate debut, LocalDate fin) {
		super();
		this.id = id;
		this.vehicle = vehicle;
		this.client = client;
		this.debut = debut;
		this.fin = fin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
