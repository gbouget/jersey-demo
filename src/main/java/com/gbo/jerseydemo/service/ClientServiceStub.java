package com.gbo.jerseydemo.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

import com.gbo.jerseydemo.model.Client;

/**
 * Service bouchon
 * @author gaeta
 *
 */
@Service
public class ClientServiceStub implements ClientService {
	
	final private List<Client> clients = new ArrayList<Client>();
	
	@PostConstruct
	public void initialiserClients() {		
		final Client client01 = Client.fabriquer();
		client01.setPrenom("prenom_01");
		client01.setNom("nom_01");
		
		final Client client02 = Client.fabriquer();
		client02.setPrenom("prenom_02");
		client02.setNom("nom_02");
		
		final Client client03 = Client.fabriquer();
		client03.setPrenom("prenom_03");
		client03.setNom("nom_03");
		
		clients.add(client01);
		clients.add(client02);
		clients.add(client03);
	}

	@Override
	public Client recuperer(final Integer idClient) {
		for (final Client client : this.clients) {
			if (idClient.equals(client.getId())) {
				return client;
			}
		}
		return new Client();
	}

	@Override
	public Integer ajouter(Client client) {
		final Client nouveauClient = Client.fabriquer();
		nouveauClient.setNom(client.getNom());
		nouveauClient.setPrenom(client.getPrenom());
		this.clients.add(nouveauClient);
		return nouveauClient.getId();
	}

	@Override
	public void modifier(Client clientModifie) {
		if (clientModifie.getId() != null) {
			for (final Client client : this.clients) {
				// La référence de l'objet est conservée
				if (clientModifie.getId() == client.getId()) {
					client.setNom(clientModifie.getNom());
					client.setPrenom(clientModifie.getPrenom());
				}
			}
		}
	}

	@Override
	public void supprimer(Integer idClient) {
		if (idClient != null) {
			for (Iterator<Client> it = clients.iterator(); it.hasNext(); ) {
				Client client = it.next();
			    if (idClient == client.getId()) {
			        it.remove();
			    }
			}
		}
	}

	@Override
	public List<Client> recupererTousClients() {
		return clients;
	}

}
