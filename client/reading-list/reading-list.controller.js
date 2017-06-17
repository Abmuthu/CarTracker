(function(){
	var app = angular.module("car-tracker-app");
	app.controller("ReadingServiceController", readingController);

	function readingController(ReadingService, $scope, NgMap) {
		var self = this;
		self.zoom = 3;
		self.show = false;
		self.getReadingsOfAVehicle = function() {
			ReadingService.getReadingsOfAVehicle(self.vin, self.timeRange)
				.then(function (data) {
					self.readings = data;
				}).then(function () {
					self.signal = [];
					self.readings.forEach(function(reading) {
						if (self.selectedSignal === "fuelVolume") {
							self.signal.push(reading.fuelVolume);
						}	
						else if (self.selectedSignal === "speed") {
							self.signal.push(reading.speed);
						}
					});
					
					$scope.myJson = {
				    	type : 'line',
				    	series : [
				      	{ values : self.signal }
				    	]
					};
				});
		}

		self.markLocations = function() {
			ReadingService.getReadingsInLastThirtyMinutes(self.vin)
				.then(function (data) {
					self.readingsInThirtyMinutes = data;
				}).then(function () {
					self.show = true;
				});
		}
	}
})();