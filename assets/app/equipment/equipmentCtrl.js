angular.module('app').controller('equipmentCtrl', function($scope, equipmentApi){
	$scope.fields = ['barcode', 'equipmentType', 'room', 'serialNumber', 'manufacturer', 
	                 'modelNumber', 'beginServiceDate', 'cost', 'age'];
	$scope.equipments = [];
	$scope.message = '';
	
	$scope.setEquipments = function(){
		var items;
		equipmentApi.getEquipments()
			.then(function(date){
				 items = data;
			}, function(error){
				
			});
		console.log(items);
		if(items){
			$scope.equipments = items;
		}
		else{
			$scope.message = 'No results found';
		}
	};
	$scope.setEquipments();
});