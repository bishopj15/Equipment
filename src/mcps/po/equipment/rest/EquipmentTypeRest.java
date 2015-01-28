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

import mcps.po.equipment.dao.EquipmentTypeDao;
import mcps.po.equipment.model.EquipmentType;


@Path("/v1.0/equipmenttype")
public class EquipmentTypeRest {
	EquipmentTypeDao equipmentTypeDao = EquipmentTypeDao.getInstance();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listEquipmentTypes(){
		Response response;
		
		try {
			List<EquipmentType> equipmentTypes = equipmentTypeDao.retrieveAllEquipmentTypes();
			ObjectMapper mapper = new ObjectMapper();
			String jsonEquipmentTypes = mapper.writeValueAsString(equipmentTypes);
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentTypes){};
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
	public Response findEquipmentTypeByPkey(@PathParam("pkey") final int pkey){
		Response response;
		
		try {
			EquipmentType equipmentType = equipmentTypeDao.findEquipmentTypeByPkey(pkey);
			if(pkey == equipmentType.getPkey()){
				ObjectMapper mapper = new ObjectMapper();
				String jsonEquipmentType = mapper.writeValueAsString(equipmentType);
				GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentType){};
				response = Response.ok(entity).build();
			} else {
				response = Response.status(Response.Status.NO_CONTENT).build();
			}
		} catch (SQLException | JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return response;
	}
	
	
	@POST
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	public Response addEquipmentType(String jsonEquipmentType){
		Response response;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			EquipmentType equipmentType = mapper.readValue(jsonEquipmentType, EquipmentType.class);
			int pkey = equipmentTypeDao.addEquipmentType(equipmentType);
			equipmentType.setPkey(pkey);
			jsonEquipmentType = mapper.writeValueAsString(equipmentType);
			GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentType){};
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
	public Response updateEquipmentType(String jsonEquipmentType){
		Response response;
		ObjectMapper mapper = new ObjectMapper();
		try {
			EquipmentType equipmentType = mapper.readValue(jsonEquipmentType, EquipmentType.class);
			if(equipmentTypeDao.updateEquipmentType(equipmentType)){
				jsonEquipmentType = mapper.writeValueAsString(equipmentType);
				GenericEntity<String> entity = new GenericEntity<String>(jsonEquipmentType){};
				response = Response.ok(entity).build();
			} else {
				response = Response.status(Response.Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		
		return response;
	}
	
	@Path("/pkey/{pkey}")
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	public Response deleteEquipmentType(@PathParam("pkey") final int pkey){
		Response response;
		
		try{
			if(equipmentTypeDao.deleteEquipmentType(pkey)){
				response = Response.ok().build();
			} else {
				response = Response.status(Response.Status.NO_CONTENT).build();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
		
		return response;
	}
	
	
}
