package com.epf.rentmanager.model;

import java.time.LocalDate;

public class Client {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	private LocalDate naissance;
	
	public Client(String nom, String prenom, String email, LocalDate naissance) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.naissance = naissance;
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", naissance="
				+ naissance + "]";
	}

	public Client(int id, String nom, String prenom, String email, LocalDate naissance) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.naissance = naissance;
	}

	public int getId() {
		return id;
	}

	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getNaissance() {
		return naissance;
	}

	public void setNaissance(LocalDate naissance) {
		this.naissance = naissance;
	}

	
	
	
	
	
	
}
