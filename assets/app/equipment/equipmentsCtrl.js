angular.module('app').controller('equipmentsCtrl', function($scope, $state, $stateParams, equipmentApi){
	$scope.fields = ['barcode', 'equipmentType', 'room', 'serialNumber', 'manufacturer',
	                 'modelNumber', 'beginDate', 'cost', 'age'];
	$scope.items = [];
	$scope.totalItems;
	$scope.message = '';
	$scope.itemsPerPage = 25;
	$scope.maxSize = 5;
	$scope.currentPage = 1;
	
	$scope.setItems = function(items) {
		if(items.length > 0){
			$scope.items = items;
		} else {
			$scope.message = 'Ne results found';
		}
	};
	
	$scope.setTotalCount = function(totalItems) {
		$scope.totalItems = totalItems;
	};
	
	$scope.loadItems = function(){
		equipmentApi.getEquipments()
			.then(function(data){
				$scope.setItems(data);
				$scope.setTotalCount(data.length);
			}, function(error){
				console.log('error data', error);
			});
	};
	
	$scope.clearItems = function(){
		$scope.message = '';
		$scope.items = [];
	};
	
	//Returns the item offset for the current page.
	$scope.getOffset = function() {
		var offset = ($scope.currentPage - 1) * $scope.itemsPerPage;
		return offset;
	};
	
	function setEquipments(){
		var items = [];
		equipmentApi.getAllEquipments()
			.then(function(data){
				items = data;
				if(items){
					$scope.items = items;
				}
				else{
					$scope.message = 'No results found';
				}
			}, function(error){
				console.log('error data: ', error);
			});
	}

	$scope.gotoSingle = function(equipment){
		$state.go('equipment', {
			'pkey': equipment.pkey
		});
	};
	
	$scope.showPagination = function() {
	    return ($scope.totalItems > $scope.itemsPerPage);
	};

	$scope.loadItems();
});
