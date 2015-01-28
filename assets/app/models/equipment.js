angular.module('app').factory('Equipment', function(EquipmentType, Manufacturer){
	function Equipment(data){
		this.pkey = data.pkey;
		this.barcode = data.barcode;
		this.equipmentType = new EquipmentType(data.equipmentType);
		this.room = data.room;
		this.serialNumber = data.serialNumber;
		this.manufacturer = new Manufacturer(data.manufacturer);
		this.modelNumber = data.modelNumber;
		this.beginServiceDate = data.beginServiceDate;
		this.cost = data.cost;
		this.age = data.age;
	}
	
	Equipment.prototype.getApiData = function(){
		var equipment = angular.copy(this);
		return equipment;
	};
	
	return Equipment;
});