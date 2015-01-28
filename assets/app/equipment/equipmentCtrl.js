angular.module('app').controller('equipmentCtrl', function($scope, equipmentApi){
	$scope.fields = ['barcode', 'equipmentType', 'room', 'serialNumber', 'manufacturer',
	                 'modelNumber', 'beginDate', 'cost', 'age'];
	$scope.equipments = [];
	$scope.message = '';

	$scope.setEquipments = function(){
		var items = [];
		equipmentApi.getEquipments()
			.then(function(data){
				console.log('retrieved data: ', data);
				items = data;
				if(items){
					console.log('items data: ', items);
					$scope.equipments = items;
				}
				else{
					$scope.message = 'No results found';
				}
			}, function(error){
				console.log('error data: ', data);
			});
		console.log(items);

	};
	$scope.setEquipments();
});
