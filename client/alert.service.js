(function() {
	var app = angular.module("car-tracker-app");
	app.service("AlertService", function() {
		this.alerts = [
		    {
		        "vin": "1FMYU02143KB34432",
		        "timestamp": 1497221814400,
		        "alertPriority": "LOW",
		        "alertMessage": "Flat Tire!"
		    },
		    {
		        "vin": "1FMYU02143KB34432",
		        "timestamp": 1497221868547,
		        "alertPriority": "LOW",
		        "alertMessage": "Flat Tire!"
		    },
		    {
		        "vin": "1FMYU02143KB34432",
		        "timestamp": 1497221793412,
		        "alertPriority": "HIGH",
		        "alertMessage": "Engine rpm too high!"
		    },
		    {
		        "vin": "1FMYU02143KB34432",
		        "timestamp": 1497221835533,
		        "alertPriority": "LOW",
		        "alertMessage": "Flat Tire!"
		    },
		    {
		        "vin": "1FMYU02143KB34432",
		        "timestamp": 1497221859532,
		        "alertPriority": "HIGH",
		        "alertMessage": "Engine rpm too high!"
		    }
	    ];
	});
	
})();