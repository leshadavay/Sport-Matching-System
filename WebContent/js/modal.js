function showCreatESPORTegoryModal() {
	var modal = document.getElementById('create-category-modal');

	// Get the button that opens the modal
	// var btn = document.getElementById("button-create-category");
	var modalBox = document.getElementsByClassName("modal-content")[0];
	var header = document.getElementsByClassName("modal-header")[0];
	var footer = document.getElementsByClassName("modal-footer")[0];
	var color = getDarkGradientColor();
	// console.log(color);
	// header.style.backgroundImage=color;
	// footer.style.backgroundImage=color;
	modalBox.style.boxShadow = "0 0 10px 1px white";
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[0];

	// When the user clicks the button, open the modal

	modal.style.display = "block";

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
	};

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
		}
	};
}

function showDescriptionModal(parent) {

	// console.log(parent);
	// Get the modal
	var modal = document.getElementById('show-description-modal');

	// Get the button that opens the modal
	// var btn = document.getElementById("button-create-category");
	var modalBox = document.getElementsByClassName("modal-content")[1];
	var modalBody = document.getElementsByClassName("modal-body")[1];
	var header = document.getElementsByClassName("modal-header")[1];
	var footer = document.getElementsByClassName("modal-footer")[1];
	var color = getDarkGradientColor();

	// header.style.backgroundImage=color;
	// footer.style.backgroundImage=color;
	modalBox.style.boxShadow = "0 0 10px 1px white";
	// Get the <span> element that closes the modal
	var span = document.getElementsByClassName("close")[1];

	// When the user clicks the button, open the modal

	modal.style.display = "block";

	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
		modal.style.display = "none";
		location.reload();
	};

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.style.display = "none";
			location.reload();
		}
	};

	var table = document.createElement("table");
	table.setAttribute("id", "description-table");

	header.childNodes[3].innerHTML = parent.childNodes[2].innerHTML;

	var opt = parent.childNodes[4].innerHTML;
	if (opt == "ECAT")
		opt = "E-Sport";
	else if (opt == "SCAT")
		opt = "Sport";

	var boardID = parent.childNodes[0].innerHTML;
	// /////////////////////////////////

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "Created by: "));
	table.appendChild(createElement("td", parent.childNodes[1].innerHTML));

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "Game type: "));
	table.appendChild(createElement("td", parent.childNodes[3].innerHTML));

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "Sport/E-Sport: "));
	table.appendChild(createElement("td", opt));

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "Single/Team: "));
	table.appendChild(createElement("td", parent.childNodes[5].innerHTML));

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "Created Date: "));
	table.appendChild(createElement("td", parent.childNodes[6].innerHTML));

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "Current Users: "));
	table.appendChild(createElement("td", parent.childNodes[7].innerHTML));

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "User limit: "));
	table.appendChild(createElement("td", parent.childNodes[8].innerHTML));// limit

	table.appendChild(createElement("tr", ""));
	table.appendChild(createElement("td", "Description: "));
	table.appendChild(createElement("td", parent.childNodes[10].innerHTML));

	// footer.style.backgroundColor="lightblue";
	while (modalBody.hasChildNodes()) {
		modalBody.removeChild(modalBody.lastChild);
	}

	modalBody.appendChild(table);

	// send post request to servlet
	$.post("addviewcount", {
		boardID : boardID
	}, function(data) {
		// alert("Data Loaded: " + data);
	});

	// 참가 신청 버튼 클릭했을때 서블릿에 post 보내기
	var submitbutton = document.getElementById("send-request-button");
	submitbutton.innerHTML = '참가 신청';
	submitbutton.onclick = function() {
		$.post("PartIn", {
			boardID : boardID
		}, function(response) {
			// 성공 음답 시 새로고침
			if (response) {
				alert("이미 참가 신청 되었습니다");
				location.replace("showboard");
			} else {
				alert("참가 신청 되었습니다");
				location.replace("showboard");
			}

		});

		modal.style.display = "none";

		return false;
	};

}
