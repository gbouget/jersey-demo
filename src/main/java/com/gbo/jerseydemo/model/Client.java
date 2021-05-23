package com.gbo.jerseydemo.model;

public class Client {
	private Integer id;
	private String nom;
	private String prenom;
	
	// L'espace mémoire "static" est partagée par toutes les instances de Client
	private static Integer idSequence = 0;

	public Integer getId() {
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
	
	// Gère l'ID
	public synchronized static Client fabriquer() {
		final Client resultat = new Client();
		
		idSequence++;
		resultat.id = idSequence;
		
		return resultat;
	}
}
