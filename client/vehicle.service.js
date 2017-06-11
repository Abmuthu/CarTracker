(function() {
	var app = angular.module("car-tracker-app");
	app.service("VehicleService", function() {
		this.vehicles = [
	 		{
			    "vin": "1HGCR2F3XFA027534",
			    "make": "HONDA",
			    "model": "ACCORD",
			    "year": 2015,
			    "redlineRpm": 5500,
			    "maxFuelVolume": 15,
			    "lastServiceDate": "2017-05-25T17:31:25.268Z"
			},
		 	{
			    "vin": "WP1AB29P63LA60179",
			    "make": "PORSCHE",
			    "model": "CAYENNE",
			    "year": 2015,
			    "redlineRpm": 8000,
			    "maxFuelVolume": 18,
			    "lastServiceDate": "2017-03-25T17:31:25.268Z"
			}
		];
	});
	
})();