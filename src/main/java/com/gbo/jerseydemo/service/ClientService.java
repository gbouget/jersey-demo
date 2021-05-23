package com.gbo.jerseydemo.service;

import java.util.List;

import com.gbo.jerseydemo.model.Client;

public interface ClientService {
	public Client recuperer(final Integer idClient);
	public Integer ajouter(final Client client);
	public void modifier(final Client client);
	public void supprimer(final Integer idClient);
	public List<Client> recupererTousClients();
}
