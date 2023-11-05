muaNgay = () => {

	var maMau = $(".selected__color input").val();
	var maSanPham = $("#maSP").text();
	var apiFetch =
		"http://localhost:8081/websiteVali/api/gio-hang/them-vao-gio-hang?maSanPham=" +
		maSanPham +
		"&maMau=" +
		maMau;

	$.get(apiFetch, function (data) {
		//		setTimeout(function () {
		if (data == 1) {
			toastr.success("Đã thêm vào giỏ hàng");
			window.location.href =
				"http://localhost:8081/websiteVali/gio-hang";
		} else if (data == -1) {
			toastr.error("Sản phẩm đã hết hàng");
		}
		//		}, 500);
	});
};

themVaoGio = () => {

	var maMau = $(".selected__color input").val();
	var maSanPham = $("#maSP").text();
	var apiFetch =
		"http://localhost:8081/websiteVali/api/gio-hang/them-vao-gio-hang?maSanPham=" +
		maSanPham +
		"&maMau=" +
		maMau;

	$.get(apiFetch, function (data) {
		//		setTimeout(function () {
		if (data == 1) {
			toastr.success("Đã thêm vào giỏ hàng");
		} else if (data == -1) {
			toastr.error("Sản phẩm đã hết hàng");
		}
		//		}, 500);
	});
};