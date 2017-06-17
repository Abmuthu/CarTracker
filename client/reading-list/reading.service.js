(function() {
	var app = angular.module("car-tracker-app");
	app.service("ReadingService", function($http) {
		var self = this;

		self.getReadingsOfAVehicle = function(vin, timeRange) {
			var promise1 = $http.get("http://localhost:8081/api/readings/" + vin + "/" + timeRange);
			var promise2 = promise1.then(function(response) {
				return response.data;
			});
			return promise2;
		}

		self.getReadingsInLastThirtyMinutes = function(vin) {
			var promise1 = $http.get("http://localhost:8081/api/readings/" + vin + "/" + 30);
			var promise2 = promise1.then(function(response) {
				return response.data;
			});
			return promise2;
		}

	});
})();
	