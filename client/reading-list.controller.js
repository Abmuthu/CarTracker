(function(){
	var app = angular.module("car-tracker-app");
	app.controller("ReadingServiceController", readingController);

	function readingController(ReadingService, $http, $scope) {
		var self = this;

		self.getReadingsOfAVehicle = function() {
			self.readings = ReadingService.readings;
			self.fuelVolume = [];
			self.readings.forEach(function(reading) {
				self.fuelVolume.push(reading.fuelVolume);
			});
			$scope.myJson = {
		    type : 'line',
		    series : [
		      { values : self.fuelVolume }
		    ]
		};
		}
	}
})();