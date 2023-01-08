/*
 画像プレビュー
 */
function previewFile(image) {

	var fileData = new FileReader();

	fileData.onload = (function() {
		//id属性が付与されているimgタグのsrc属性に、fileReaderで取得した値の結果を入力することでプレビュー表示している
		document.getElementById('preview').src = fileData.result;
	});
	
	fileData.readAsDataURL(image.files[0]);
	
}
