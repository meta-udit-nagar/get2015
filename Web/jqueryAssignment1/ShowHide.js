function show() 
{
	document.getElementById("name").style.visibility = "visible";
	document.getElementById("showHideButton").value = "hide";
}
function hide()
{
	document.getElementById("name").style.visibility = "hidden";
	document.getElementById("showHideButton").value = "show";
}
function showHide() 
{
	if (document.getElementById("name").style.visibility == "visible") 
	{
		document.getElementById("name").style.visibility = "hidden";
		document.getElementById("showHideButton").value = "show";
	} 
	else 
	{
		document.getElementById("name").style.visibility = "visible";
		document.getElementById("showHideButton").value = "hide";
	}
}