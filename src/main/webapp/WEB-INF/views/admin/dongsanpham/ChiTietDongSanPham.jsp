<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết dòng sản phẩm</title>
</head>
<body>


	<div class="container-fluid" style="background-color: #fff">
		
		<p>${ dongSanPham.id }</p>
		<p>${ dongSanPham.tenDongSanPham }</p>
		<p>${ dongSanPham.thuongHieu.tenThuongHieu }</p>
		<p>${ dongSanPham.loaiSanPham.tenLoaiSanPham }</p>
		<button onClick="window.location.href='http://localhost:8081/websiteVali/admin/dong-san-pham/danh-sach-dong-san-pham'" class="btn btn-success">Quay lại</button>
		

	</div>
	<!-- /.container-fluid -->
	
</body>
</html>