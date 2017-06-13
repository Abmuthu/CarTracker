(function() {
	var app = angular.module("car-tracker-app");
	app.service("ReadingService", function($http) {
		var self = this;

		this.readings = [
				{
				   "vin": "1HGCR2F3XFA027534",
				   "latitude": 41.803194,
				   "longitude": -88.144406,
				   "timestamp": "2017-05-25T17:31:25.268Z",
				   "fuelVolume": 1.5,
				   "speed": 85,
				   "engineHp": 240,
				   "checkEngineLightOn": false,
				   "engineCoolantLow": true,
				   "cruiseControlOn": true,
				   "engineRpm": 6300,
				   "tires": {
				      "frontLeft": 34,
				      "frontRight": 36,
				      "rearLeft": 29,
				      "rearRight": 34
				   }
				},
				{
				   "vin": "1HGCR2F3XFA027534",
				   "latitude": 40.803194,
				   "longitude": -87.144406,
				   "timestamp": "2017-05-21T17:31:25.268Z",
				   "fuelVolume": 2,
				   "speed": 80,
				   "engineHp": 241,
				   "checkEngineLightOn": false,
				   "engineCoolantLow": true,
				   "cruiseControlOn": true,
				   "engineRpm": 6300,
				   "tires": {
				      "frontLeft": 34,
				      "frontRight": 36,
				      "rearLeft": 29,
				      "rearRight": 34
				   }
				},
				{
				   "vin": "1HGCR2F3XFA027534",
				   "latitude": 43.803194,
				   "longitude": -82.144406,
				   "timestamp": "2017-05-24T17:31:25.268Z",
				   "fuelVolume": 4,
				   "speed": 70,
				   "engineHp": 251,
				   "checkEngineLightOn": false,
				   "engineCoolantLow": true,
				   "cruiseControlOn": true,
				   "engineRpm": 6300,
				   "tires": {
				      "frontLeft": 34,
				      "frontRight": 36,
				      "rearLeft": 29,
				      "rearRight": 34
				   }
				}


		];

	});
})();
	