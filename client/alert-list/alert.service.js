(function() {
	var app = angular.module("car-tracker-app");
	app.service("AlertService", function($http) {
		var self = this;

		self.getAlertsOfAVehicle = function(vin) {
			var promise1 = $http.get("http://localhost:8081/api/alerts/" + vin);
			var promise2 = promise1.then(function(response) {
				return response.data;
			});
			return promise2;
		}

		self.getAllAlerts = function() {
			var promise1 = $http.get("http://localhost:8081/api/alerts/getAll");
			var promise2 = promise1.then(function(response) {
				return response.data;
			});
			return promise2;

			// after getting the response data with is an array of alerts, 
			// for each vehicle loop through alerts array and count no of high alerts.
		}

		self.getVehicles = function() {
			var promise1 = $http.get("http://localhost:8081/api/vehicles/getAll");
			var promise2 = promise1.then(function(response) {
				return response.data;
			});
			return promise2;
		}
	});
})();
	