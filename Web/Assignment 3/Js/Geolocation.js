function getLocation() {
	var x = document.getElementById("display");
	if (navigator.geolocation) {
		navigator.geolocation.getCurrentPosition(showPosition);
	} else {
		x.innerHTML = "Geolocation is not supported by this browser.";
	}
}
function showPosition(position) {
	var x = document.getElementById("display");
	x.innerHTML = "Latitude: " + position.coords.latitude + "<br>Longitude: "
			+ position.coords.longitude;
}