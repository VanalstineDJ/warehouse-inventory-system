const baseURL = "http://localhost:9595/product";

function makeAjaxPost(url, callback, newProduct){
	let xhr = new XMLHttpRequest();
	xhr.open("POST", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 201){
			callback(xhr);
		} else {
			console.log(xhr.response);
		}
	}
	xhr.setRequestHeader("content-type", "application/json");
	let jsonProduct = JSON.stringify(newProduct);
	xhr.send(jsonProduct);	
}

function makeAjaxPut(url, callback, updatedProduct){
	let xhr = new XMLHttpRequest();
	xhr.open("PUT", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 204){
			callback(xhr);
			//alert("Product successfully updated!");
		} else {
			console.log(xhr.response);
		}
	}
	xhr.setRequestHeader("content-type", "application/json");
	let jsonProduct = JSON.stringify(updatedProduct);
	xhr.send(jsonProduct);	
}

function makeAjaxDelete(url, callback, deleteProduct){
	let xhr = new XMLHttpRequest();
	xhr.open("DELETE", url);
	xhr.onreadystatechange = function(){
		if(xhr.readyState === 4 && xhr.status === 200){
			callback(xhr);
		} else {
			console.log(xhr.response);
		}
	}
	xhr.setRequestHeader("content-type", "application/json");
	let jsonProduct = JSON.stringify(deleteProduct);
	xhr.send(jsonProduct);	
}



function addResponse(){
	alert("Product successfully created!");
}

function updateResponse(){
	alert("Product successfully updated!");
}

function deleteResponse(){
	alert("Product successfully deleted!");
}

function addProduct(){
	
	let newWarehouse = {
			"address": "",
			"id": document.getElementById("warehouseInput").value,
			"name": ""	
	}

	let newProduct = {		
		"id": document.getElementById("idInput").value,
		"name": document.getElementById("nameInput").value,
		"price": document.getElementById("priceInput").value,
		"quantity": document.getElementById("quantityInput").value,
		"warehouse": newWarehouse
	}
	
	makeAjaxPost(baseURL, addResponse, newProduct);		
}

function updateProduct(){
	
	let updatedWarehouse = {
			"address": "",
			"id": document.getElementById("updateWarehouseInput").value,
			"name": ""	
	}

	let updatedProduct = {		
		"id": document.getElementById("updateIdInput").value,
		"name": document.getElementById("updateNameInput").value,
		"price": document.getElementById("updatePriceInput").value,
		"quantity": document.getElementById("updateQuantityInput").value,
		"warehouse": updatedWarehouse
	}
	
	makeAjaxPut(baseURL, updateResponse, updatedProduct);		
}

function deleteProduct(){
	
	let deleteWarehouse = {
			"address": "",
			"id": document.getElementById("deleteWarehouseId").value,
			"name": ""	
	}
	
	let deletedProduct = {
			"id": document.getElementById("deleteIdInput").value,
			"name": document.getElementById("deleteNameInput").value,
			"price": document.getElementById("deletePriceInput").value,
			"quantity": document.getElementById("deleteQuantityInput").value,
			"warehouse": deleteWarehouse
	}
			
	makeAjaxDelete(baseURL, deleteResponse, deletedProduct);
}



document.getElementById("addProductButton").addEventListener("click", addProduct); 
document.getElementById("updateProductButton").addEventListener("click", updateProduct); 
document.getElementById("deleteProductButton").addEventListener("click", deleteProduct);






