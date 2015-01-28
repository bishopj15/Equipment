var app = angular.module('app', ['ui.router', 'ngAnimate', 'ui.bootstrap']);
app.constant('rootPath', '/equipmentdb');
app.constant('assetsPath', '/equipmentdb/dist/app');
app.constant('apiPath', '/equipmentdb/rest/v1.0');

app.controller('appCtrl', function($scope){
    $scope.name = 'angular is working';
});


app.config(function($stateProvider, $urlRouterProvider, assetsPath){
	$urlRouterProvider.otherwise('/home');
	//$urlRouterProvider.when('',  '/home');
	//$urlRouterProvider.when('/',  '/home');
	
	$stateProvider
		.state('home', {
			url: '/home',
			templateUrl: '..' + assetsPath + '/equipment/equipment.html',
			controller: 'equipmentCtrl'
		});
});
