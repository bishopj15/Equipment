angular.module('app').factory('EquipmentType', function(){
	function EquipmentType(data){
		this.pkey = data.pkey;
		this.equipment_id  = data.equipment_id;
		this.description = data.description;
		this.rank = data.rank;
		this.replacement_cost = data.replacement_cost;
	}
	
	return EquipmentType;
});