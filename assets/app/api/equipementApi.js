angular.module('app').service('equipmentApi', function($http, apiPath){
	var api = apiPath + '/equipment';
	
	this.getEquipments = function(){
		return $http.get(api)
		.then(function(result){
			return result.data;
		}, function(error){
			console.log('Error', error);
			throw error.data;
		});
	};
	
	this.getEquipment = function(pkey){
		return $http.get(api+'/pkey/'+pkey)
		.then(function(result){
			return result.data;
		}, function(error){
			console.log('Error', error);
			throw error.data;
		});
	};
	
	this.addEquipment = function(equipment){
		return $http.post(api, equipment.getApiData)
		.then(function(result){
			return result.data;
		}, function(error){
			console.log('Error', error);
			throw error.data;
		});
	};
	
	this.updateEquipment = function(equipment){
		return $http.put(api, equipment.getApiData)
		.then(function(result){
			return result.data;
		}, function(error){
			console.log('Error', error);
			throw error.data;
		});
	};
	
	this.deleteEquipment = function(pkey){
		return $http.put(api+'/pkey/'+pkey)
		.then(function(result){
			return result.data;
		}, function(error){
			console.log('Error', error);
			throw error.data;
		});
	};
	
	
});