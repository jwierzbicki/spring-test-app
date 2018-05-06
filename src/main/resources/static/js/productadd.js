$(document).ready(function() {

	$('#addButton').click(function() {

		let formData = {};
		let name = document.getElementById('name').value;
		let category = document.getElementById('category').value;

		formData.name = name;
		formData.category = category;

		$.ajax({
			type : 'POST',
			url : 'http://localhost:8080/products/add',
			data : JSON.stringify(formData),
			contentType : 'application/json; charset=utf-8',
			dataType : 'json',
			success : function(data) {
				$('#name').val('');
				$('#category').val('');
				alert('Product added');
			},
			failure : function(errMsg) {
				alert(errMsg);
			}
		});
	});

});