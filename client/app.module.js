var app = angular.module("car-tracker-app", ['ngRoute', 'ngMap', 'zingchart-angularjs']);

app.config(function($routeProvider) {
		$routeProvider
			.when("/vehicles", {
				templateUrl:"vehicle-list/vehicle-list.tmpl.html",
				controller:"VehicleServiceController",
				controllerAs:"vehicleController"
			})
			.when("/alerts", {
				templateUrl:"alert-list/alert-list.tmpl.html",
				controller:"AlertServiceController",
				controllerAs:"alertController"
			})
			.when("/criticalAlerts", {
				templateUrl:"vehicle-list/vehicle-alert-list.tmpl.html",
				controller:"VehiclesWithAlertsServiceController",
				controllerAs:"vehiclesWithAlertsController"
			})
			.when("/readingsPlot", {
				templateUrl:"reading-list/reading-list.tmpl.html",
				controller:"ReadingServiceController",
				controllerAs:"readingController"
			})
			.when("/geolocation", {
				templateUrl:"reading-list/geolocation.html",
				controller:"ReadingServiceController",
				controllerAs:"readingController"
			})
			.when("/welcome", {
				templateUrl:"welcome.html"
			})
			.otherwise({
				redirectTo: "/welcome"
			});
});
