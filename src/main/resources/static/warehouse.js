// url where our list of warehouses will come from
let warehouseURL = "http://localhost:9595/warehouse/all";

function getWarehouses(){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", warehouseURL);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			let xhrObj = JSON.parse(xhr.response);
			console.log(xhrObj);
			for(item of xhrObj){
				addRow(item.id, item.name, item.address);
			}
		}
	}
	xhr.send();
}

// create a table of the warehouses
function addRow(id, name, address){
	
	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	
	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	
	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = address;
	
	document.getElementById("warehouses").appendChild(row);		
}


