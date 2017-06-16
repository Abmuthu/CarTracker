(function(){
	var app = angular.module("car-tracker-app");
	app.controller("ReadingServiceController", readingController);

	function readingController(ReadingService, $scope) {
		var self = this;

		self.getReadingsOfAVehicle = function() {

			ReadingService.getReadingsOfAVehicle(self.vin)
				.then(function (data) {
					self.readings = data;
				}).then(function () {
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
				});
		}
	}
})();