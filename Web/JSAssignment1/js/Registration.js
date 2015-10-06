function activateSubmit() {

	if (document.getElementById("acceptCondition").checked == true) {
		document.getElementById("submitButton").disabled = false;

	} else {
		document.getElementById("submitButton").disabled = true;
	}
}


function validate() {
	var count = 0;
	if (document.getElementById("firstName").value.trim() == "") {
		count = 1;
		alert("First Name Is Empty");
	}
	if (document.getElementById("lastName").value.trim() == "") {
		count = 1;
		alert("Last Name Is Empty");
	}
	if (document.getElementById("password").value.length < 8) {
		count = 1;
		alert("Password Length should be greater than 8");
	}
	if (document.getElementById("password").value != document
			.getElementById("confirmPassword").value) {
		count = 1;
		alert("Password & Confirm Password mismatch!!");
	}
	if (document.getElementById("state") == "Select State"
			|| document.getElementById("city").value == "Select City") {
		count = 1;
		alert("State or City are not Selected!!");
	}
	if (count == 0) {
		alert("USER CREATED SUCCESSFUL");
	} else {
		alert(document.getElementById("textBox").value);
	}

}


function createCity() {
	var cityObject = document.getElementById("city");
	var stateObject = document.getElementById("state");
	switch (stateObject.value) {
	case "Rajasthan":
		cityObject.innerHTML = "<Option>Jaipur</option><Option>Udaipur</option><Option>Kota</option><Option>Ajmer</option>";
		break;
	case "UP":
		cityObject.innerHTML = "<Option>Bareilly</option><Option>Kanpur</option><Option>Lucknow</option><Option>Mathura</option>";
		break;
	}
}