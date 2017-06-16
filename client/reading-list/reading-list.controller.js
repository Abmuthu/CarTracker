(function(){
	var app = angular.module("car-tracker-app");
	app.controller("ReadingServiceController", readingController);

	function readingController(ReadingService, $scope) {
		var self = this;

		self.getReadingsOfAVehicle = function() {
			ReadingService.getReadingsOfAVehicle(self.vin, self.timeRange)
				.then(function (data) {
					self.readings = data;
				}).then(function () {
					self.signal = [];
					console.log("The selectedSignal is: " + self.selectedSignal);
					self.readings.forEach(function(reading) {
						if (self.selectedSignal === "fuelVolume") {
							self.signal.push(reading.fuelVolume);
						}	
						else if (self.selectedSignal === "speed") {
							self.signal.push(reading.speed);
						}
						// self.signal.push(reading.fuelVolume);
					});
					
					$scope.myJson = {
				    	type : 'line',
				    	series : [
				      	{ values : self.signal }
				    	]
					};
				});
		}
	}
})();