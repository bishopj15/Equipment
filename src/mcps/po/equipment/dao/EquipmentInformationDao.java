package mcps.po.equipment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mcps.po.equipment.model.EquipmentInformation;


public class EquipmentInformationDao {
	private static EquipmentInformationDao instance = null;
	DatabaseAccess databaseAccess;
	
	private EquipmentInformationDao(){
		databaseAccess = DatabaseAccess.getInstance();
	}
	
	/**
	 * We do not allow cloning our singleton
	 */
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
	
	/**
	 * Create a new instance of the dao, or get the existing instance
	 * @return
	 */
	public static synchronized EquipmentInformationDao getInstance() {
		if (instance == null) {
			instance = new EquipmentInformationDao();
		}
		return instance;
	}
	
	
	protected List<EquipmentInformation> retrieveAllEquipmentInformation(Connection conn) throws SQLException{
		String query = Queries.RETRIEVE_ALL_EQUIPMENT_INFORMATION;
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List<EquipmentInformation> equipmentInformations = new ArrayList<EquipmentInformation>();
			
			while (rs.next()) {
				equipmentInformations.add(new EquipmentInformation(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getInt(10) ));
			}
			return equipmentInformations;
		} catch (SQLException e){
			throw e;
		}
	}
	
	public List<EquipmentInformation> retrieveAllEquipmentInformation() throws SQLException{
		try (Connection conn = databaseAccess.getConnection()){
			return retrieveAllEquipmentInformation(conn);
		} catch (SQLException e){
			throw e;
		}
	}
	
	public EquipmentInformation findEquipmentInformationByPkey(int pkey) throws SQLException{
		try (Connection conn = databaseAccess.getConnection()){
			return findEquipmentInformationByPkey(pkey, conn);
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected EquipmentInformation findEquipmentInformationByPkey(int pkey, Connection conn) throws SQLException{
		String query = Queries.FIND_EQUIPMENT_INFORMATION_BY_PKEY;
		
		try {
			EquipmentInformation equipmentInformation = new EquipmentInformation();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setInt(1,  pkey);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				equipmentInformation = new EquipmentInformation(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9), rs.getInt(10));
			}
			
			return equipmentInformation;
		} catch (SQLException e){
			throw e;
		}
	}
	
	public int addEuipmentInformation(EquipmentInformation equipmentInformation) throws SQLException{
		try (Connection conn = databaseAccess.getConnection()){
			try{
				conn.setAutoCommit(false);
				boolean added = addEuipmentInformation(equipmentInformation, conn);
				if (added){
					int pkey = databaseAccess.getPkeyOfLastInsert(conn);
					conn.commit();
					return pkey;
				} else
					throw new SQLException("Could not fetch PKEY for new record");
			} catch (SQLException e){
				throw e;
			} finally {
				conn.setAutoCommit(true);
			}	
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected boolean addEuipmentInformation(EquipmentInformation equipmentInformation, Connection conn) throws SQLException{
		String query = Queries.ADD_EQUIPMENT_INFORMATION;
		
		try{
			PreparedStatement ps = conn.prepareStatement(query); 
			ps.setString(1, equipmentInformation.getBarcode()); 
			ps.setInt(2, equipmentInformation.getEquipmentTypeFk()); 
			ps.setString(3, equipmentInformation.getRoom());
			ps.setString(4, equipmentInformation.getSerialNumber()); 
			ps.setInt(5, equipmentInformation.getManufacturer());
			ps.setString(6, equipmentInformation.getModelNumber());
			ps.setDate(7, equipmentInformation.getBeginDate());
			ps.setInt(8, equipmentInformation.getCost());
			ps.setInt(9, equipmentInformation.getAge());
			
			return (1 == ps.executeUpdate());
		} catch (SQLException e){
			throw e;
		}
	}
	
	
	public boolean updateEquipmentInformation(EquipmentInformation equipmentInformation) throws SQLException{
		try (Connection conn = databaseAccess.getConnection()){
			try{
				conn.setAutoCommit(false);
				boolean updated = updateEquipmentInformation(equipmentInformation, conn);
				conn.commit();
				return updated;
			} catch (SQLException e){
				throw e;
			} finally {
				conn.setAutoCommit(true);
			}	
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected boolean updateEquipmentInformation(EquipmentInformation equipmentInformation, Connection conn) throws SQLException{
		String query = Queries.UPDATE_EQUIPMENT_INFORMATION;
		try{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, equipmentInformation.getBarcode()); 
			ps.setInt(2, equipmentInformation.getEquipmentTypeFk()); 
			ps.setString(3, equipmentInformation.getRoom());
			ps.setString(4, equipmentInformation.getSerialNumber()); 
			ps.setInt(5, equipmentInformation.getManufacturer());
			ps.setString(6, equipmentInformation.getModelNumber());
			ps.setDate(7, equipmentInformation.getBeginDate());
			ps.setInt(8, equipmentInformation.getCost());
			ps.setInt(9, equipmentInformation.getAge());
			ps.setInt(10, equipmentInformation.getPkey());
			
			return (1 == ps.executeUpdate());
		} catch (SQLException e) {
			throw e;
		}
	}
	
	public boolean deleteEquipmentInformation(int pkey) throws SQLException{
		try(Connection conn = databaseAccess.getConnection()){
			try{
				conn.setAutoCommit(false);
				boolean deleted = deleteEquipmentInformation(pkey, conn);
				conn.commit();
				return deleted;
			}catch(SQLException e){
				throw e;
			} finally{
				conn.setAutoCommit(true);
			}
		} catch(SQLException e){
			throw e;
		}
	}
	
	protected boolean deleteEquipmentInformation(int pkey, Connection conn) throws SQLException{
		String query = Queries.DELETE_EQUIPMENT_INFORMATION;
		
		try{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,  pkey);
			return (1 == ps.executeUpdate());
		} catch(SQLException e) {
			throw e;
		}
	}
	
}
