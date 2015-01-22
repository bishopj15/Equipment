package mcps.po.equipment.model;

public class MinimumEquipmentRequired {
	private int pkey;
	private int equipmentTypeFk;
	private int hsTotal;
	private int msTotal;
	private int esTotal;
	
	MinimumEquipmentRequired(){
		
	}
	
	/**
	 * 
	 * @param pkey
	 * @param equipmentFk The piece of equipment
	 * @param hs Number of devices need in a high school
	 * @param ms Number of devices need in a middle school
	 * @param es Number of devices need in a elementary school
	 */
	MinimumEquipmentRequired(int pkey, int equipmentFk, int hs, int ms, int es){
		this.pkey = pkey;
		this.equipmentTypeFk = equipmentFk;
		this.hsTotal = hs;
		this.msTotal = ms;
		this.esTotal = es;
	}
	
	public int getPkey(){
		return this.pkey;
	}
	
	public void setPkey(int pkey){
		this.pkey = pkey;
	}
	
	public int getEquipmentFk(){
		return this.equipmentTypeFk;
	}
	
	public void setEquipmentFk(int fk){
		this.equipmentTypeFk = fk;
	}
	
	public int getHSTotal(){
		return this.hsTotal;
	}
	
	public void setHSTotal(int hs){
		this.hsTotal = hs;
	}
	
	public int getMSTotal(){
		return this.msTotal;
	}
	
	public void setMSTotal(int ms){
		this.msTotal = ms;
	}
	
	public int getESTotal(){
		return this.esTotal;
	}
	
	public void setESTotal(int es){
		this.esTotal = es;
	}
}
