/*
 **
 */
document.addEventListener('DOMContentLoaded', function() {
	//Modalの呼び出し
	var myModal = new bootstrap.Modal(document.getElementById("exampleModal"), {});
	//クリックイベント追加
	document.querySelectorAll('.modal_target').forEach(function(e) {
		e.addEventListener('click', function() {
			document.getElementById('modal_rental_form').action = "/rental/" + this.dataset.book_id;
			document.getElementById('modal_input_name').textContent = this.querySelector(".modal_book_name").textContent;
			document.getElementById('modal_input_author').textContent = this.querySelector(".modal_book_author").textContent;
			document.getElementById('modal_input_publisher').textContent = this.querySelector(".modal_book_publisher").textContent;

			document.getElementById('modal_input_stock').textContent = this.querySelector(".modal_stock").textContent;

			document.getElementById('preview').src = this.querySelector("img").src;
			myModal.show();
		});
	});
});