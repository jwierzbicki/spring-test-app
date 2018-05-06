$(document).ready(function() {
	
	let id = localStorage.getItem('productid');
	
	$.ajax({
		url : 'http://localhost:8080/products/' + id
	}).then(function(product) {
		
		$('#nameUp').val(product.name);
		$('#catUp').val(product.category);
	});
	
	$('#buttonUp').click(function() {
		
		let upData = {};
		let name = document.getElementById('nameUp').value;
		let category = document.getElementById('catUp').value;
		upData.name = name;
		upData.category = category;
		
		$.ajax({
			type: 'PUT',
			url: 'http://localhost:8080/products/' + id,
			data: JSON.stringify(upData),
			contentType: 'application/json; charset=utf-8',
			dataType: 'json',
			success: function(data) {
				window.location.href = 'http://localhost:8080/sometext';
			},
			failure: function(errMsg) {
				alert(errMsg);
			}
		})
	})
	
});