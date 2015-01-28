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
