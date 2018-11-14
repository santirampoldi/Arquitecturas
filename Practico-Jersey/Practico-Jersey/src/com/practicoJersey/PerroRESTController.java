package com.practicoJersey;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/perros")
public class PerroRESTController {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Perro> getAllPerros() {
		return PerroDAO.getInstance().findAll();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Perro getPerroById(@PathParam("id") String msg) {
		int id = Integer.valueOf(msg);
		Perro perro = PerroDAO.getInstance().findById(id);
		if(perro!=null)
			return perro;
		else
			throw new RecursoNoExiste(id);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createPerro(Perro perro) {
		Perro result= PerroDAO.getInstance().persist(perro);
		if(result==null) {
			throw new RecursoDuplicado(perro.getId());
		}else {
			return Response.status(201).entity(perro).build();
		}
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deletePerro(@PathParam("id") int id) {
		throw new UnsupportedOperationException();
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response updatePerro(@PathParam("id") int id,Perro perro) {
		throw new UnsupportedOperationException();
	}
	
	@GET
	@Path("/findPerrosByEdad")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Perro> findPerrosByEdad(@QueryParam("from") int from,
			@QueryParam("to") int to) {
		throw new UnsupportedOperationException();
	}

	public class RecursoDuplicado extends WebApplicationException {
	     public RecursoDuplicado(int id) {
	         super(Response.status(Response.Status.CONFLICT)
	             .entity("El recurso con ID "+id+" ya existe").type(MediaType.TEXT_PLAIN).build());
	     }
	}
	
	public class RecursoNoExiste extends WebApplicationException {
	     public RecursoNoExiste(int id) {
	         super(Response.status(Response.Status.NOT_FOUND)
	             .entity("El recurso con id "+id+" no fue encontrado").type(MediaType.TEXT_PLAIN).build());
	     }
	}
	
	

}