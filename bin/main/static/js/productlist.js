$(document).ready(function() {
	
	$.ajax({
		url: "http://localhost:8080/products/all"
	}).then(function(products) {
		products.forEach(function(prod) {
			
			let row = document.createElement('tr');
			
			let id = document.createElement('td');
			let idInner = document.createTextNode(prod.id);
			id.appendChild(idInner);
			
			let name = document.createElement('td');
			let nameInner = document.createTextNode(prod.name);
			name.appendChild(nameInner);
			
			let cat = document.createElement('td');
			let catInner = document.createTextNode(prod.category);
			cat.appendChild(catInner);
			
			row.appendChild(id);
			row.appendChild(name);
			row.appendChild(cat);
			
			$('#productTable').append(row);
		})
	});
});

