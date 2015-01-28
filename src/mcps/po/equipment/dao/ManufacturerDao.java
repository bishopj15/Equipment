package mcps.po.equipment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mcps.po.equipment.model.Manufacturer;

public class ManufacturerDao {
	public static ManufacturerDao instance = null;
	DatabaseAccess databaseAccess;
	
	private ManufacturerDao(){
		databaseAccess = DatabaseAccess.getInstance();
	}
	
	/**
	 * We do not allow cloning our singleton
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	public static synchronized ManufacturerDao getInstace(){
		if(instance == null){
			instance = new ManufacturerDao();
		}
		return instance;
	}
	
	public List<Manufacturer> retrieveAllManufacturers() throws SQLException {
		try{
			Connection conn = databaseAccess.getConnection();
			return retrieveAllManufacturers(conn);
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected List<Manufacturer> retrieveAllManufacturers(Connection conn) throws SQLException {
		String query = Queries.RETRIEVE_ALL_MANUFACTURERS;
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
			
			while(rs.next()){
				manufacturers.add(new Manufacturer(rs.getInt(1), rs.getString(2)));
			}
			return manufacturers;
		} catch (SQLException e){
			throw e;
		}
	}
	
	public Manufacturer findManufacturerByPkey(int pkey) throws SQLException{
		try {
			Connection conn = databaseAccess.getConnection();
			return findManufacturerByPkey(pkey, conn);
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected Manufacturer findManufacturerByPkey(int pkey, Connection conn) throws SQLException{
		String query = Queries.FIND_MANUFACTURER_BY_PKEY;
		
		try{
			Manufacturer manufacturer = new Manufacturer();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,  pkey);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				manufacturer = new Manufacturer(rs.getInt(1), rs.getString(2));
			}
			
			return manufacturer;
		} catch (SQLException e){
			throw e;
		}
	}
	
	public int addManufacturer(Manufacturer manufacturer) throws SQLException{
		try{
			Connection conn = databaseAccess.getConnection();
			try{
				conn.setAutoCommit(false);
				boolean added = addManufacturer(manufacturer, conn);
				
				if (added){
					int pkey = databaseAccess.getPkeyOfLastInsert(conn);
					conn.commit();
					return pkey;
				}
				else throw new SQLException("Could not fetch PKEY for new record");
			} catch (SQLException e){
				throw e;
			} finally {
				conn.setAutoCommit(true);
			}
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected boolean addManufacturer(Manufacturer manufacturer, Connection conn) throws SQLException{
		String query = Queries.ADD_MANUFACTURER;
		
		try{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, manufacturer.getName());
			return (1 == ps.executeUpdate());
		} catch (SQLException e){
			throw e;
		}
	}
}
