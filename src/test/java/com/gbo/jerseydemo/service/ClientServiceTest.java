package com.gbo.jerseydemo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.gbo.jerseydemo.model.Client;

@SpringBootTest
public class ClientServiceTest {
	
	@Autowired
	private ClientService clientService;
	
	@Test
	public void instancierService() {
		try {
			int nombreClients = clientService.recupererTousClients().size();
			assertEquals(3, nombreClients);
		} catch (final Exception e) {
			fail(e);
		}
	}
	
	@Test
	public void rechercherClient() {
		try {
			final Client client = clientService.recuperer(2);
			assertEquals(2, client.getId());
		} catch (final Exception e) {
			fail(e);
		}
	}
	
	@Test
	public void ajouterClient() {
		try {
			final Client client = Client.fabriquer();
			client.setNom("nomAjouter");
			client.setPrenom("prenomAjouter");
			clientService.ajouter(client);
			
			final Client clientRecuperer = clientService.recuperer(client.getId());
			assertEquals(clientRecuperer.getId(), client.getId());
			assertEquals(clientRecuperer.getPrenom(), client.getPrenom());
			assertEquals(clientRecuperer.getNom(), client.getNom());
		} catch (final Exception e) {
			fail(e);
		}
	}
	
	@Test
	public void supprimerClient() {
		try {
			final Client client = Client.fabriquer();
			client.setNom("nomAjouter");
			client.setPrenom("prenomAjouter");
			clientService.supprimer(client.getId());
			
			final Client clientRecuperer = clientService.recuperer(client.getId());
			assertEquals(clientRecuperer.getId(), null);
			assertEquals(clientRecuperer.getPrenom(), null);
			assertEquals(clientRecuperer.getNom(), null);
		} catch (final Exception e) {
			fail(e);
		}
	}
	
	@Test
	public void modifierClient() {
		try {
			final Client client = Client.fabriquer();
			client.setNom("DUPOND");
			client.setPrenom("JEAN");
			clientService.ajouter(client);
			
			final Client clientAModifier = clientService.recuperer(client.getId());
			clientAModifier.setNom("DURAND");
			
			clientService.modifier(clientAModifier);
			
			final Client clientModifie = clientService.recuperer(client.getId());
			assertEquals(clientModifie.getNom(), client.getNom());
			
		} catch (final Exception e) {
			fail(e);
		}
	}
}
