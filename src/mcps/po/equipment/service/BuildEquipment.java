package mcps.po.equipment.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import mcps.po.equipment.dao.EquipmentInformationDao;
import mcps.po.equipment.dao.EquipmentTypeDao;
import mcps.po.equipment.dao.ManufacturerDao;
import mcps.po.equipment.model.Equipment;
import mcps.po.equipment.model.EquipmentInformation;
import mcps.po.equipment.model.EquipmentType;
import mcps.po.equipment.model.Manufacturer;



public class BuildEquipment {
	private static BuildEquipment instance = null;
	private static EquipmentInformationDao equipmentInformationDao = EquipmentInformationDao.getInstance();
	private static EquipmentTypeDao equipmentTypeDao = EquipmentTypeDao.getInstance();
	public static ManufacturerDao manufacturerDao = ManufacturerDao.getInstace();
	/**
	 * we do not allow our singleton to be cloned
	 */
	@Override
	public Object clone() throws CloneNotSupportedException {
	    throw new CloneNotSupportedException();
	}

	/**
	 * provides an existing instance of the service, or creates a new one
	 * @return
	 */
	public static synchronized BuildEquipment getInstance() {
		if (instance == null) {
    		instance = new BuildEquipment();
    	}

        return instance;
	}
	
	public Equipment retrieveEquipmentByPkey(int pkey){
		Equipment equipment = new Equipment();
		
		try{
			EquipmentInformation equipmentInformation= equipmentInformationDao.findEquipmentInformationByPkey(pkey);
			
			equipment.setPkey(equipmentInformation.getPkey());
			equipment.setBarcode(equipmentInformation.getBarcode());
			
			int typeFk = equipmentInformation.getEquipmentTypeFk();
			EquipmentType equipmentType = equipmentTypeDao.findEquipmentTypeByPkey(typeFk);
			equipment.setEquipmentTypeFk(equipmentType);
			
			equipment.setRoom(equipmentInformation.getRoom());
			equipment.setSerialNumber(equipmentInformation.getSerialNumber());
			
			int man = equipmentInformation.getManufacturer();
			Manufacturer manufacturer = manufacturerDao.findManufacturerByPkey(man);
			equipment.setManufacturer(manufacturer);
			
			equipment.setModelNumber(equipmentInformation.getModelNumber());
			equipment.setBeginDate(equipmentInformation.getBeginDate());
			equipment.setCost(equipmentInformation.getCost());
			equipment.setAge(equipmentInformation.getAge());
		} catch(Exception e){
			e.printStackTrace();
		}
		return equipment;
	}
	
	public List<Equipment> retrieveAllEquipments(){
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		try {
			List<EquipmentInformation> equipmentInformations = equipmentInformationDao.retrieveAllEquipmentInformation();
			for(int i =0; i < equipmentInformations.size(); i++){
				equipments.add( retrieveEquipmentByPkey(equipmentInformations.get(i).getPkey()) );
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return equipments;
	}
	
	public List<Equipment> retrieveEquipmentsWithOffsetAndLimit(int offset, int limit){
		List<Equipment> equipments = new ArrayList<Equipment>();
		
		try {
			List<EquipmentInformation> equipmentInformations = equipmentInformationDao.retrieveEquipmentInformationByOffsetAndLimit(offset, limit);
			for(int i =0; i < equipmentInformations.size(); i++){
				equipments.add( retrieveEquipmentByPkey(equipmentInformations.get(i).getPkey()) );
				
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return equipments;
	}
	
	public int addEquipment(Equipment equipment){
		int pkey = 0;
		
		EquipmentInformation equipmentInformation = new EquipmentInformation(
				equipment.getPkey(), equipment.getBarcode(), equipment.getEquipmentType().getPkey(), equipment.getRoom(), 
				equipment.getSerialNumber(), equipment.getManufacturer().getPkey(), equipment.getModelNumber(),
				equipment.getBeginDate(), equipment.getCost(), equipment.getAge());
		
		try {
			pkey = equipmentInformationDao.addEuipmentInformation(equipmentInformation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pkey;
	}
	
	public boolean updateEquipment(Equipment equipment){
		boolean updated = false;
		EquipmentInformation equipmentInformation = new EquipmentInformation(
				equipment.getPkey(), equipment.getBarcode(), equipment.getEquipmentType().getPkey(), equipment.getRoom(), 
				equipment.getSerialNumber(), equipment.getManufacturer().getPkey(), equipment.getModelNumber(),
				equipment.getBeginDate(), equipment.getCost(), equipment.getAge());
		
		try {
			updated =  equipmentInformationDao.updateEquipmentInformation(equipmentInformation);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return updated;
	}
	
	public boolean deleteEquipment(int pkey){
		boolean deleted = false;
		
		try {
			deleted =  equipmentInformationDao.deleteEquipmentInformation(pkey);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleted;
	}
}
