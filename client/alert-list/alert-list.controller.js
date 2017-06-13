(function(){
	var app = angular.module("car-tracker-app");
	app.controller("AlertServiceController", alertController);

	function alertController(AlertService, $http) {
		
		var self = this;
		self.allAlerts = [];

		self.getAlertsOfAVehicle = function() {
			AlertService.getAlertsOfAVehicle(self.vin)
				.then(function (data) {
					self.alertsOfAVehicle = data;
			});
		}

		AlertService.getAllAlerts()
				.then(function (data) {
					self.allAlerts = data.filter(function(value) {
						return value.alertPriority == "HIGH";
					})
				}).then(function () {
					self.vehicles.forEach(function(vehicle) { 
						var count = 0;
						self.allAlerts.forEach(function(alert) {
							if (vehicle.vin == alert.vin) {
								count++;
								vehicle.hightAlertCount = count;
							}
						})
					});
				});

		AlertService.getVehicles()
			.then(function(data) {
				self.vehicles = data;
			});
	}
})();