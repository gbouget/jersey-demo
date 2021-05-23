package com.gbo.jerseydemo;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import com.gbo.jerseydemo.resource.ClientResource;
import com.gbo.jerseydemo.resource.HelloResource;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	 public JerseyConfig() {
		 register(HelloResource.class);
		 register(ClientResource.class);
	 }
}
