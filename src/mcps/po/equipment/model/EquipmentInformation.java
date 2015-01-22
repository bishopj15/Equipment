package mcps.po.equipment.model;

import java.sql.Date;

public class EquipmentInformation {
	private int pkey;
	private String barcode;
	private int equipmentTypeFk;
	private String room;
	private String serialNumber;
	private int manufacturer;
	private String modelNumber;
	private Date beginServiceDate;
	private int cost;
	private int age;
	
	public EquipmentInformation(){
		
	}
	
	/**
	 * 
	 * @param pkey
	 * @param barcode
	 * @param equipmentFk
	 * @param room
	 * @param serialNumber
	 * @param manufacturer
	 * @param modelNumber
	 * @param beginDate
	 * @param cost
	 * @param age
	 */
	public EquipmentInformation(int pkey, String barcode, int equipmentFk, String room, String serialNumber, int manufacturer, String modelNumber, Date beginDate, int cost, int age){
		this.pkey = pkey;
		this.barcode = barcode;
		this.equipmentTypeFk = equipmentFk;
		this.room = room;
		this.serialNumber = serialNumber;
		this.manufacturer = manufacturer;
		this.modelNumber = modelNumber;
		this.beginServiceDate = beginDate;
		this.cost = cost;
		this.age = age;
	}
	
	public int getPkey(){
		return this.pkey;
	}
	
	public void setPkey(int pkey){
		this.pkey = pkey;
	}
	
	public String getBarcode(){
		return this.barcode;
	}
	
	public void set(String barcode){
		this.barcode = barcode;
	}
	
	public int getEquipmentTypeFk(){
		return this.equipmentTypeFk;
	}
	
	public void setEquipmentTypeFk(int fk){
		this.equipmentTypeFk = fk;
	}
	
	public String getRoom(){
		return this.room;
	}
	
	public void setRoom(String room){
		this.room = room;
	}
	
	public String getSerialNumber(){
		return this.serialNumber;
	}
	
	public void setSerialNumber(String sn){
		this.serialNumber = sn;
	}
	
	public int getManufacturer(){
		return this.manufacturer;
	}
	
	public void setManufacturer(int manufacturer){
		this.manufacturer = manufacturer;
	}
	
	public String getModelNumber(){
		return this.modelNumber;
	}
	
	public void setModelNumber(String modelNumber){
		this.modelNumber = modelNumber;
	}
	
	public Date getBeginDate(){
		return this.beginServiceDate;
	}
	
	public void setBeginDate(Date date){
		this.beginServiceDate = date;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	public int getAge(){
		return this.age;
	}
	
	public void setAge(int age){
		this.age = age;
	}
	
	
	
}
