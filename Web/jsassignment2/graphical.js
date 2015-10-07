function create(noOfRows) {
	var result = "<table>";
	for (var i = 1; i <= noOfRows; i++) {
		var name = parseInt(document.getElementById("name" + i).value);
		var min = parseInt(document.getElementById("min" + i).value);
		var max = parseInt(document.getElementById("max" + i).value);
		if (min > max) {
			alert("Wrong input max should be greater than min");
			return;
		}
		result = result + "<tr>";
		result = result
				+ "<td style='width:20px; border-right: 2px solid black; border-bottom : 2px solid black;'>"
				+ name + "</td>";
		for (var j = 0; j <= 10; j++) {
			if (j >= min && j <= max) {
				result = result
						+ "<td  style='background-color:red; width:20px; border-bottom : 2px solid black;'></td>";
			} else {

				result = result
						+ "<td style=' width:20px; border-bottom : 2px solid black;'></td>";
			}
		}
		result = result + "</tr>";
	}
	result = result + "</table>";
	document.getElementById("graph").innerHTML = result;

}

function printrows() {

	var noOfRows = document.getElementById("noOfRows").value;
	noOfRows = noOfRows - 0;
	var result = "";
	result = "<form>";

	for (var i = 1; i <= noOfRows; i++) {
		result = result + "<input type=\"text\" id=\"name" + i
				+ "\"><input type=\"number\" min=\"0\" max=\"10\" id=\"min" + i
				+ "\"><input type=\"number\" min=\"0\" max=\"10\"id=\"max" + i
				+ "\"><br>";
	}
	result = result
			+ "<input type=\"button\" id=\"print\" value=\"OK\" onclick=\"create("
			+ noOfRows + ")\"></form>";

	document.getElementById("table").innerHTML = result;
}
