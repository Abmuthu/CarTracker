(function(){
	var app = angular.module("car-tracker-app");
	app.controller("AlertServiceController", alertController);

	function alertController(AlertService) {
		
		var self = this;
		self.allAlerts = [];

		self.getAlertsOfAVehicle = function() {
			AlertService.getAlertsOfAVehicle(self.vin)
				.then(function (data) {
					self.alertsOfAVehicle = data;
			});
		}
	}
})();