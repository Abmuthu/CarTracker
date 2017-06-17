(function(){
	var app = angular.module("car-tracker-app");
	app.controller("VehiclesWithAlertsServiceController", vehicleController);

	function vehicleController(VehicleService) {
		var self = this;
		VehicleService.getVehiclesWithCriticalAlerts()
			.then(function(data) {
				self.vehicles = data;
		});
	}
})();