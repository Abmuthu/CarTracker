(function(){
	var app = angular.module("car-tracker-app");
	app.controller("AlertServiceController", alertController);

	function alertController(AlertService) {
		console.log("alert controller");
		this.alerts = AlertService.alerts;
	}
})();