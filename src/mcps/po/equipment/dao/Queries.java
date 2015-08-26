package mcps.po.equipment.dao;

public class Queries {
	
	public static final String GET_LAST_INSERT_ID = "SELECT LAST_INSERT_ID();";
	
	//Equipment Information 
	public static final String RETRIEVE_ALL_EQUIPMENT_INFORMATION = 
			"SELECT pkey, barcode, equipment_type_fk, room, serial_number, "
			+ "manufacturer_fk, model_number, begin_service_date, cost, age "
			+ "FROM equipment_information "
			+ "ORDER BY pkey ASC";
	
	public static final String RETRIEVE_EQUIPMENT_INFORMATION_WITH_OFFSET_AND_LIMIT = 
			"SELECT pkey, barcode, equipment_type_fk, room, serial_number, "
			+ "manufacturer_fk, model_number, begin_service_date, cost, age "
			+ "FROM equipment_information "
			+ "ORDER BY pkey ASC"
			+ "LIMIT ?,?";
	
	public static final String FIND_EQUIPMENT_INFORMATION_BY_PKEY = 
			"SELECT pkey, barcode, equipment_type_fk, room, serial_number, "
			+ "manufacturer_fk, model_number, begin_service_date, cost, age "
			+ "FROM equipment_information "
			+ "WHERE pkey=?";
	
	public static final String ADD_EQUIPMENT_INFORMATION = 
			"INSERT INTO equipment_information (pkey, barcode, equipment_type_fk, room, serial_number, "
			+ "manufacturer_fk, model_number, begin_service_date, cost, age) "
			+ "VALUES (NULL,?,?,?,?,?,?,?,?,?);";
	
	public static final String UPDATE_EQUIPMENT_INFORMATION =
			"UPDATE equipment_information "
			+ "SET barcode=?, equipment_type_fk=?, room=?, serial_number=?, "
			+ "manufacturer_fk=?, model_number=?, begin_service_date=?, cost=?, age=? "
			+ "WHERE pkey=?";
	
	public static final String DELETE_EQUIPMENT_INFORMATION =
			"DELETE FROM equipment_information "
			+ "WHERE pkey=?";
	
	//Manufacturer
	public static final String RETRIEVE_ALL_MANUFACTURERS =
			"SELECT pkey, name FROM manufacturer "
			+ "ORDER BY pkey ASC";
	
	public static final String FIND_MANUFACTURER_BY_PKEY =
			"SELECT pkey, name FROM manufacturer "
			+ "WHERE pkey=?";
	
	public static final String ADD_MANUFACTURER =
			"INSERT INTO (pkey, name) VALUES (null, ?);";
	
	
	//Equipment Type
	
	public static final String RETRIEVE_ALL_EQUIPMENT_TYPE =
			"SELECT pkey, equipment_id, description, rank, replacement_cost "
			+ "FROM equipment_type "
			+ "ORDER BY pkey ASC";
	
	public static final String FIND_EQUIPMENT_TYPE_BY_PKEY =
			"SELECT pkey, equipment_id, description, rank, replacement_cost "
			+ "FROM equipment_type "
			+ "WHERE pkey=?";
	
	public static final String ADD_EQUIPMENT_TYPE =
			"INSERT INTO equipment_type (pkey, equipment_id, description, rank, replacement_cost) "
			+ "VALUES (null,?,?,?,?);";
	
	public static final String UPDATE_EQUIPMENT_TYPE =
			"UPDATE equipment_type "
			+ "SET equipment_id=?, description=?, rank=?, replacement_cost=? "
			+ "WHERE pkey=?";
	
	public static final String DELETE_EQUIPMENT_TYPE =
			"DELETE FROM equipment_type "
			+ "WHERE pkey=?";
	
	
	
	
	
	
	
	
	
	
}
