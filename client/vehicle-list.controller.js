(function(){
	var app = angular.module("car-tracker-app");
	app.controller("VehicleServiceController", vehicleController);

	function vehicleController(VehicleService) {
		console.log("controller called");
		this.vehicles = VehicleService.vehicles;
	}
})();