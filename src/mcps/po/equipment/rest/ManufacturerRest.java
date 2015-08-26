package mcps.po.equipment.rest;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import mcps.po.equipment.dao.ManufacturerDao;
import mcps.po.equipment.model.EquipmentType;
import mcps.po.equipment.model.Manufacturer;

@Path("/v1.0/equipmenttype")
public class ManufacturerRest {
	ManufacturerDao manufacturerDao = ManufacturerDao.getInstace();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	public Response listManufacturers(){
		Response response;
		
		try{
			List<Manufacturer> manufacturers = manufacturerDao.retrieveAllManufacturers();
			ObjectMapper mapper = new ObjectMapper();
			String jsonManufacturer = mapper.writeValueAsString(manufacturers);
			GenericEntity<String> entity = new GenericEntity<String>(jsonManufacturer){};
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
	public Response findManufacturerTypeByPkey(@PathParam("pkey") final int pkey){
		Response response;
		
		try {
			Manufacturer manufacturer = manufacturerDao.findManufacturerByPkey(pkey);
			if(pkey == manufacturer.getPkey()){
				ObjectMapper mapper = new ObjectMapper();
				String jsonManufacturer = mapper.writeValueAsString(manufacturer);
				GenericEntity<String> entity = new GenericEntity<String>(jsonManufacturer){};
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
	public Response addEquipmentType(String jsonManufacturer){
		Response response;
		
		ObjectMapper mapper = new ObjectMapper();
		try {
			Manufacturer manufacturer = mapper.readValue(jsonManufacturer, Manufacturer.class);
			int pkey = manufacturerDao.addManufacturer(manufacturer);
			manufacturer.setPkey(pkey);
			jsonManufacturer = mapper.writeValueAsString(manufacturer);
			GenericEntity<String> entity = new GenericEntity<String>(jsonManufacturer){};
			response = Response.ok(entity).build();
		} catch (Exception e) {
			e.printStackTrace();
			response = Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} 
		
		
		return response;
	}
	
}
