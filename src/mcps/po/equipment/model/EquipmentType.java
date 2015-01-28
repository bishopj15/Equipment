package mcps.po.equipment.model;

public class EquipmentType {
	private int pkey;
	private int equipment_id;
	private String description;
	private int rank;
	private int replacement_cost;
	
	public EquipmentType(){
		
	}
	/**
	 * 
	 * @param pkey 
	 * @param equipment_id ID of equipment
	 * @param description Description of the device
	 * @param rank 
	 * @param replacement_cost Current cost to replace 
	 */
	public EquipmentType(int pkey, int equipment_id, String description, int rank, int replacement_cost){
		this.pkey = pkey;
		this.equipment_id = equipment_id;
		this.description = description;
		this.rank = rank;
		this.replacement_cost = replacement_cost;
	}
	
	public int getPkey(){
		return this.pkey;
	}
	
	public void setPkey(int pkey){
		this.pkey = pkey;
	}
	
	public int getEquipmentId(){
		return this.equipment_id;
	}
	
	public void setEquipmentId(int id){
		this.equipment_id = id;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String description){
		this.description = description;
	}
	
	public int getRank(){
		return this.rank;
	}
	
	public void setRank(int rank){
		this.rank = rank;
	}
	
	public int getReplacementCost(){
		return this.replacement_cost;
	}
	
	public void setRaplacementCost(int cost){
		this.replacement_cost = cost;
	}
}
