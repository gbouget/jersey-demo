package com.gbo.jerseydemo.resource;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;

import com.gbo.jerseydemo.model.Client;
import com.gbo.jerseydemo.service.ClientService;

@Path("/client")
public class ClientResource {
	
	@Autowired 
	private ClientService clientService;
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	public Response recuperer(@PathParam("id") Integer id) {
		Client client = clientService.recuperer(id);

	    return Response
	      .status(Response.Status.OK)
	      .entity(client)
	      .build();
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response recuperer() {
		final List<Client> clients = clientService.recupererTousClients();

	    return Response
	      .status(Response.Status.OK)
	      .entity(clients)
	      .build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	// curl windows : Invoke-WebRequest -UseBasicParsing http://localhost:8080/api/client -ContentType "application/json" -Method POST -Body '{"nom":"A","prenom":"B"}'
	public Response ajouter(final Client client) throws URISyntaxException {
		final Integer id = clientService.ajouter(client);
		final URI uri = new URI("/client/" + id);
		return Response.created(uri).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response modifier(final Client client) {
		 clientService.modifier(client);
		 return Response.status(Response.Status.OK).build();
	}

}
