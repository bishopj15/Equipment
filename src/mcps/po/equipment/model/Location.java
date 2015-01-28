package mcps.po.equipment.model;

public class Location {
	private int pkey;
	private int facility_id;
	private String facility_name;
	
	public int getPkey(){
		return pkey;
	}
	
	public void setPkey(int pkey){
		this.pkey = pkey;
	}
	
	public int getFacilityId(){
		return facility_id;
	}
	
	public void setFacilityId(int fid){
		this.facility_id = fid;
	}
	
	public String getFacilityName(){
		return facility_name;
	}
	
	public void setFacilityName(String name){
		this.facility_name = name;
	}
}
