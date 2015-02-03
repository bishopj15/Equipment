describe('equipments', function(){
    beforeEach(module('app'));

    beforeEach(inject(function($rootScope, $controller){
        $scope = $rootScope.$new();

        $controller('equipmentsCtrl', {$scope: $scope});
    }));

    it('should have empty array', function(){
        expect($scope.equipments.length).toBe(0);
    });
});
