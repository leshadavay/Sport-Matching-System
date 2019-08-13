var currentDate;
var currentYear;
var currentMonth;
var tDay; // original(today's) date
var tMonth;
var tYear;

var eventDate;
var eventDetails;
var data = [];

function initStorage() {

	if (typeof (Storage) !== "undefined") {

		currentDate = new Date();
		currentYear = currentDate.getFullYear();
		currentMonth = currentDate.getMonth();
		tDay = currentDate.getDate(); // todays day
		tMonth = currentDate.getMonth();
		tYear = currentDate.getFullYear();

		localStorage.setItem("tDay", tDay.toString());
		localStorage.setItem("tMonth", tMonth.toString());
		localStorage.setItem("tYear", tYear.toString());
		localStorage.setItem("currentMonth", currentMonth.toString());
		localStorage.setItem("currentYear", currentYear.toString());
		localStorage.setItem("initDate", "ok");

		if (localStorage.getItem("isEvent") === null)
			localStorage.setItem("isEvent", "yes");

	}
}

function initDate() {

	if (typeof (Storage) !== "undefined") {
		if (localStorage.getItem("initDate") == null)
			initStorage();

		currentYear = parseInt(localStorage.getItem("currentYear"));
		currentMonth = parseInt(localStorage.getItem("currentMonth"));
		tDay = parseInt(localStorage.getItem("tDay"));
		tMonth = parseInt(localStorage.getItem("tMonth"));
		tYear = parseInt(localStorage.getItem("tYear"));

		var isEvent = localStorage.getItem("isEvent");
		if (isEvent == "yes" || isEvent == "init") {

			var tmpDate = localStorage.getItem("eventDate");
			var tmpDetails = localStorage.getItem("eventDetails");

			eventDate = tmpDate.split("/");
			eventDetails = tmpDetails.split("/");

			localStorage.setItem("isEvent", "no");
		}
		currentDate = new Date(currentYear, currentMonth);

	}
	// alert(currentYear + " " + currentMonth);

	makeCalendar();
}

function reInitCalendar() { // when click 'TODAY' button
	initStorage();
	location.reload();
}

function addEvent(year, month, day) {
	var newDate = year + " " + month + " " + day;
	var newDetails;
	while (true) {
		newDetails = prompt("Input new event: \n", "ex: Soccer at 18:00");
		if (newDetails == "")
			alert("Event is empty!");
		else
			break;
	}

	localStorage.setItem("isEvent", "yes");

	if (newDetails != null) {

		$.post("savenewevent", {
			newevent : newDetails,
			eventdate : newDate
		}, function(msg) {
			if (!msg) {
				localStorage.setItem("isEvent", "failtosave");

			}

		});

		location.reload();

	}
}

function deleteEvent(year,month,day) {
	   
    var removeDate=year+" "+month+" "+day;
    localStorage.setItem("isEvent","yes");
    
    $.post("removeevent",
          { 
          eventdate:removeDate
          },
          function(msg){
            if(!msg){
              localStorage.setItem("isEvent","failtoremove");
              
            }
           
          }
    );
    location.reload();

}
function getEvent(year, month, day) {

	// if(localStorage.getItem("isEvent")==="yes"){
	var tempDate = localStorage.getItem("eventDate");
	var tempDetails = localStorage.getItem("eventDetails");
	var eDate = tempDate.split("/");
	var eDetails = tempDetails.split("/");
	var compare = year + " " + month + " " + day;
	for (var i = 0; i < eDate.length; i++) {
		if (eDate[i] === compare)
			return eDetails[i];
	}
	return "no";
	// }
	// else return "no";
}
function daysInMonth(month, year) {
	return new Date(year, month + 1, 0).getDate();
}
function prevMonth() {

	if (currentMonth < 1) {
		currentMonth = 11;
		currentYear--;
	} else
		currentMonth--;
	if (typeof (Storage) !== "undefined") {
		localStorage.setItem("currentMonth", (currentMonth).toString());
		localStorage.setItem("currentYear", (currentYear).toString());

	}
	location.reload();
}
function nextMonth() {
	if (currentMonth > 10) {
		currentMonth = 0;
		currentYear++;
	} else
		currentMonth++;
	if (typeof (Storage) !== "undefined") {
		localStorage.setItem("currentMonth", (currentMonth).toString());
		localStorage.setItem("currentYear", (currentYear).toString());
	}
	location.reload();
}

function makeCalendar() {
	/*
	 * if(localStorage.getItem("isEvent")==="yes") { //print event on top for
	 * check for (var i = 0; i < eventDate.length; i++) {
	 * document.write(eventDate[i]+" "+eventDetails[i]+"<br>"); } }
	 */
	var currentDayOfWeek = currentDate.getDay();
	var dayCount = daysInMonth(currentMonth, currentYear);
	var weekNames = [ 'MON', 'TUE', 'WED', 'THU', 'FRI', 'SAT', 'SUN' ];
	var monthNames = [ 'January', 'February', 'March', 'April', 'May', 'June',
			'July', 'August', 'September', 'October', 'November', 'December' ];

	var tmp = new Date(currentYear, currentMonth, 0);
	var startDay = tmp.getDay();

	document
			.write("<div id='cal-container'><div id='title'> <a href='schedule.html' onclick='prevMonth();return false;'>prev</a><h3 id='cal-title-h3'>"
					+ monthNames[currentMonth]
					+ " "
					+ currentYear
					+ "</h3><a href='schedule.html' onclick='nextMonth();return false;'>next</a> <a id='caption-today' href='schedule.html' onclick='reInitCalendar();return false;'>today</a> </div><table><thead><tr>");
	for (var i = 0; i < 7; i++) { // print weeks
		document.write("<th>" + weekNames[i] + "</th>");
	}
	document.write("</tr></thead><tbody>");

	for (var i = 0, day = 1; i < dayCount + startDay; i++) {

		if (i % 7 === 0)
			document.write("</tr><tr>"); // next line
		if (startDay > i)
			document.write("<td></td>");// empty cells
		else {
			var isEvent = getEvent(currentYear, currentMonth, day);
			if (currentYear === tYear && currentMonth === tMonth
					&& day === tDay) { // mark circle for today
				if (isEvent !== "no") {
					document
							.write("<td><div id='cell-days-with-event'><div><p id='today'>"
									+ day
									+ "</p><br><div id='events' onclick='deleteEvent(currentYear,currentMonth,"
									+ day
									+ ");return false;'>"
									+ isEvent
									+ "</div></div></div></td>");
				} else {
					document
							.write("<td><div id='cell-days-no-event'><div onclick='addEvent(currentYear,currentMonth,"
									+ day
									+ ");return false;' ><p id='today'>"
									+ day + "</p></div></div></td>");
				}
			} else { // rest of days
				if (isEvent !== "no") {
					document
							.write("<td><div id='cell-days-with-event'><div>"
									+ day
									+ "<br><div id='events' onclick='deleteEvent(currentYear,currentMonth,"
									+ day + ");return false;'>" + isEvent
									+ "</div>");
				} else {
					document
							.write("<td><div id='cell-days-no-event'><div onclick='addEvent(currentYear,currentMonth,"
									+ day
									+ ");return false;' >"
									+ day
									+ "</div></div></td>");
				}
			}
			day++;
		}

	}

	if (i > 35) {
		while (i < 42) {
			document.write("<td></td>");
			i++;
		}
	} else if (i > 28 && i < 35) {
		while (i < 35) {
			document.write("<td></td>");
			i++;
		}
	}

	document.write("</tr></tbody></table></div> ");

}
