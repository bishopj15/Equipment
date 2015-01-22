package mcps.po.equipment.rest;

import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;

public class AbstractRest {
	public static final String REST_PATH_ELEMENT = "/v1.0";
	
	@Context
	private ServletContext context;
}
