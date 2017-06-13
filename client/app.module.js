var app = angular.module("car-tracker-app", ['ngRoute', 'ngMap', 'zingchart-angularjs']);

app.config(function($routeProvider) {
		$routeProvider
			.when("/vehicles", {
				templateUrl:"vehicle-list.tmpl.html",
				controller:"VehicleServiceController",
				controllerAs:"vehicleController"
			})
			.when("/alerts", {
				templateUrl:"alert-list.tmpl.html",
				controller:"AlertServiceController",
				controllerAs:"alertController"
			})
			.when("/criticalAlerts", {
				templateUrl:"all-alerts-list.tmpl.html",
				controller:"AlertServiceController",
				controllerAs:"alertController"
			})
			.when("/readingsPlot", {
				templateUrl:"readings-list.tmpl.html",
				controller:"ReadingServiceController",
				controllerAs:"readingController"
			})
			.when("/welcome", {
				templateUrl:"welcome.html"
			})
			.when("/geolocation", {
				templateUrl:"map.html"
			})
			.otherwise({
				redirectTo: "/welcome"
			});
});
