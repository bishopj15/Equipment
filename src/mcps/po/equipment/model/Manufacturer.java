package mcps.po.equipment.model;

public class Manufacturer {
	private int pkey;
	private String name;
	
	public Manufacturer(){
		
	}
	
	/**
	 * 
	 * @param pkey
	 * @param name
	 */
	public Manufacturer(int pkey, String name){
		this.pkey = pkey;
		this.name = name;
	}
	
	public int getPkey(){
		return this.pkey;
	}
	
	public void setPkey(int pkey){
		this.pkey = pkey;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String name){
		this.name = name;
	}
}
