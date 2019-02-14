// urls where our data will come from
let productURL = "http://localhost:9595/product/all";
let minURL = "http://localhost:9595/product/min";
let maxURL = "http://localhost:9595/product/max";
let sumURL = "http://localhost:9595/product/sum";
let medURL = "http://localhost:9595/product/median";
let avgURL = "http://localhost:9595/product/avg";

// get all the products
function getProducts(){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", productURL);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			let xhrObj = JSON.parse(xhr.response);
			console.log(xhrObj);
			for(item of xhrObj) {  
				addRow(item.id, item.name, item.price, item.quantity, item.warehouse.name);
			}
		} 
	}
	xhr.send();	
}


//create a function to add the prodcts to the table 
function addRow(id, name, price, quantity, warehouse){

	let row = document.createElement("tr");
	let cell1 = document.createElement("td");
	let cell2 = document.createElement("td");
	let cell3 = document.createElement("td");
	let cell4 = document.createElement("td");
	let cell5 = document.createElement("td");

	row.appendChild(cell1);
	row.appendChild(cell2);
	row.appendChild(cell3);
	row.appendChild(cell4);
	row.appendChild(cell5);


	cell1.innerHTML = id;
	cell2.innerHTML = name;
	cell3.innerHTML = price;
	cell4.innerHTML = quantity;
	cell5.innerHTML = warehouse;

	document.getElementById("products").appendChild(row);
}


//get min, max, sum, median, avg
function getAnalysis(url, callback){
	let xhr = new XMLHttpRequest();
	xhr.open("GET", url);
	xhr.onreadystatechange = function(){
		if(this.readyState === 4 && this.status === 200){
			console.log(url);
			callback(this);
		} 
	}
	xhr.send();	
}
	
function printMin(xhrObj){
    let jsonResponse = xhrObj.response;
    let data = JSON.parse(jsonResponse);
    data = (data).toFixed(2);
    document.getElementById("minPopup").innerHTML = data;
    var popup = document.getElementById("minPopup");
    popup.classList.toggle("show");
}

function printMax(xhrObj){
    let jsonResponse = xhrObj.response;
    let data = JSON.parse(jsonResponse);
    data = (data).toFixed(2);
    document.getElementById("maxPopup").innerHTML = data;
    var popup = document.getElementById("maxPopup");
    popup.classList.toggle("show");
}

function printSum(xhrObj){
    let jsonResponse = xhrObj.response;
    let data = JSON.parse(jsonResponse);
    data = (data).toFixed(2);
    document.getElementById("sumPopup").innerHTML = data;
    var popup = document.getElementById("sumPopup");
    popup.classList.toggle("show");
}

function printAvg(xhrObj){
    let jsonResponse = xhrObj.response;
    let data = JSON.parse(jsonResponse);
    data = (data).toFixed(2);
    document.getElementById("avgPopup").innerHTML = data;
    var popup = document.getElementById("avgPopup");
    popup.classList.toggle("show");
}

function printMed(xhrObj){
	let jsonResponse = xhrObj.response;
    let data = JSON.parse(jsonResponse);
    data = (data).toFixed(2);
    document.getElementById("medianPopup").innerHTML = data;
    var popup = document.getElementById("medianPopup");
    popup.classList.toggle("show");
    
}


//getAnalysis(minURL, printResponse);
//getAnalysis(maxURL, printResponse);
//getAnalysis(sumURL, printResponse);
//getAnalysis(avgURL, printResponse);
//getAnalysis(medURL, printMedian);








