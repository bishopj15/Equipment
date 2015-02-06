package mcps.po.equipment.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mcps.po.equipment.model.Equipment;
import mcps.po.equipment.service.BuildEquipment;

@Path("/v1.0/equipment")
public class EquipmentRest {
	BuildEquipment buildEquipment = BuildEquipment.getInstance();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listEquipment(){
		Response response;
		List<Equipment> equipments = buildEquipment.retrieveAllEquipments();
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonEquipments = mapper.writeValueAsString(equipments);
			
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipments){};
			response = Response.ok(entity).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@Path("/offset/{offset}/limit/{limit}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEquipmentByOffsetAndLimit(
			@PathParam("offset") final int offset, 
			@PathParam("limit") final int limit){
		Response response;
		List<Equipment> equipments = buildEquipment.retrieveEquipmentsWithOffsetAndLimit(offset, limit);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonEquipments = mapper.writeValueAsString(equipments);
			
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipments){};
			response = Response.ok(entity).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@Path("/pkey/{pkey}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEquipmentByPkey(@PathParam("pkey") final int pkey){
		Response response;
		Equipment equipment = buildEquipment.retrieveEquipmentByPkey(pkey);
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			String jsonEquipment = mapper.writeValueAsString(equipment);
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipment){};
			response = Response.ok(entity).build();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addEquipmen(String jsonEquipment){
		Response response;
		ObjectMapper mapper = new ObjectMapper();
		try {
			Equipment equipment = mapper.readValue(jsonEquipment, Equipment.class);
			int pkey = buildEquipment.addEquipment(equipment);
			equipment.setPkey(pkey);
			jsonEquipment = mapper.writeValueAsString(equipment);
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipment){};
			response = Response.ok(entity).build();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateEquipment(String jsonEquipment){
		Response response;
		ObjectMapper mapper = new ObjectMapper();
		
		try {
			Equipment equipment = mapper.readValue(jsonEquipment, Equipment.class);
			
			if(buildEquipment.updateEquipment(equipment)){
				jsonEquipment = mapper.writeValueAsString(equipment);
				GenericEntity<String> entity = new GenericEntity<String>(jsonEquipment){};
				response = Response.ok(entity).build();
			} else {
				response = Response.status(Response.Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		return response;
	}
	
	@Path("/pkey/{pkey}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteEquipmentInformation(@PathParam("pkey") final int pkey){
		Response response;
		
		try{
			if(buildEquipment.deleteEquipment(pkey)){
				response = Response.ok().build();
			} else {
				response = Response.status(Response.Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return response;
	}
	
	
	
}
