(function(){
	var app = angular.module("car-tracker-app");
	app.controller("VehicleServiceController", vehicleController);

	function vehicleController(VehicleService) {
		this.vehicles = VehicleService.vehicles;
	}
})();