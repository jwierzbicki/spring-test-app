$(document).ready(function() {

	refresh();
	
	$('#refresh').click(function() {
		$('#tableBody').empty();
		refresh();
	})

	function refresh() {

		$.ajax({
			url : "http://localhost:8080/products/all"
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
				
				let del = document.createElement('td');
				let delButton = document.createElement('input');
				delButton.type = 'button';
				delButton.value = 'Delete';
				delButton.setAttribute('class', 'btn btn-danger');
				delButton.onclick = function() {
					$.ajax({
						type : 'DELETE',
						url : 'http://localhost:8080/products/' + prod.id,
						success : function(data) {
							alert('Product deleted. Click Refresh.');
						},
						failure : function(errMsg) {
							alert(errMsg);
						}
					});
				};
				del.appendChild(delButton);

				row.appendChild(id);
				row.appendChild(name);
				row.appendChild(cat);
				row.appendChild(del);

				$('#tableBody').append(row);
			});
		});
	}

});
