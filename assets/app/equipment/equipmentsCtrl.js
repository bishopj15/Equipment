angular.module('app').controller('equipmentsCtrl', function($scope, $state, $stateParams, equipmentApi){
	$scope.fields = ['barcode', 'equipmentType', 'room', 'serialNumber', 'manufacturer',
	                 'modelNumber', 'beginDate', 'cost', 'age'];
	$scope.equipments = [];
	$scope.message = '';

	function setEquipments(){
		var items = [];
		equipmentApi.getEquipments()
			.then(function(data){
				items = data;
				if(items){
					$scope.equipments = items;
				}
				else{
					$scope.message = 'No results found';
				}
			}, function(error){
				console.log('error data: ', data);
			});
	}

	$scope.gotoSingle = function(equipment){
		$state.go('equipment', {
			'pkey': equipment.pkey
		});
	};

	setEquipments();
});
