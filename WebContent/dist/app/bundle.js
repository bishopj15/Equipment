var app = angular.module('app', ['ui.router', 'ngAnimate', 'ui.bootstrap']);
app.constant('rootPath', '/equipmentdb');
app.constant('assetsPath', '/equipmentdb/dist/app');
app.constant('apiPath', '/equipmentdb/rest/v1.0');

app.controller('appCtrl', function($scope){

});


app.config(function($stateProvider, $urlRouterProvider, assetsPath){
	$urlRouterProvider.otherwise('/home');
	//$urlRouterProvider.when('',  '/home');
	//$urlRouterProvider.when('/',  '/home');

	$stateProvider
		.state('home', {
			url: '/home',
			templateUrl: '..' + assetsPath + '/equipment/equipments.html',
			controller: 'equipmentsCtrl'
		})
        .state('equipment', {
            url: '/equipment/:pkey',
            templateUrl: '..' + assetsPath + '/equipment/single_equipment.html',
            controller: 'equipmentCtrl'
        });
});

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

angular.module('app').controller('equipmentCtrl', function($scope, $state, $stateParams, equipmentApi){

    $scope.equipment = {};

    function loadEquipment(){
        var item = {};

        if ($stateParams.pkey){
            equipmentApi.getEquipment($stateParams.pkey)
            .then(function(data){
                item = data;
                if(item){
                    $scope.equipment = item;
                }
            }, function(error){
                console.log('error data: ', data);
            });
        }
    }

    loadEquipment();
});

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
angular.module('app').factory('Manufacturer', function(){
	function Manufacturer(data){
		this.pkey = data.pkey;
		this.name = data.name;
	}
	
	return Manufacturer;
});