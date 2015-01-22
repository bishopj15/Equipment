var app = angular.module('app', ['ui.router', 'ngAnimate', 'ui.bootstrap']);
app.constant('rootPath', '/equipmentdb');
app.constant('assetsPath', '/equipmentdb/dist/app');
app.constant('apiPath', '/equipmentdb/rest/v1.0');

app.controller('appCtrl', function($scope){
    $scope.name = 'angular is working';
});
