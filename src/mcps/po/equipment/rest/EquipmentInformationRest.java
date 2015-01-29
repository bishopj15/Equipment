package mcps.po.equipment.rest;

import java.sql.SQLException;
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

import mcps.po.equipment.dao.EquipmentInformationDao;
import mcps.po.equipment.model.EquipmentInformation;

@Path("/v1.0/equipmentinformation")
public class EquipmentInformationRest {
	EquipmentInformationDao equipmentInformationDao = EquipmentInformationDao.getInstance();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listEquipmentTypes(){
		Response response;
		
		try {
			List<EquipmentInformation> equipmentInformations = equipmentInformationDao.retrieveAllEquipmentInformation();
			ObjectMapper mapper = new ObjectMapper();
			String jsonEquipmentInformations = mapper.writeValueAsString(equipmentInformations);
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentInformations){};
			response = Response.ok(entity).build();
		} catch (SQLException e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return response;
	}
	
	
	@Path("/pkey/{pkey}")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response getEquipmentInformationByPkey(@PathParam("pkey") final int pkey){
		Response response;
		
		try {
			EquipmentInformation equipmentInformation = equipmentInformationDao.findEquipmentInformationByPkey(pkey);
			if(pkey == equipmentInformation.getPkey()){
				ObjectMapper mapper = new ObjectMapper();
				String jsonEquipmentInformations = mapper.writeValueAsString(equipmentInformation);
				GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentInformations){};
				response = Response.ok(entity).build();
			} else {
				response = Response.status(Response.Status.NO_CONTENT).build();
			}
		} catch (SQLException | JsonProcessingException e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return response;
	}
	
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addEquipmentInformation(String jsonEquipmentInformations){
		Response response;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			EquipmentInformation equipmentInformation = mapper.readValue(jsonEquipmentInformations, EquipmentInformation.class);
			int pkey = equipmentInformationDao.addEuipmentInformation(equipmentInformation);
			equipmentInformation.setPkey(pkey);
			jsonEquipmentInformations = mapper.writeValueAsString(equipmentInformation);
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentInformations){};
			response = Response.ok(entity).build();
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} 
		
		
		return response;
	}
	
	
	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response updateEquipmentInformation(String jsonEquipmentInformations){
		Response response;
		ObjectMapper mapper = new ObjectMapper();
		try {
			EquipmentInformation equipmentInformation = mapper.readValue(jsonEquipmentInformations, EquipmentInformation.class);
			if(equipmentInformationDao.updateEquipmentInformation(equipmentInformation)){
				jsonEquipmentInformations = mapper.writeValueAsString(equipmentInformation);
				GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentInformations){};
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
			if(equipmentInformationDao.deleteEquipmentInformation(pkey)){
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
