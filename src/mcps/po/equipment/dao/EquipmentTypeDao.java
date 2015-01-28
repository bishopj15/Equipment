package mcps.po.equipment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mcps.po.equipment.model.EquipmentType;

public class EquipmentTypeDao {
	private static EquipmentTypeDao instance = null;
	DatabaseAccess databaseAccess;
	
	private EquipmentTypeDao(){
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
	public static synchronized EquipmentTypeDao getInstance() {
		if (instance == null) {
			instance = new EquipmentTypeDao();
		}
		return instance;
	}
	
	public List<EquipmentType> retrieveAllEquipmentTypes() throws SQLException{
		try (Connection conn = databaseAccess.getConnection()){
			return retrieveAllEquipmentTypes(conn);
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected List<EquipmentType> retrieveAllEquipmentTypes(Connection conn) throws SQLException{
		String query = Queries.RETRIEVE_ALL_EQUIPMENT_TYPE;
		
		try{
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			List<EquipmentType> equipmentTypes = new ArrayList<EquipmentType>();
			
			while (rs.next()){
				equipmentTypes.add(new EquipmentType(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5) ));
			}
			return equipmentTypes;
		} catch (SQLException e){
			throw e;
		}
	}
	
	public EquipmentType findEquipmentTypeByPkey(int pkey) throws SQLException{
		try(Connection conn = databaseAccess.getConnection()){
			return findEquipmentTypeByPkey(pkey, conn);
		} catch (SQLException e){
			throw e;
		}
	}
	
	protected EquipmentType findEquipmentTypeByPkey(int pkey, Connection conn) throws SQLException{
		String query = Queries.FIND_EQUIPMENT_TYPE_BY_PKEY;
		
		try{
			EquipmentType equipmentType = new EquipmentType();
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,  pkey);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				equipmentType = new EquipmentType(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
			}
			return equipmentType;
		} catch (SQLException e){
			throw e;
		}
	}
	
	public int addEquipmentType(EquipmentType equipmentType) throws SQLException{
		try(Connection conn = databaseAccess.getConnection()){
			try{
				conn.setAutoCommit(false);
				boolean added = addEquipmentType(equipmentType, conn);
				
				if (added){
					int pkey = databaseAccess.getPkeyOfLastInsert(conn);
					conn.commit();
					return pkey;
				} else throw new SQLException("Could not fetch PKEY for new record");
			}
			catch (SQLException e){
				throw e;
			} finally {
				conn.setAutoCommit(true);
			}
		}
		catch (SQLException e){
			throw e;
		}
	}
	
	protected boolean addEquipmentType(EquipmentType equipmentType, Connection conn) throws SQLException{
		String query = Queries.ADD_EQUIPMENT_TYPE;
		
		try{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, equipmentType.getEquipmentId());
			ps.setString(2, equipmentType.getDescription());
			ps.setInt(3, equipmentType.getRank());
			ps.setInt(4, equipmentType.getReplacementCost());
			
			return (1 == ps.executeUpdate());
		} catch (SQLException e){
			throw e;
		}
	}
	
	public boolean updateEquipmentType(EquipmentType equipmentType) throws SQLException{
		try(Connection conn = databaseAccess.getConnection()){
			try{
				conn.setAutoCommit(false);
				boolean updated = updateEquipmentType(equipmentType, conn);
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
	
	protected boolean updateEquipmentType(EquipmentType equipmentType, Connection conn) throws SQLException{
		String query = Queries.UPDATE_EQUIPMENT_TYPE;
		
		try{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, equipmentType.getEquipmentId());
			ps.setString(2, equipmentType.getDescription());
			ps.setInt(3, equipmentType.getRank());
			ps.setInt(4, equipmentType.getReplacementCost());
			ps.setInt(5, equipmentType.getPkey());
			
			return (1 == ps.executeUpdate());
		} catch (SQLException e){
			throw e;
		}
	}
	
	public boolean deleteEquipmentType(int pkey) throws SQLException{
		try(Connection conn = databaseAccess.getConnection()){
			try{
				conn.setAutoCommit(false);
				boolean deleted = deleteEquipmentType(pkey, conn);
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
	
	protected boolean deleteEquipmentType(int pkey, Connection conn) throws SQLException{
		String query = Queries.DELETE_EQUIPMENT_TYPE;
		
		try{
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1,  pkey);
			return (1 == ps.executeUpdate());
		} catch(SQLException e) {
			throw e;
		}
	}
	
	
}
