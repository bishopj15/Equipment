angular.module('app').factory('Manufacturer', function(){
	function Manufacturer(data){
		this.pkey = data.pkey;
		this.name = data.name;
	}
	
	return Manufacturer;
});