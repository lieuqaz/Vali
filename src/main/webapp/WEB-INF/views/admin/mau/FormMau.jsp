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


	<div class="container-fluid">

		<!-- Row input -->
		<div class="row">
			<div class="col-lg-3"></div>

			<div class="col-lg-6">
				<h1 style="text-align: center;">${formTitle}</h1>
				<form:form action="" method="POST" modelAttribute="mau">

					<div class="form-group">
						<label>Tên màu:</label>
						<form:input path="tenMau" class="form-control" />
						<form:errors path="tenMau" cssClass="error"></form:errors>
					</div>

					<button type="submit" class="btn btn-success">${formButton}</button>
					<button type="button" class="btn btn-danger" onClick="window.location.href='http://localhost:8081/websiteVali/admin/mau/danh-sach-mau'">Hủy</button>

				</form:form>

			</div>

			<div class="col-lg-3"></div>
		</div>
	<button onClick="window.location.href='http://localhost:8081/websiteVali/admin/mau/danh-sach-mau'" class="btn btn-success">Quay lại</button>




	</div>
	<!-- /.container-fluid -->
</body>
</html>