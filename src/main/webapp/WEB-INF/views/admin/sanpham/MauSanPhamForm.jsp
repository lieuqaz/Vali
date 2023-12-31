<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${formTitle}</title>

<link rel="stylesheet"
	href='<c:url value ="/static/assets/css/errors.css"/>'>
</head>
<body>

	<div class="container-fluid "
		style="background-color: #fff; padding: 20px 20px;">
	<button onClick="window.location.href='http://localhost:8081/websiteVali/admin/san-pham/xem-chi-tiet?id=${ mauSanPhamDTO.maSanPham }'" class="btn btn-success">Quay lại</button>
	
		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>
			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>

				<form:form action="" method="POST" modelAttribute="mauSanPhamDTO"
					enctype="multipart/form-data">

					<div class="form-group">
						<label>Màu:</label>
						<select id="maMau" name="maMau"
										class="form-control">
										<c:forEach items="${ maus }" var="mau">
											<option value="${mau.id}">${mau.tenMau}</option>
										</c:forEach>
									</select>
					</div>
					<div class="form-group">
						<label>Số lượng:</label>
						<form:input path="soLuong" class="form-control" />
						<form:errors path="soLuong" cssClass="error"></form:errors>
					</div>

					<div class="form-group">
						<label>Chọn ảnh:</label> <input type="file" name="hinhAnh"
							multiple="multiple" />
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="reset" class="btn btn-danger">Hủy</button>

				</form:form>


			</div>

			<div class="col-lg-3"></div>
		</div>





	</div>
	<!-- /.container-fluid -->
</body>
</html>