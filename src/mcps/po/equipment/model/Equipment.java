package mcps.po.equipment.model;

import java.sql.Date;

public class Equipment {
	private int pkey;
	private String barcode;
	private EquipmentType equipmentType;
	private String room;
	private String serialNumber;
	private Manufacturer manufacturer;
	private String modelNumber;
	private Date beginServiceDate;
	private int cost;
	private int age;
	
	public Equipment(){}
	
	public Equipment(int pkey, String barcode, EquipmentType equipmentType, String room, String serialNumber, Manufacturer manufacturer, String modelNumber, Date beginDate, int cost, int age){
		this.pkey = pkey;
		this.barcode = barcode;
		this.equipmentType = equipmentType;
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
	
	public void setBarcode(String barcode){
		this.barcode = barcode;
	}
	
	public EquipmentType getEquipmentType(){
		return this.equipmentType;
	}
	
	public void setEquipmentTypeFk(EquipmentType et){
		this.equipmentType = et;
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
	
	public Manufacturer getManufacturer(){
		return this.manufacturer;
	}
	
	public void setManufacturer(Manufacturer manufacturer){
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
