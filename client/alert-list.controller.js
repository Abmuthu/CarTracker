(function(){
	var app = angular.module("car-tracker-app");
	app.controller("AlertServiceController", alertController);

	function alertController(AlertService, $http) {
		
		var self = this;
		self.allAlerts = [];

		self.getAlertsOfAVehicle = function() {
			// console.log("The vin is" + this.vin);
			console.log("getAlertsOfAVehicle of controller called!");
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
					console.log(self.vehicles);
					self.vehicles.forEach(function(vehicle) { 
						var count = 0;
						self.allAlerts.forEach(function(alert) {
							if (vehicle.vin == alert.vin) {
								count++;
								vehicle.hightAlertCount = count;
								// console.log("For vehicle: " + vehicle.vin + "The alert no is :" + count);
							}
						})
					});
					self.vehicles.forEach(function(vehicle) {
						console.log(vehicle);
					});
				});

		AlertService.getVehicles()
			.then(function(data) {
				self.vehicles = data;
			});
	}
})();