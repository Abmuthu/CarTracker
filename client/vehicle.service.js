(function() {
	var app = angular.module("car-tracker-app");
	app.service("VehicleService", function($http) {
		var self = this;
		self.getVehicles = function() {
			var promise1 = $http.get("http://localhost:8081/api/vehicles/getAll");
			var promise2 = promise1.then(function(response) {
				return response.data;
			});
			return promise2;
		}
	});
	
})();